package com.zx.demo.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhaoxu
 * @Description 增加header 使sentinel授权规则的生效
 * @date 2021/9/16-4:31 下午
 */

@Configuration
public class FeignRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("S-user", "cloud-test");
    }
}
