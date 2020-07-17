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
     * 登陆成功
     *   使用系统消息
     * @return
     */
    protected ResultData loginSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(LOGIN_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * 登陆成功
     *   使用自定义消息
     *     也就是自己定义的方法
     * @param msg
     * @return
     */
    protected ResultData loginSuccess(String msg){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * 登陆成功
     *    返回数据信息，使用系统消息
     * @param data
     * @return
     */
    protected ResultData loginSuccess(Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(LOGIN_SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }

    /**
     * 登陆成功
     *    返回数据信息，使用自定义消息
     * @param msg
     * @param data
     * @return
     */
    protected ResultData loginSuccess(String msg,Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_SUCCESS.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }

    /**
     * 登录失败
     *  使用系统消息
     * @return
     */
    protected ResultData loginFailed(){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_FAILED.getCode());
        resultData.setMsg(LOGIN_FAILED.getMsg());
        return resultData;
    }

    /**
     * 登录失败
     *    使用系统消息，详细解释说明
     * @param datail
     * @return
     */
    protected ResultData loginFailed(String datail){
        ResultData resultData = new ResultData();
        resultData.setCode(LOGIN_FAILED.getCode());
        resultData.setMsg(LOGIN_FAILED.getMsg());
        resultData.setDetail(datail);
        return resultData;
    }
    /**
     * @description
     *      操作成功，返回系统消息
     * @param []
     * @date 2020/7/9
     * @return com.aaa.lee.base.ResultData
     * @throws
     **/
    protected ResultData operationSuccess() {
        ResultData resultData = new ResultData();
        resultData.setCode(SUCCESS.getCode());
        resultData.setMsg(SUCCESS.getMsg());
        return resultData;
    }

    /**
     *
     * @description
     *      操作成功，返回系统消息,返回数据信息
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
     *
     * @description
     *      操作失败，返回系统消息
     * @param []
     * @date 2020/7/9
     * @return com.aaa.lee.base.ResultData
     * @throws
     **/
    protected ResultData operationFailed() {
        ResultData resultData = new ResultData();
        resultData.setCode(FAILED.getCode());
        resultData.setMsg(FAILED.getMsg());
        return resultData;
    }

    /**
     *
     * @description
     *      操作失败，返回自定义消息
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

    /**
     * 新增成功，返回系统消息
     * @return
     */
    protected ResultData insertSuccess(Object data){
        ResultData resultData = new ResultData();
        resultData.setData(data);
        resultData.setCode(INSERT_OPERATION_SUCCESS.getCode());
        resultData.setMsg(INSERT_OPERATION_SUCCESS.getMsg());

        return resultData;
    }


    /**
     * 新增失败，返回系统消息
     * @return
     */
    protected ResultData insertFalse(){
        ResultData resultData = new ResultData();
        resultData.setCode(INSERT_OPERATION_FALSE.getCode());
        resultData.setMsg(INSERT_OPERATION_FALSE.getMsg());
        return  resultData;
    }

    /**
     * 删除成功，返回系统消息
     * @return
     */
    protected ResultData delectSuccess(Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(DELETE_OPERATION_SUCCESS.getCode());
        resultData.setMsg(DELETE_OPERATION_SUCCESS.getMsg());
        resultData.setData(data);
        return  resultData;
    }

    /**
     * 删除失败，返回系统消息
     * @return
     */
    protected ResultData delectFalse(){
        ResultData resultData = new ResultData();
        resultData.setCode(DELETE_OPERATION_FALSE.getCode());
        resultData.setMsg(DELETE_OPERATION_FALSE.getMsg());
        return  resultData;
    }

    /**
     * 修改成功，返回系统消息
     * @return
     */
    protected ResultData updateSuccess(Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_OPERATION_SUCCESS.getCode());
        resultData.setMsg(UPDATE_OPERATION_SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }

    /**
     * 修改失败，返回系统消息
     * @return
     */
    protected ResultData updateFalse(){
        ResultData resultData = new ResultData();
        resultData.setCode(UPDATE_OPERATION_FALSE.getCode());
        resultData.setMsg(UPDATE_OPERATION_FALSE.getMsg());
        return resultData;
    }

    /**
     * 文件上传成功
     * @return
     */
    protected ResultData uploadSuccess(){
        ResultData resultData = new ResultData();
        resultData.setCode(UPLOAD_SUCCESS.getCode());
        resultData.setMsg(UPLOAD_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * 文件上传失败
     * @return
     */
    protected ResultData uploadFalse(){
        ResultData resultData = new ResultData();
        resultData.setCode(UPLOAD_FAILED.getCode());
        resultData.setMsg(UPLOAD_FAILED.getMsg());
        return resultData;
    }

    /**
     * 查询成功，返回系统消息
     * @return
     */
    protected ResultData selectSuccess(Object data){
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_OPERATION_SUCCESS.getCode());
        resultData.setMsg(SELECT_OPERATION_SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }

    /**
     * 查询失败，返回系统消息
     * @return
     */
    protected ResultData selectFalse(){
        ResultData resultData = new ResultData();
        resultData.setCode(SELECT_OPERATION_FALSE.getCode());
        resultData.setMsg(SELECT_OPERATION_FALSE.getMsg());
        return resultData;
    }

}
