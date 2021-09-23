package com.zx.demo.dao;

import com.zx.demo.model.po.UserInfo;

/**
 * 用户信息映射器
 *
 * @author zhaoxu
 * @date 2021/09/10
 */
public interface UserInfoMapper {
    /**
     * 按主键删除
     *
     * @param @param cId c id
     * @return @return int
     * @urlPath /$SIMPLECLASSCLASS/$methodName$
     */
    int deleteByPrimaryKey(Integer cId);

    /**
     * 插入
     *
     * @param @param record 记录
     * @return @return int
     * @urlPath /$SIMPLECLASSCLASS/$methodName$
     */
    int insert(UserInfo record);

    /**
     * 插入选择性
     *
     * @param @param record 记录
     * @return @return int
     * @urlPath /$SIMPLECLASSCLASS/$methodName$
     */
    int insertSelective(UserInfo record);


    /**
     * 更新用户信息通过id
     *
     * @param @param id id
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
}