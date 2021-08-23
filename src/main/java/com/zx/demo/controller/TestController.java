package com.zx.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.shenyu.client.springcloud.annotation.ShenyuSpringCloudClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaoxu
 * @Description TODO
 * @date 2021/8/20-2:52 下午
 */

@Slf4j
@RestController
@RequestMapping("/test")
@RefreshScope
@ShenyuSpringCloudClient(path = "/test")
public class TestController {

    @Value(value = "${test.config}")
    private String testConfig;

    @GetMapping("/test")
    @ShenyuSpringCloudClient(path = "/test")
    public String test() {
        log.info("测试日志链");
//        Thread.sleep(3000);
        return testConfig;
    }
}
