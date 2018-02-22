# WebSocketHandler

创建实现WebSocketHandler接口的websocket处理类,spring目前还提供了TextWebSocketHandler 和 BinaryWebSocketHandler 两个实现类,也可以直接继承.

```java
@Component
public class MyWebSocketHandler implements WebSocketHandler {

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean supportsPartialMessages() {
		// TODO Auto-generated method stub
		return false;
	}

}
```

# 配置

创建名为WebSocketConfig的配置类,将WebSocket handler映射到特定的URL上,记得在配置文件中配置对此类的自动扫描



```java
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(myHandler(), "/myHandler");
    }

    @Bean
    public WebSocketHandler myHandler() {
        return new MyHandler();
    }

}
```

The above is for use in Spring MVC applications and should be included in the configuration of a DispatcherServlet. However, Spring’s WebSocket support does not depend on Spring MVC. It is relatively simple to integrate a WebSocketHandler into other HTTP serving environments with the help of WebSocketHttpRequestHandler.


# WebSocket Handshake

在调用handler前后编写需要的逻辑代码

he easiest way to customize the initial HTTP WebSocket handshake request is through a HandshakeInterceptor, which exposes "before" and "after" the handshake methods. Such an interceptor can be used to preclude the handshake or to make any attributes available to the WebSocketSession. For example, there is a built-in interceptor for passing HTTP session attributes to the WebSocket session:

```java
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new MyHandler(), "/myHandler")
            .addInterceptors(new HttpSessionHandshakeInterceptor());
    }

}
```

A more advanced option is to extend the DefaultHandshakeHandler that performs the steps of the WebSocket handshake, including validating the client origin, negotiating a sub-protocol, and others. An application may also need to use this option if it needs to configure a custom RequestUpgradeStrategy in order to adapt to a WebSocket server engine and version that is not yet supported (also see Deployment for more on this subject). Both the Java-config and XML namespace make it possible to configure a custom HandshakeHandler.


Spring provides a WebSocketHandlerDecorator base class that can be used to decorate a WebSocketHandler with additional behavior. Logging and exception handling implementations are provided and added by default when using the WebSocket Java-config or XML namespace. The ExceptionWebSocketHandlerDecorator catches all uncaught exceptions arising from any WebSocketHandler method and closes the WebSocket session with status 1011 that indicates a server error.

# Deployment


# Server config

For Jetty, you’ll need to supply a pre-configured Jetty WebSocketServerFactory and plug that into Spring’s DefaultHandshakeHandler through your WebSocket Java config:

```java
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(echoWebSocketHandler(),
            "/echo").setHandshakeHandler(handshakeHandler());
    }

    @Bean
    public DefaultHandshakeHandler handshakeHandler() {

        WebSocketPolicy policy = new WebSocketPolicy(WebSocketBehavior.SERVER);
        policy.setInputBufferSize(8192);
        policy.setIdleTimeout(600000);

        return new DefaultHandshakeHandler(
                new JettyRequestUpgradeStrategy(new WebSocketServerFactory(policy)));
    }

}
```

## HandshakeHandler

用来处理websocket的握手连接,类AbstractHandshakeHandler实现来HandshakeHandler接口,HandshakeHandler接口是用来Contract for processing a WebSocket handshake request.

# Allowed origins

```java

```
```java

```
```java

```
```java

```
