package com.aaa.lyf.base;

import static com.aaa.lyf.status.LoginStatus.*;
import static com.aaa.lyf.status.OperationStatus.*;

/**
 * @Author: LYF MESSI
 * @Date: 2020/7/9 15:15
 * @Description:    所有的controller都需要这个controller
 *
 *      eg:
 *          登录成功和失败
 *          code:200 msg:登录成功
 *          code:400 msg:登录失败，系统异常
 *          code:201 msg:用户已经存在
 *          code:401 msg:用户不存在
 *          code:402 msg:密码错误
 *          code:405 msg:用户退出异常
 * @version: 1.0
 */
public class BaseController {


    /**
     * @param null
     * @return
     * @Author LYF MESSI
     * @date: 2020/7/9 15:27
     * @description 登陆成功  使用系统消息
     */
    protected ResultData loginSuccess() {
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(LOGIN_SUCCESS.getMsg());

        return resultData;

    }



        /**
         * @Author  LYF MESSI
         * @date: 2020/7/9 15:27
         * @description 登陆成功  自定义返回消息
         * @param null
         * @return
         */
        protected  ResultData loginSuccess(String msg) {
            ResultData resultData = new ResultData();
            resultData.setCode(LOGIN_SUCCESS.getCode());
            resultData.setMsg(msg);

            return resultData;

        }


    /**
     * @Author  LYF MESSI
     * @date: 2020/7/9 15:27
     * @description 登陆成功  返回数据信息 使用系统消息
     * @param null
     * @return
     */
    protected  ResultData loginSuccess(Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(LOGIN_SUCCESS.getMsg());
        resultData.setData(data);

        return resultData;

    }
    /**
     * @Author  LYF MESSI
     * @date: 2020/7/9 15:27
     * @description 登陆成功  返回数据信息 自定义消息
     * @param null
     * @return
     */
    protected  ResultData loginSuccess(String msg,Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);

        return resultData;

    }
    /**
     * @Author  LYF MESSI
     * @date: 2020/7/9 15:27
     * @description 登陆失败  使用系统消息
     * @param null
     * @return
     */
    protected  ResultData loginFailed(){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_FAILED.getCode());
        resultData.setMsg(LOGIN_FAILED.getMsg());

        return resultData;

    }


    /**
     * @Author  LYF MESSI
     * @date: 2020/7/9 15:27
     * @description 登陆失败   使用系统消息详细解释说明
     * @param null
     * @return
     */
    protected  ResultData loginFailed(String detail){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_FAILED.getCode());
        resultData.setMsg(LOGIN_FAILED.getMsg());
        resultData.setDetail(detail);

        return resultData;

    }
    /**
     * @Author  LYF MESSI
     * @date: 2020/7/9 15:27
     * @description 用户名已存在.系统消息
     * @param null
     * @return
     */
    protected  ResultData  loginExist(){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_EXIST.getCode());
        resultData.setMsg(LOGIN_EXIST.getMsg());
        return resultData;
    }


    /**
     * @Author  LYF MESSI
     * @date: 2020/7/9 15:27
     * @description 用户名不存在.系统消息
     * @param null
     * @return
     */
    protected ResultData userNotExist(){
        ResultData resultData = new ResultData();
        resultData.setCode(USER_NOT_EXIST.getCode());
        resultData.setMsg(USER_NOT_EXIST.getMsg());
        return  resultData;
    }

    /**
     * 密码错误
     * 系统消息
     * @return
     */
    protected  ResultData passwordWrong(){
        ResultData resultData = new ResultData();
        resultData.setCode(PASSWORD_WRONG.getCode());
        resultData.setMsg(PASSWORD_WRONG.getCode());
        return  resultData;
    }

    /**
     * 用户退出异常
     * 系统消息
     * @return
     */
    protected  ResultData loginWrong(){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_WRONG.getCode());
        resultData.setMsg(LOGIN_WRONG.getMsg());
        return  resultData;
    }

    /**
     * 操作成功，返回系统消息
     *
     */
    protected ResultData operationSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(SUCCESS.getCode());
        resultData.setMsg(SUCCESS.getMsg());
        return resultData;
    }

    /**
     * 操作失败，返回系统消息
     *
     */
    protected ResultData operationFailed(){
        ResultData resultData = new ResultData();
        resultData.setCode(FAILED.getCode());
        resultData.setMsg(FAILED.getMsg());
        return resultData;
    }

    /**
     * 删除操作返回系统消息
     *
     */
    protected  ResultData deleteOperation(){
        ResultData resultData = new ResultData();
        resultData.setCode(DELETE_OPERATION.getCode());
        resultData.setMsg(DELETE_OPERATION.getMsg());
        return  resultData;
    }

    /**
     * 修改操作返回消息
     *
     */
    protected  ResultData updateOperation(){
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_OPERATION.getCode());
        resultData.setMsg(UPDATE_OPERATION.getMsg());
        return resultData;
    }

    /**
     * 新增返回系统消息
     *
     */
    protected  ResultData insertOperation(){
        ResultData resultData = new ResultData();
        resultData.setCode(INSERT_OPERATION.getCode());
        resultData.setMsg(INSERT_OPERATION.getMsg());
        return  resultData;
    }

    /**
     * @author Seven Lee
     * @description
     *      操作成功，返回系统消息
     * @param []
     * @date 2020/7/9
     * @return com.aaa.lee.base.ResultData
     * @throws
     **/
    protected ResultData operationSuccess(Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(SUCCESS.getCode());
        resultData.setMsg(SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }

    /**


    /**
     * @author Seven Lee
     * @description
     *      操作失败，返回系统消息
     * @param []
     * @date 2020/7/9
     * @return com.aaa.lee.base.ResultData
     * @throws
     **/
    protected ResultData operationFailed(String msg) {
        ResultData resultData = new ResultData();
        resultData.setCode(FAILED.getCode());
        resultData.setMsg(msg);
        return resultData;
    }


}
