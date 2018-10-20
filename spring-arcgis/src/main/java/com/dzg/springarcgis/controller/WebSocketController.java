package com.dzg.springarcgis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller
public class WebSocketController {

    @RequestMapping("/ws")
    public String login() {
        return "websocket/index";
    }
    @RequestMapping("/wso")
    public String loginSecond() {
        return "websocket/index2";
    }
}
