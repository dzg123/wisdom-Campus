package com.dzg.springarcgis.websocket;

import com.dzg.springarcgis.config.MyEndpointConfigure;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@ServerEndpoint(value = "/websocket/{id}", configurator = MyEndpointConfigure.class)
@Component
@Scope(value = "prototype")
public class WebSocketServer {

    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;
    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
//    private static CopyOnWriteArrayList<WebSocketServer> webSocketSet = new CopyOnWriteArrayList<>();
    public static ConcurrentHashMap<Integer, WebSocketServer> webSocketSet = new ConcurrentHashMap<>();
    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;
    public static Integer id ;

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(@PathParam(value = "id") Integer id, Session session) {
        this.id = id;//接收到发送消息的人员编号
        this.session = session;
        webSocketSet.put(id, this);
        addOnlineCount();
        log.info("有新连接加入！当前请求定位人数为:" + getOnlineCount());
        try {
            sendMessage("用户" + id + ":连接成功");
        } catch (Exception e) {
            log.error("websocket IO异常");
        }
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        webSocketSet.remove(this);
        subOnlineCount();
        log.info("有一连接关闭！当前在线人数为" + getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("来自GIS系统的信息：" + message);
        //可以自己约定字符串内容，比如 内容|0 表示信息群发，内容|X 表示信息发给id为X的用户
        String sendMessage = message.split("[|]")[0];
        String sendUserId = message.split("[|]")[1];

        if (sendUserId.equals("0"))
            sendToAll(sendMessage);
        else
            sendToUser(sendMessage, Integer.valueOf(sendUserId));


    }

    /**
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("发生错误" + error.getMessage());
    }

    public void sendMessage(String message) throws Exception {
//        locationService=SpringUtil.getBean(LocationServiceImpl.class);
        if (!message.contains("state")) {
            session.getBasicRemote().sendText(message);
            return;
        }
//        ExecutorService threadPool = Executors.newFixedThreadPool(100);
//        Runnable task = new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    System.out.println("要发送的消息：" + message);
//
//                    session.getBasicRemote().sendText(message);
//                } catch (Exception e) {
//                    System.out.println("发生错误：" + e);
//                }
//
//            }
//        };
//        threadPool.submit(task);
        session.getBasicRemote().sendText(message);
    }

    /**
     * 发送信息给指定ID用户，如果用户不在线则返回不在线信息给自己
     *
     * @param message
     * @param sendUserId
     * @throws IOException
     */
    public void sendToUser(String message, Integer sendUserId) {
        if (webSocketSet.get(sendUserId) != null) {
            try {
                if (!id.equals(sendUserId)) {
                    webSocketSet.get(sendUserId).sendMessage("用户" + id + "发来消息：" + " <br/> " + message);

                } else {
                    webSocketSet.get(sendUserId).sendMessage(message);
                }
            } catch (Exception e) {
                log.error("发生错误:" + e);
            }
        } else {
            log.info("当前用户不在线或不存在");
            sendToUser("当前用户不在线", id);
        }

    }

    /**
     * 发送信息给所有人
     *
     * @param message
     * @throws IOException
     */
    public static void sendToAll(String message) {
        log.info(message);
        for (Integer key : webSocketSet.keySet()) {
            try {
                webSocketSet.get(key).sendMessage(message);
            } catch (Exception e) {
                log.error("发送坐标出错：" + e);
                continue;
            }
        }
    }

    private static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    private static synchronized int getOnlineCount() {
        return onlineCount;
    }

    private static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }
}
