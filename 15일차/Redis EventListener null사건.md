옛날에 redis eventListener를 이렇게 썼다고 했다.
```java
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

# 문제상황
* 문제는 이렇게 해놓고 keyExpiredListener에서 onMessage내부에서 다른 스프링 service를 @Autowired로 쓰려고 하니까 자꾸 null 오류가 났다....
* 왜일까 분석을 했는데, 이 글이 도움이 됐다. [스택오버플로우](https://stackoverflow.com/questions/37479866/spring-autowired-field-is-null-inside-an-overrided-method)

---
config에서 keyExpiredListener를 new해서 만들어줘버리니까 자꾸 객체를 새로 생성하게되어서 스프링에서 빈을 인식 못하는 것 같았다.

이후 이렇게 코드를 바꿔주었다.

```java
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
  
  @Autowired
  private KeyExpiredListener = keyExpiredListener;
	
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
		container.addMessageListener(keyExpiredListener, topic);
		return container;
	}
}
```
자세히 기억은 안나는데 이렇게 미리 Autowired로 선언해주고 그것을 컨테이너에 addMessageListener에 인자로 넣어주어야 한다.
그래야지 keyExpiredListener의 onMessage함수에서 또 @Autowired해준것을 쓸 수 있다.

스프링 공부를 열심히 해야되겠다 정말..
