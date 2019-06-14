package com.ak.framework.config;

import java.util.List;
import java.util.Map;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.ak.framework.util.RedisObjectSerializer;

import redis.clients.jedis.JedisPoolConfig;

@Configuration
@EnableAutoConfiguration
public class RedisConfig extends CachingConfigurerSupport {

	// private static Logger logger = Logger.getLogger(RedisConfig.class);

	@Bean
	@ConfigurationProperties(prefix = "spring.redis")
	public JedisPoolConfig getRedisConfig() {
		return new JedisPoolConfig();
	}

	@Bean
	@ConfigurationProperties(prefix = "spring.redis")
	public JedisConnectionFactory getConnectionFactory() {
		JedisPoolConfig config = getRedisConfig();
		return new JedisConnectionFactory(config);
	}

	@Bean
	public RedisTemplate<?, ?> getRedisTemplate() {
		RedisTemplate<String, List<Map<String, Object>>> template = new RedisTemplate<String, List<Map<String, Object>>>();
		template.setKeySerializer(new StringRedisSerializer());
		template.setValueSerializer(new RedisObjectSerializer());
		template.setConnectionFactory(getConnectionFactory());
		return template;
	}
}
