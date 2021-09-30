package com.zx.demo.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zx.demo.fallback.CommonBlockHandler;
import com.zx.demo.model.po.UserInfo;
import com.zx.demo.service.biz.UserInfoService;
import com.zx.demo.service.feign.ConsumerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shenyu.client.springcloud.annotation.ShenyuSpringCloudClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author zhaoxu
 * @Description 测试类
 * @date 2021/8/20-2:52 下午
 */

@Slf4j
@Api(tags = "用户测试接口")
@RestController
@RequestMapping("/test")
@RefreshScope
@ShenyuSpringCloudClient(path = "/test")
public class TestController {

    @Value(value = "${test.config}")
    private String testConfig;
    @Resource
    private ConsumerService consumerService;

    @Resource
    private UserInfoService userInfoService;


    @GetMapping("/test")
    @ShenyuSpringCloudClient(path = "/test")
    @SentinelResource(value="test", blockHandler = "blockHancler", blockHandlerClass = CommonBlockHandler.class, fallback = "helloFallback")
    public String test() {
        log.info("测试日志链");
        return testConfig;
    }

    // Fallback 函数，函数签名与原函数一致或加一个 Throwable 类型的参数.
    public static String helloFallback() {
        return String.format("Halooooo %d", "aaa");
    }

    // Block 异常处理函数，参数最后多一个 BlockException，其余与原函数一致.
    public static String exceptionHandler(BlockException ex) {
        // Do some log here.
        ex.printStackTrace();
        return "Oops, error occurred at " + ex.getMessage();
    }

    @GetMapping("/testConsumer")
    @ShenyuSpringCloudClient(path = "/testConsumer")
    @SentinelResource(value="testConsumer", blockHandler = "testConsumerHandler", blockHandlerClass = CommonBlockHandler.class, fallback = "helloFallback")
    public String testConsumer(@RequestParam(value = "test") String test) {
        log.info("测试日志链");
        return testConfig + test + consumerService.test();
    }

    @GetMapping("/testConsumer1")
    @ShenyuSpringCloudClient(path = "/testConsumer1")
    @SentinelResource(value="testConsumer1", blockHandler = "testConsumerHandler", blockHandlerClass = CommonBlockHandler.class, fallback = "helloFallback")
    public String testConsumer1(@RequestParam(value = "test") String test) {
        log.info("测试日志链");
        return testConfig + test + consumerService.test();
    }

    @PostMapping("/testTransaction")
    @ShenyuSpringCloudClient(path = "/testConsumer1")
    @ApiOperation(value = "更新用户信息",notes = "更新用户信息")
    public String testTransaction(@RequestBody UserInfo userInfo) {
        userInfoService.updateUserInfo(userInfo);
        return "success";
    }

    @GetMapping("/getUserById")
    @ShenyuSpringCloudClient(path = "/getUserById")
    @ApiOperation(value = "用户id查询用户信息",notes = "用户id查询用户信息")
    public UserInfo testTransaction(@RequestParam(value = "id") Integer id) {
        return userInfoService.selectUserInfoById(id);
    }
}
