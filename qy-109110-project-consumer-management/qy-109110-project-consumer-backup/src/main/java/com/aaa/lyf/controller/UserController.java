package com.aaa.lyf.controller;

import com.aaa.lyf.base.BaseController;
import com.aaa.lyf.base.BaseController;
import com.aaa.lyf.base.ResultData;
import com.aaa.lyf.model.User;
import com.aaa.lyf.service.IProjectService;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Company
 * @Author
 * @Date Create in 2020/5/22 14:57
 * @Description
 * 这是用户管理
 **/
@RestController
@Api(value = "用户" ,tags = "用户操作接口")
public class UserController extends BaseController {

    @Autowired
    private IProjectService iProjectService;
    @PostMapping("/addUser" )
    public ResultData addUser(@RequestBody User user, HttpServletRequest request){
        //判断是否添加成功
        //如果成功了就返会系统code 系统信息
        if (iProjectService.addUser(user)){
            return loginSuccess();
        }else{
            return loginFailed();
        }


    }  /**
     *@Description:
     * 查询所有用户
     *@Param:
     *@return:
     *@Author: zyf
     *@date: 2020/7/16 0016
     */
    @PostMapping("/selectAllUser")
    public ResultData selectAllUser(Integer pageNo,Integer pageSize){
        PageInfo pageInfo = iProjectService.selectAllUser(pageNo,pageSize);
        if (!"".equals(pageInfo) && null !=pageInfo){
            return super.selectSuccess(pageInfo);
        }
        return super.selectFalse();

    }
    /**
     *@Description:
     * 根据主键删除用户
     *@Param:
     *@return:
     *@Author: zyf
     *@date: 2020/7/16 0016
     */
    @PostMapping("/deleteUser")
    public ResultData deleteUser(User user){
        Integer integer = iProjectService.deleteUser(user);
        if (integer>0){
            return super.delectSuccess(integer);

        }
        return super.delectFalse();
    }
    /**
     *@Description:
     * 根据id批量删除
     *@Param:
     *@return:
     *@Author: zyf
     *@date: 2020/7/16 0016
     */
    @PostMapping("/deleteUsersById")
    public ResultData deleteUserById(@RequestBody List<Object> ids){
        Integer integer = iProjectService.deleteUsersById(ids);
        if (integer>0){
            return super.delectSuccess(integer);
        }
        return super.delectFalse();
    }
    /**
     *@Description:
     * 根据id查询用户信息
     *
     *@Param:
     *@return:
     *@Author: zyf
     *@date: 2020/7/16 0016
     */
    @GetMapping("/selectUserById")
    public ResultData selectUserById(Long id){
        User user = iProjectService.selectUserById(id);
        if (!"".equals(user) && null !=user){
            return super.selectSuccess(user);
        }
        return super.selectFalse();
    }
    /**
     *@Description:
     * 根据id修改用户信息
     *
     *@Param:
     *@return:
     *@Author: zyf
     *@date: 2020/7/16 0016
     */
    @PostMapping("/updateUserById")
    public ResultData updateUserById(User user){
        Integer integer = iProjectService.updateUserById(user);
        if (integer>0){
            return super.updateSuccess(integer);
        }
        return super.updateFalse();
    }
}
