package com.dzg.springarcgis;

import com.dzg.springarcgis.netty.NettyServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
@MapperScan(value = "com.dzg.springarcgis.mapper")
@SpringBootApplication
public class SpringArcgisApplication   {
//    @Autowired
//    NettyServer nettyServer;

    public static void main(String[] args) {
        SpringApplication.run(SpringArcgisApplication.class, args);
    }
//    @Override
//    public void run(String... args) throws Exception {
////        NettyServer nettyServer = context.getBean(NettyServer.class);
//        nettyServer.run();
//    }
}
