package com.aaa.lyf.base;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author: LYF MESSI
 * @Date: 2020/7/9 15:12
 * @Description:     通过接口返回值
 *       也就是说把后端的controller的返回值统一了
 *
 *     T:
 *       所谓的泛型说白了就相当于一个占位符
 * @version: 1.0
 */

@Data
@Accessors(chain = true )
public class ResultData<T> implements Serializable {

    private String code;
    private String msg;
    private String detail;
    private T data;
}
