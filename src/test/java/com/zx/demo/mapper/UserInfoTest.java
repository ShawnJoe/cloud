package com.zx.demo.mapper;

import com.alibaba.fastjson.JSONObject;
import com.zx.demo.DemoApplicationTests;
import com.zx.demo.dao.UserInfoMapper;
import com.zx.demo.model.po.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * @author zhaoxu
 * @Description TODO
 * @date 2021/9/10-3:16 下午
 */

@Slf4j
public class UserInfoTest extends DemoApplicationTests {

    @Resource
    private UserInfoMapper userInfoMapper;
    @Resource
    private RedisTemplate redisTemplate;
    @Test
    public void insert() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(4);
        userInfoMapper.insert(userInfo);
        redisTemplate.opsForValue().set("user"+1, JSONObject.toJSONString(userInfo));
    }
}
