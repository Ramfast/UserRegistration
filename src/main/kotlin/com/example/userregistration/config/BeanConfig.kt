package com.example.userregistration.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory
import org.springframework.data.redis.connection.RedisPassword
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import org.springframework.data.redis.connection.RedisStandaloneConfiguration


@Configuration
class BeanConfig {
    @Autowired
    private lateinit var env: Environment

    val defualtHost = "127.0.0.1"
    val defaultPort = 6379
    val defaultPassword = ""

    @Bean
    internal fun jedisConnectionFactory(): JedisConnectionFactory {
        val redisStandaloneConfiguration = RedisStandaloneConfiguration(
                env.getProperty("spring.redis.host") ?: defualtHost,
                env.getProperty("spring.redis.port")?.toInt() ?: defaultPort
        )
        redisStandaloneConfiguration.password = RedisPassword.of(env.getProperty("spring.redis.password") ?: defaultPassword)
        return JedisConnectionFactory(redisStandaloneConfiguration)
    }

    @Bean
    fun redisTemplate(): RedisTemplate<*, *> {
        val template = RedisTemplate<Any, Any>()
        template.setConnectionFactory(jedisConnectionFactory())
        return template
    }
}