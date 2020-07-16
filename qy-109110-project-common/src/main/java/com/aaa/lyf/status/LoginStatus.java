package com.aaa.lyf.status;



/**
 * @Author: LYF MESSI
 * @Date: 2020/7/9 15:17
 * @Description: TODO
 * @version: 1.0
 */
public enum LoginStatus {

    LOGIN_SUCCESS("200","登陆成功"),
    LOGIN_FAILED("400","登录失败，系统异常"),
    LOGIN_EXIST("201","用户已存在"),
    USER_NOT_EXIST("401","用户不存在"),
    PASSWORD_WRONG("402","密码错误"),
    LOGIN_WRONG("405","用户退出异常"),
    LOGOUT_WRONG("405", "用户退出异常"),
    SYSTEM_EXCEPTION("406", "系统异常");


    LoginStatus(String code, String msg){
        this.code =code;
        this.msg = msg;

    }

    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }


}
