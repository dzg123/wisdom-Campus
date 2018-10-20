package com.dzg.springarcgis;

import com.dzg.springarcgis.client.NettyClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class NettyclientApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(NettyclientApplication.class, args);
		NettyClient nettyClient = context.getBean(NettyClient.class);
		nettyClient.run();

	}
}
