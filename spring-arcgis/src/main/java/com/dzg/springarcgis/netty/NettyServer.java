package com.dzg.springarcgis.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @param
 * @author dzg
 * @date 2018/10/18
 * @return
 */
@Service("nettyServer")
@Slf4j
public class NettyServer {
    private static final int port = 8088;// 设置服务端端口
    //        定义一对线程组
//        主线程组, 用于接受客户端的连接，但是不做任何处理，跟老板一样，不做事
    private static EventLoopGroup boss = new NioEventLoopGroup();// 通过nio方式来接收连接和处理连接
    //        从线程组, 老板线程组会把任务丢给他，让手下线程组去做任务
    private static EventLoopGroup work = new NioEventLoopGroup();
    //        netty服务器的创建，serverBootstrap是一个启动类
    private static ServerBootstrap b = new ServerBootstrap();
    public boolean result = false;
    @Autowired
    private NettyServerFilter nettyServerFilter;

    public void run() {
        try {
            b.group(boss, work)                             //设置主从线程组
                    .channel(NioServerSocketChannel.class)  //设置nio的双向通道
                    .childHandler(nettyServerFilter);       //设置过滤器
            // 启动server，并且设置8088为启动的端口号，同时启动方式为同步
            ChannelFuture f = b.bind(port).sync();
            System.out.println("服务端启动成功,端口是:" + port);
            result = true;
            // 监听服务器关闭监听(线程会阻塞在此)
            f.channel().closeFuture().sync();

        } catch (InterruptedException e) {
            log.error("netty服务器发生错误:" + e);
        } finally {
            boss.shutdownGracefully();
            work.shutdownGracefully();
        }
    }
}
