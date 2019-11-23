package people;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
class AppConfig {

  @Bean
  public LettuceConnectionFactory redisConnectionFactory() {
    return new LettuceConnectionFactory(new RedisStandaloneConfiguration("127.0.0.1", 6379));
  }

  @Bean
  public RedisTemplate<?, ?> redisTemplate() {
      RedisTemplate<byte[], byte[]> template = new RedisTemplate<>();
      template.setConnectionFactory(redisConnectionFactory());
      return template;
  }

}

