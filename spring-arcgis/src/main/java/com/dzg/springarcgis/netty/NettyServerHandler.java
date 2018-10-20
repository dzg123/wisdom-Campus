package com.dzg.springarcgis.netty;

import com.dzg.springarcgis.domain.Location;
import com.dzg.springarcgis.mapper.LocationMapper;
import com.dzg.springarcgis.protobuf.CoordinateInfo;
import com.dzg.springarcgis.util.SpringUtil;
import com.dzg.springarcgis.websocket.WebSocketServer;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.DefaultHttpRequest;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.Timer;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service("nettyServerHandler")
@ChannelHandler.Sharable
public class NettyServerHandler extends ChannelInboundHandlerAdapter {
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

    /**
     * 建立连接时，发送一条消息
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        String remoteIp = ctx.channel().remoteAddress().toString();
        System.out.println("连接的客户端地址:" + remoteIp);
        String ipLocal = remoteIp.substring(1);
        ip.put(WebSocketServer.id, ipLocal);
        CoordinateInfo.CoordinateMsg coordinateMsg = CoordinateInfo.CoordinateMsg.newBuilder()
                .setUserId(22)
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
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (!(msg instanceof CoordinateInfo.CoordinateMsg)) {
            System.out.println("未知数据!" + msg);
            return;
        }
        try {
//            if (msg instanceof DefaultHttpRequest) {
//                System.out.println("请求头过滤");
//                DefaultHttpRequest request = (DefaultHttpRequest) msg;
//                System.out.println("request:" + request.toString());
//                return;
//            }
            CoordinateInfo.CoordinateMsg coordinateMsg = (CoordinateInfo.CoordinateMsg) msg;
            System.out.println("第" + count + "次" + ",服务端接受的消息:" + msg);


            webSocketServer = WebSocketServer.webSocketSet.get(WebSocketServer.id);
            webSocketServer.sendMessage("userId:"+coordinateMsg.getUserId()+
                    ",coordinate:"+coordinateMsg.getCoordinate()+",state:"+coordinateMsg.getState());
            // 通知执行下一个InboundHandler
            ctx.fireChannelRead(msg);
//            Runnable runnable = new Runnable() {
//                @Override
//                public void run() {
//                    try {
////                        webSocketServer.sendMessage(String.valueOf(msg));
//                        System.out.println("id:" + WebSocketServer.id);
//                        webSocketServer.sendMessage(String.valueOf(System.currentTimeMillis()));
//                        //    webSocketServer.sendToUser(String.valueOf(System.currentTimeMillis()),WebSocketServer.id);
//                    } catch (Exception e) {
//                        System.out.println("发生错误:" + e);
//                    }
//                }
//            };
//            ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
//            service.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.SECONDS);


        } finally {
            ReferenceCountUtil.release(msg);
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
