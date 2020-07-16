package com.aaa.lyf.controller;

import com.aaa.lyf.base.BaseService;
import com.aaa.lyf.base.CommonController;
import com.aaa.lyf.model.LoginLog;
import com.aaa.lyf.model.User;
import com.aaa.lyf.service.LoginLogService;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: LYF MESSI
 * @Date: 2020/7/15 19:09
 * @version: 1.0
 * @Description:
 */
@RestController
public class LoginLogController extends CommonController<LoginLog> {

    @Autowired
    private LoginLogService loginLogService;

    @Override
    public BaseService<LoginLog> getBaseService(){
        return loginLogService;
    }

    /**
     * @Author  LYF MESSI
     * @date: 2020/7/15 19:14
     * @description:
     * 保存日志
     * @param null
     * @return
     */


    @PostMapping("/addLoginLog")
    public Integer addLoginLog(@RequestBody LoginLog loginLog){
        return getBaseService().add(loginLog);
    }

}
