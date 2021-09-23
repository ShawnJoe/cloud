package com.zx.demo.service.biz.impl;

import com.alibaba.fastjson.JSONObject;
import com.zx.demo.common.ResultEnum;
import com.zx.demo.dao.UserInfoMapper;
import com.zx.demo.exception.BaseException;
import com.zx.demo.model.po.UserInfo;
import com.zx.demo.service.biz.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Optional;

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
    public void updateUserInfoById(UserInfo userInfo) {
        userInfoMapper.updateUserInfoById(userInfo);
    }

    @Override
    @Cacheable(value = {"test", "user-center:userInfo"}, key = "#id")
    public UserInfo selectUserInfoById(Integer id) {
        return userInfoMapper.selectUserInfoById(id);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    @CacheEvict(value = {"test", "user-center:userInfo"}, key = "#userInfo.id")
    public void updateUserInfo(UserInfo userInfo) {
        log.info("UserInfoServiceImpl#updateUserInfo,param={}", JSONObject.toJSONString(userInfo));
        userInfo = Optional.ofNullable(userInfo).orElseThrow(() -> new BaseException(ResultEnum.VALIDATE_FAILED));
        UserInfo info = selectUserInfoById(userInfo.getId());
        info = Optional.ofNullable(userInfo).orElseThrow(() -> new BaseException(500, "不存在对应用户"));
        info.setName(userInfo.getName());
        updateUserInfoById(userInfo);
        info = selectUserInfoById(userInfo.getId());
    }
}
