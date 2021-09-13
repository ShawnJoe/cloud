package com.zx.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author zhaoxu
 * @Description TODO
 * @date 2021/9/13-9:34 上午
 */

@Slf4j
@Configuration
@EnableCaching
public class RedisConfig {


   @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
       RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();

       redisTemplate.setConnectionFactory(factory);
       redisTemplate.setKeySerializer(new StringRedisSerializer());
       redisTemplate.setValueSerializer(new StringRedisSerializer());
       return redisTemplate;
   }

}
