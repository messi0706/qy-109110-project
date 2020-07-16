package com.aaa.lyf.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author: LYF MESSI
 * @Date: 2020/7/15 20:18
 * @version: 1.0
 * @Description:
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class TokenVo implements Serializable {

    private  String token;
    private  Boolean ifsuccess;
    /**
     * 1.账号不存在
     * 2.密码错误
     * 3.账号被锁定
     * 4.系统异常
     */
    private  Integer type;
}
