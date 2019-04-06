# netty
### 本项目基于Arcgis平台，结合传统JavaWeb的SpringBoot、SSM、Netty、ActiveMQ等框架，通过网络通信协议ProtoBuf、Grpc完成异构语言异构平台的互相调用，辅以CityEngine、ArcgisPro等软件来实现智慧三维校园系统子模块——校园实时位置获取以及分析服务。
1. 使用Netty框架，由于其完美封装了传统JDK自带的NIO网络通信，支持很高的并发量，并绕过了传统NIO空轮询的bug，很好地契合了实时服务的需求。
2. 前端使用Vue、ArcGIS API for JavaScript、CityEngine以及ArcgisPro完成校园三维场景的构建、页面的布局、数据的渲染等功能。
3. 使用中间件技术ActiveMQ来使本子模块与Android端消息通知解耦，异步通知校园师生即将迟到等情况。
4. 使用谷歌开发的网络通信协议Grpc来实现多种校园数据的实时传输，以及跨语言调用C++算法代码实现数据分析服务调用。


