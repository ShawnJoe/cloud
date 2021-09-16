package com.zx.demo.service.biz.impl;

import com.zx.demo.dao.UserInfoMapper;
import com.zx.demo.model.po.UserInfo;
import com.zx.demo.service.biz.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author zhaoxu
 * @Description TODO
 * @date 2021/9/13-3:04 下午
 */


@Slf4j
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateUserInfoById(Integer id) {
        userInfoMapper.updateUserInfoById(id);
    }

    @Override
    @Cacheable(value = "user-center:userInfo:", key = "#{id}")
    public UserInfo selectUserInfoById(Integer id) {
        return userInfoMapper.selectUserInfoById(id);
    }
}
