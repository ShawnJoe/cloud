package com.zx.demo.controller;

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
//        Thread.sleep(3000);
        return testConfig;
    }
}
