package com.zx.demo.config;

//import org.redisson.Redisson;
//import org.redisson.api.RedissonClient;
//import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author zhaoxu
 * @Description TODO
 * @date 2021/9/18-10:04 上午
 */

//@Configuration
public class RedissionConfig {


    @Value("${redission.redis-server}")
    private String redisServer;

    @Value("${redission.redis-mode}")
    private String redisMode;

    private static final String SINGLE = "single";

    private static final String SENTINEL = "sentinel";

    private static final String CLUSTER = "cluster";

//    @Bean
//    public RedissonClient redisson() throws IOException {
//        switch(redisMode) {
//            case SINGLE:
//                return getSingleRedissionClient();
//            case SENTINEL:
//                return getSentinelRedissionClient();
//            case CLUSTER :
//                return getClusterRedissionClient();
//            default:
//                return getSingleRedissionClient();
//        }
//    }
//
//    private RedissonClient getSingleRedissionClient() {
//        Config config = new Config();
//
//        config.useSingleServer()
//                .setAddress(redisServer);
//        return Redisson.create(config);
//    }
//
//    private RedissonClient getSentinelRedissionClient() {
//        Config config = new Config();
//        config.useSentinelServers().setMasterName("master").addSentinelAddress(redisServer.split(","));
//
//        return Redisson.create(config);
//    }
//
//    private RedissonClient getClusterRedissionClient() {
//        Config config = new Config();
//
//        config.useClusterServers().addNodeAddress(redisServer.split(","));
//        return Redisson.create(config);
//    }
}
