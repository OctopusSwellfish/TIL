# WebSocket CORS 오류
* 상황
  * websocket을 spring boot와 vue에 동시에 사용하고 있었다.
  * spring boot내부의 코드에서는 당연히 cors 안 났는데 vue에서는 오류가 나는 상황
  * 모든 방법에 구글링 해도 안됐다.

---
# 해결 방법
* `WebSocketConfig` 파일을 다음과 같이 수정해주었다.
```java
package com.a101.ssafy.project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker //websocket 서버를 활용하는데 사용
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{
	
	//SockJS ==> 웹 소켓을 지원하지 않는 브라우저에 폴백 옵션을 활성화하는 데 사용(Fallback: 기능이 동작하지 않을 때 이에 대처하는 기능)
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/ws").setAllowedOriginPatterns("*").withSockJS(); //이 부분이 중요
	}
	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.setApplicationDestinationPrefixes("/app");
		//"/{prefix}"로 시작되는 메시지가 message-handling methods로 라우팅 되어야 함
		
		registry.enableSimpleBroker("/topic");
		//"/{주소}"로 시작되는 메시지가 메시지 브로커로 라우팅 되도록 정의
		//메시지 브로커는 특정 주제를 구독한 연결된 모든 클라이언트에게 메시지를 broadcast함
	}
}
```

* `registry.addEndpoint("/ws").setAllowedOriginPatterns("*").withSockJS();` 이 부분이 중요했는데, 그냥 `setAllowedOrigin`만 쓰면 안되고 `setAllowedOriginPatterns`를 해야했다!
* 둘의 차이점은 정확히는 모르겠으나 후자의 함수가 좀더 유연하게 cors 대처가 가능하다고 한다.
* websocket을 처음 도입해서 겪는 오류가 많았는데 일단 해결해서 다행이다.

