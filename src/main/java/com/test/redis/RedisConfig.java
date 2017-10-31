package com.test.redis;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration /*相当于一个配置文件,spring一旦扫描到这个类,会在这个类中把所有方法返回的对象当成对象对待*/
@EnableCaching  //开启缓存支持
public class RedisConfig {

    @Bean   //把这个方法返回的对象交给spring管理 和 @Configuration 配合使用
    public JedisConnectionFactory createFactory(){
        //生成对象
        JedisConnectionFactory factory = new JedisConnectionFactory();
        //主机地址
        factory.setHostName("127.0.0.1");
        //设置端口号
        factory.setPort(6379);
        return factory;
    }
    @Bean
    //RedisTemplateTemplate 模板,spring用来访问redis的类,封装了增删改查的方法
    public RedisTemplate<String,String> createTemplate(JedisConnectionFactory factory){
        RedisTemplate<String,String> template = new RedisTemplate<String, String>();
        template.setConnectionFactory(factory);
        return template;
    }

    @Bean   //这个是缓存管理器方法
    public RedisCacheManager createCache(RedisTemplate<String,String> template){
        return new RedisCacheManager(template);
    }
}
