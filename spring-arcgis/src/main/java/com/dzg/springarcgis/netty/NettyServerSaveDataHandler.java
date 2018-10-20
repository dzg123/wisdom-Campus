package com.dzg.springarcgis.netty;

import com.dzg.springarcgis.domain.Location;
import com.dzg.springarcgis.protobuf.CoordinateInfo;
import com.dzg.springarcgis.service.LocationService;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("nettyServerSaveDataHandler")
@ChannelHandler.Sharable
@Slf4j
public class NettyServerSaveDataHandler extends ChannelInboundHandlerAdapter {
    @Autowired
    LocationService locationService;
    Location location=new Location();
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("进入数据存储处理器");
        super.channelActive(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        CoordinateInfo.CoordinateMsg coordinateMsg = (CoordinateInfo.CoordinateMsg) msg;
        location.setUserId(coordinateMsg.getUserId());
        location.setState(coordinateMsg.getState());
        location.setTime(new Date());
        location.setCoordinate(coordinateMsg.getCoordinate());
        locationService.insertLocation(location);
        super.channelRead(ctx, msg);
    }


}
