package com.aaa.lyf.service;

import com.aaa.lyf.base.ResultData;
import com.aaa.lyf.model.LoginLog;
import com.aaa.lyf.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author: LYF MESSI
 * @Date: 2020/7/15 19:03
 * @version: 1.0
 * @Description:
 */
@FeignClient(value = "")
public interface IProjectService {
    /**
     * @Author  LYF MESSI
     * @date: 2020/7/15 19:06
     * @description:
     * 执行登录操作
     * @param null
     * @return
     */
    @PostMapping("/doLogin")
    ResultData doLogin(@RequestBody User user);
    /**
     * @Author  LYF MESSI
     * @date: 2020/7/15 19:07
     * @description:
     *     新增日志
     * @param null
     * @return
     */
    @PostMapping("/addLoginLog")
    Integer addLoginLog(@RequestBody LoginLog loginLog);

}
