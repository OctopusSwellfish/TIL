## Redis에서 키 Expired됐을 때 이벤트 발생시키기

### 환경 : Lettuce (따로 깔아준 것 redis외에 없음)

1. `redis-cli`에서 아래의 명령어를 써 준다.
`CONFIG SET nitifi-keyspace-events [option]`
e.g. `CONFIG SET notify-keyspace-events KEA`
  * K: keyspace 관련 설정

  * E: keyevent 관련 설정

  * A: 어떤 이벤트인지 받아오는 설정(A같은 경우는 전부)
  
2. pom.xml 
```xml
        <!-- redis -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-redis</artifactId>
        </dependency>

        <!-- lettuce(Redis) -->
        <dependency>
			<groupId>io.lettuce</groupId>
			<artifactId>lettuce-core</artifactId>
 			<version>6.0.2.RELEASE</version>
		</dependency>	
```

3. RedisConfig.java
```java
package com.a101.ssafy.project.config;

import java.time.Duration;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.Topic;

import com.a101.ssafy.project.eventlistener.KeyExpiredListener;

@Configuration
public class RedisConfig {
	@Value("${redis.hostname}")
	private String hostName;
	
	@Value("${redis.port}")
	private int port;
	
	@Bean
	public LettuceConnectionFactory lettuceConnectionFactory() {
		LettuceClientConfiguration lettuceClientConfiguration = LettuceClientConfiguration.builder()
				.commandTimeout(Duration.ofMinutes(1)) //connection time out
				.shutdownTimeout(Duration.ZERO) //redis client가 graceful 하게 close 될때까지의 timeout 설정(0일경우 제한 X)
				.build();
		
		RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(hostName, port);
		//redisStandaloneConfiguration.setPassword({password});
		
		return new LettuceConnectionFactory(redisStandaloneConfiguration, lettuceClientConfiguration);
	}
	
	@Bean
	public RedisMessageListenerContainer getListenerContainer() {
		//create connection container
		RedisMessageListenerContainer container = new RedisMessageListenerContainer();
		
		//put in redis connection
		container.setConnectionFactory(lettuceConnectionFactory());
		Topic topic = new PatternTopic("__keyevent@0__:expired");
		container.addMessageListener(new KeyExpiredListener(), topic);
		return container;
	}
}
```

4. application.properties

```redis.listen-pattern = __keyevent@0__:expired```
* 여기서 @0 에서 `0`은 사용하는 DB번호를 말한다. 기본적으로 0으로 설정되어있는 듯 하다. 원하면 다른것으로 변경

5. KeyExpiredListener.java
```java
package com.a101.ssafy.project.eventlistener;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

public class KeyExpiredListener implements MessageListener{

	//message: redis 에서 반환 한 알림
	//body: timeout 키의 이름
	//channel: timeout 이벤트
	@Override
	public void onMessage(Message message, byte[] pattern) {
		byte[] body = message.getBody();
		byte[] channel = message.getChannel();
		System.out.println("Message>>>>>>>");
		System.out.println(new String(body));
//		System.out.println(new String(channel));
	
		System.out.println("<<<<<<<<<<<<<<");
	}
 
}

```
