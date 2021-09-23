package com.zx.demo.model.po;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户信息
 *
 * @author zhaoxu
 * @date 2021/09/10
 */
@Data
public class UserInfo implements Serializable {

    private Integer id;

    private String name;
}