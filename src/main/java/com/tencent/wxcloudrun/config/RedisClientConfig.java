package com.tencent.wxcloudrun.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisClientConfig {


//    @Bean
//    public RedissonClient getRedissionClient() {
//        //redisson配置
//        Config config = new Config();
//        SingleServerConfig singleSerververConfig = config.useSingleServer();
//        String server = "redis://" + redisHostName + ":" + redisPort;
//        singleSerververConfig.setAddress(server);
//        singleSerververConfig.setPassword(redisPassword);
//
//        singleSerververConfig.setConnectionMinimumIdleSize(8);
//
//        //redisson客户端
//        RedissonClient redissonClient = Redisson.create(config);
//        return redissonClient;
//    }
}
