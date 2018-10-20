package com.dzg.springarcgis.netty;

import com.dzg.springarcgis.protobuf.CoordinateInfo;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.timeout.IdleStateHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class NettyServerFilter extends ChannelInitializer<SocketChannel>{
    @Autowired
    private NettyServerHandler nettyServerHandler;
    @Autowired
    private NettyServerSaveDataHandler nettyServerSaveDataHandler;
    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        ChannelPipeline pipeline = channel.pipeline();
        //入参说明: 读超时时间、写超时时间、所有类型的超时时间、时间格式
        pipeline.addLast(new IdleStateHandler(5, 0, 0, TimeUnit.SECONDS));
        // 解码和编码，应和客户端一致
        //传输的协议 Protobuf
        pipeline.addLast(new ProtobufVarint32FrameDecoder());
        pipeline.addLast(new ProtobufDecoder(CoordinateInfo.CoordinateMsg.getDefaultInstance()));
        pipeline.addLast(new ProtobufVarint32LengthFieldPrepender());
        pipeline.addLast(new ProtobufEncoder());
        //业务逻辑实现类
        pipeline.addLast("nettyServerHandler", nettyServerHandler);
        pipeline.addLast("nettySaveDataHandler", nettyServerSaveDataHandler);
    }
}
