package com.zx.demo.service.biz;

import com.zx.demo.model.po.UserInfo;

public interface UserInfoService {

    /**
     * 更新用户信息通过id
     *
     * @param @param userInfo 用户信息
     * @return
     * @urlPath /$SIMPLECLASSCLASS/$methodName$
     */
    void updateUserInfoById(UserInfo userInfo);


    /**
     * 选择用户信息通过id
     *
     * @param @param id id
     * @return @return {@link UserInfo }
     * @urlPath /$SIMPLECLASSCLASS/$methodName$
     */
    UserInfo selectUserInfoById(Integer id);

    /**
     * 更新用户信息
     *
     * @param @param userInfo 用户信息
     * @return
     * @urlPath /$SIMPLECLASSCLASS/$methodName$
     */
    void updateUserInfo(UserInfo userInfo);
}
