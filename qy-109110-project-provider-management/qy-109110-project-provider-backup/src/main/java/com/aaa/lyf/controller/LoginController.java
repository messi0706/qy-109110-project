package com.aaa.lyf.controller;

import com.aaa.lyf.base.BaseService;
import com.aaa.lyf.base.CommonController;
import com.aaa.lyf.base.ResultData;
import com.aaa.lyf.model.User;
import com.aaa.lyf.service.LoginService;
import com.aaa.lyf.vo.TokenVo;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.aaa.lyf.status.LoginStatus.*;

/**
 * @Author: LYF MESSI
 * @Date: 2020/7/15 19:08
 * @version: 1.0
 * @Description:
 */
@RestController
public  class LoginController extends CommonController<User> {

    @Autowired
    private LoginService loginService;

    @Override
    public BaseService<User> getBaseService(){
        return loginService;
    }
/**
 * @Author  LYF MESSI
 * @date: 2020/7/15 19:26
 * @description:
 * 执行登录操作
 * @param null
 * @return
 */

@PostMapping("/doLogin")
    public ResultData doLogin(@RequestBody User user) {
    TokenVo tokenVo = loginService.doLogin(user);
    if (tokenVo.getIfsuccess()) {
        return super.loginSuccess(tokenVo.getToken());
        }else if (tokenVo.getType() == 1) {
            return super.loginFailed(USER_NOT_EXIST.getMsg());
        }else if (tokenVo.getType() == 2) {
            return super.loginFailed(PASSWORD_WRONG.getMsg());
        } else {
            return super.loginFailed(SYSTEM_EXCEPTION.getMsg());
        }

    }
}