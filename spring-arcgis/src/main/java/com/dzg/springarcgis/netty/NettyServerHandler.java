package com.dzg.springarcgis.netty;

import com.dzg.springarcgis.domain.Location;
import com.dzg.springarcgis.domain.User;
import com.dzg.springarcgis.enums.LocationOffset;
import com.dzg.springarcgis.mapper.LocationMapper;
import com.dzg.springarcgis.protobuf.CoordinateInfo;
import com.dzg.springarcgis.service.UserService;
import com.dzg.springarcgis.util.SpringUtil;
import com.dzg.springarcgis.vo.LocVO;
import com.dzg.springarcgis.vo.UserLocVO;
import com.dzg.springarcgis.websocket.WebSocketServer;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultHttpRequest;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.Timer;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service("nettyServerHandler")
@ChannelHandler.Sharable
@Slf4j
public class NettyServerHandler extends SimpleChannelInboundHandler<CoordinateInfo.CoordinateMsg> {
    /**
     * 空闲次数
     */
    private int idle_count = 1;
    /**
     * 发送次数
     */
    private int count = 1;
    private WebSocketServer webSocketServer;
    public static ConcurrentHashMap<String, String> ip = new ConcurrentHashMap<>();
    @Autowired
    UserService userService;

    /**
     * 建立连接时，发送一条消息
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        String remoteIp = ctx.channel().remoteAddress().toString();
        log.info("连接的客户端地址:" + remoteIp);


        CoordinateInfo.CoordinateMsg coordinateMsg = CoordinateInfo.CoordinateMsg.newBuilder()
                .setPhone("18094712785")
                .setState(0).build();
        ctx.writeAndFlush(coordinateMsg);
        super.channelActive(ctx);
    }

    /**
     * 超时处理 如果5秒没有接受客户端的心跳，就触发; 如果超过两次，则直接关闭;
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateHandler) {
            IdleStateEvent event = (IdleStateEvent) evt;
            if (IdleState.READER_IDLE.equals(event.state())) {// 如果读通道处于空闲状态，说明没有接收到心跳命令
                System.out.println("已经5秒没有接收到客户端的信息了");
                if (idle_count > 1) {
                    System.out.println("关闭这个不活跃的channel");
                    ctx.channel().close();
                }
                idle_count++;
            }
        } else {
            super.userEventTriggered(ctx, evt);
        }
    }

    /**
     * 业务逻辑处理
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, CoordinateInfo.CoordinateMsg coordinateMsg) throws Exception {
        try {
            String phone = coordinateMsg.getPhone();
            log.info("第" + count + "次" + ",服务端接受的消息:" + coordinateMsg);
            User user = null;
            if (phone != null && !"".equals(phone)) {
                String remoteIp = ctx.channel().remoteAddress().toString();
                String ipLocal = remoteIp.substring(1);
                ip.put(phone, ipLocal);
                user = userService.selectUserByPhone(phone);

            }
            if (user != null && !WebSocketServer.webSocketSet.isEmpty()) {
                UserLocVO userLocVO = new UserLocVO();
                LocVO locVO = new LocVO();
                String coordinate = coordinateMsg.getCoordinate();
                String[] split = coordinate.split("-");
                locVO.setLongitude(Double.valueOf(split[1]) - LocationOffset.LONGITUDE.getNum());
                locVO.setLatitude(Double.valueOf(split[0]) - LocationOffset.LATITUDE.getNum());
                userLocVO.setUserName(user.getUsername());
                userLocVO.setPhone(coordinateMsg.getPhone());
                userLocVO.setRole(user.getRole());
                userLocVO.setState(user.getState());
                userLocVO.setUserId(user.getId());
                userLocVO.setNickName(user.getNickname());
                userLocVO.setLocVO(locVO);
                ObjectMapper mapper = new ObjectMapper();
                String coordinateUser = mapper.writeValueAsString(userLocVO);
                /**************单点发送****************/
//                webSocketServer = WebSocketServer.webSocketSet.get(user.getId());
//                webSocketServer.sendMessage(coordinateUser);
                /***********************/
                WebSocketServer.sendToAll(coordinateUser);
//                webSocketServer.sendMessage("{\"phone\":" + "\"" + coordinateMsg.getPhone() + "\"" + ",\"userId\":" + "\"" +
//                        userId + "\"" + ",\"coordinate\":" + "\"" + coordinateMsg.getCoordinate() + "\""
//                        + ",\"state\":" + "\"" + coordinateMsg.getState() + "\"}");
                // 通知执行下一个InboundHandler
                ctx.fireChannelRead(coordinateMsg);
            } else {
                log.info("前端没有发起请求");
                ctx.fireChannelRead(coordinateMsg);
            }
        } catch (Exception e) {
            log.error("发生错误：{}", e.getMessage());
        }
        count++;
    }

    /**
     * 异常处理
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("netty服务器发生错误：" + cause);
        ctx.close();
    }
}
