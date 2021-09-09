package com.zx.demo.fallback;

import com.zx.demo.service.feign.ConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author zhaoxu
 * @Description TODO
 * @date 2021/9/7-2:39 下午
 */

@Slf4j
@Component
public class ConsumerFallBackHandler implements ConsumerService {

    @Override
    public String test() {
        return "发生熔断";
    }
}
