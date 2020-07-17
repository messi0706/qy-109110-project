package com.aaa.lyf.controller;

import com.aaa.lyf.annotation.LoginAnnotation;
import com.aaa.lyf.base.BaseController;
import com.aaa.lyf.base.ResultData;
import com.aaa.lyf.model.User;
import com.aaa.lyf.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @Author lyf
 * @Date Create in 2020/7/15 9:14
 * @Description
 **/
@RestController
public class LoginController extends BaseController {

    @Autowired
    private IProjectService projectService;

    /**
     * @author lyf
     * @description
     *      执行登录操作
     * @param [user]
     * @date 2020/7/15
     * @return com.aaa.lyf.base.ResultData
     * @throws
    **/
    @PostMapping("/doLogin")
    @LoginAnnotation(opeationType = "登录操作", opeationName = "管理员登录")
    public ResultData doLogin(User user) {
        return projectService.doLogin(user);
    }

}
