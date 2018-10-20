package com.dzg.springarcgis.controller;

import com.dzg.springarcgis.common.JsonData;
import com.dzg.springarcgis.netty.NettyServer;
import com.dzg.springarcgis.websocket.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NettyController {
    @Autowired
    NettyServer nettyServer;

    @GetMapping("/netty")
    public JsonData nettyStart() {
        nettyServer.run();
        if (nettyServer.result == true) {
            return JsonData.success("success", "netty服务器开启成功");
        } else {
            return JsonData.fail("netty服务器开启失败");
        }
    }
}
