package com.aaa.lyf.status;


/**
 * @Author: LYF MESSI
 * @Date: 2020/7/9 16:20
 * @Description: TODO
 * @version: 1.0
 */
public enum OperationStatus {

    SUCCESS("1","操作成功"),
    FAILED("2","操作失败"),
    DELETE_OPERATION_SUCCESS("3", "删除操作成功"),
    DELETE_OPERATION_FALSE("11", "删除操作失败"),
    UPDATE_OPERATION_SUCCESS("4", "修改操作成功"),
    UPDATE_OPERATION_FALSE("12", "修改操作失败"),
    INSERT_OPERATION_SUCCESS("5", "新增操作成功"),
    INSERT_OPERATION_FALSE("13", "新增操作失败"),
    SELECT_OPERATION_SUCCESS("14","查询成功"),
    SELECT_OPERATION_FALSE("15","查询失败"),
    UPLOAD_SUCCESS("20005","文件上传成功"),
    UPLOAD_FAILED("10005","文件上传失败"),
    ZUUL_FILTER_SUCCESS("6", "路由过滤成功"),
    ZUUL_FILTER_FAILED("7", "路由过滤失败"),
    ZUUL_FILTER_TOKEN_SUCCESS("8", "token值存在"),
    ZUUL_FILTER_TOKEN_FAILED("9", "token值不存在"),
    REQUEST_IS_NULL("10", "request对象为null");

    OperationStatus(String code, String msg) {
        this.code = code;
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
