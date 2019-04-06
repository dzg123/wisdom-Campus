package com.dzg.springarcgis.netty;

import com.dzg.springarcgis.domain.Location;
import com.dzg.springarcgis.protobuf.CoordinateInfo;
import com.dzg.springarcgis.service.LocationService;
import com.dzg.springarcgis.service.UserService;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Service("nettyServerSaveDataHandler")
@ChannelHandler.Sharable
@Slf4j
public class NettyServerSaveDataHandler extends ChannelInboundHandlerAdapter {
    @Autowired
    LocationService locationService;
    @Autowired
    UserService userService;
    Location location=new Location();
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        log.info("进入数据存储处理器");
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(10, 10,
                60L, TimeUnit.SECONDS,
                new ArrayBlockingQueue(10));
        poolExecutor.submit(() -> {
            CoordinateInfo.CoordinateMsg coordinateMsg = (CoordinateInfo.CoordinateMsg) msg;
            String phone = coordinateMsg.getPhone();

            int userId = 0;
            String userIp = "127.0.0.1";
            if (phone != null && !"".equals(phone)) {
                userId = userService.getIdByPhone(phone);
                userIp = String.valueOf(NettyServerHandler.ip.get(phone));
            }
            if (!"0.0-0.0".equals(coordinateMsg.getCoordinate())) {
                location.setUserId(userId);
                location.setState(coordinateMsg.getState());
                location.setTime(new Date());
//        location.setTime(new Date(coordinateMsg.getTime().getSeconds()*1000));
                location.setCoordinate(coordinateMsg.getCoordinate());
                location.setUserIp(userIp);
                locationService.insertLocation(location);
            }
        });
    }


}
