package com.zx.demo.fallback;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @author zhaoxu
 * @Description TODO
 * @date 2021/9/7-9:57 上午
 */

//@Slf4j
public class CommonBlockHandler {


    //返回值类型必须与原方法相同，参数类型需要和原方法匹配，并在最后加一个BlockException参数
    public static String blockHancler(BlockException ex) {
        return "500";
    }

    public static String testConsumerHandler(String test, BlockException ex) {
        return "发生熔断" + test;
    }

}
