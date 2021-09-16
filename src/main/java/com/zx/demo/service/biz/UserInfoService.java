package com.zx.demo.service.biz;

import com.zx.demo.model.po.UserInfo;

public interface UserInfoService {

    /**
     * 更新用户信息通过id
     *
     * @param @param id id
     * @return
     * @urlPath /$SIMPLECLASSCLASS/$methodName$
     */
    void updateUserInfoById(Integer id);


    /**
     * 选择用户信息通过id
     *
     * @param @param id id
     * @return @return {@link UserInfo }
     * @urlPath /$SIMPLECLASSCLASS/$methodName$
     */
    UserInfo selectUserInfoById(Integer id);
}
