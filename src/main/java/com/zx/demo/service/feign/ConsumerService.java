package com.zx.demo.service.feign;

import com.zx.demo.fallback.ConsumerFallBackHandler;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhaoxu
 * @Description TODO
 * @date 2021/9/7-2:32 下午
 */

@FeignClient(value = "consumer-test", fallback = ConsumerFallBackHandler.class)
public interface ConsumerService {

    @RequestMapping(value = "/test/test")
    String test();
}
