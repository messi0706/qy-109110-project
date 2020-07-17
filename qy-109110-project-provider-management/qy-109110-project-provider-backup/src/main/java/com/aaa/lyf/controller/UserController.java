package com.aaa.lyf.controller;



import com.aaa.lyf.base.BaseService;
import com.aaa.lyf.base.CommonController;
import com.aaa.lyf.model.User;
import com.aaa.lyf.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController extends CommonController<User> {
    @Autowired
    private UserService userService;
    /**
     *@Description:
     * 查询所有的用户
     *@Param:
     *@return:
     *@Author: zyf
     *@date: 2020/7/16 0016
     */
    @PostMapping("/seleceAllUser")
    public PageInfo selectAllUser(@RequestParam("pageNo") Integer pageNo,@RequestParam("pageSize") Integer pageSize){
        return userService.selectAllUser(pageNo,pageSize);
    }
    /**
     *@Description:
     * 添加用户的方法
     *@Param:
     *@return:
     *@Author: zyf
     *@date: 2020/7/16 0016
     */
    @PostMapping("/addUser")
    public Boolean addUser(@RequestBody User user)  {
        try {
            userService.selectListByPage(user,29,7);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userService.addUser(user);
    }
    @Override
    public BaseService<User> getBaseService() {
        return userService;
    }
    /**
     * @Author wxz
     * @Description
     * @Param 根据主键删除
     * @return
     **/
    @PostMapping("/deleteUser")
    public Integer deleteUser(@RequestBody User user){
        try {
            Integer delete = userService.delete(user);
            return delete;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @Author wxz
     * @Description 根据id批量删除用户
     * @Param
     * @return
     **/
    @PostMapping("/delectMoreUser")
    public Integer deleteMoreUser(@RequestBody List<Object> ids){
        return userService.deleteMoreUser(ids);
    }
    /**
     * @Author wxz
     * @Description 根据id查询用户信息
     * @Param
     * @return
     **/
    @GetMapping("/selectUserById")
    public User selectUserById(@RequestParam("id") Long id){
        return userService.selectUserById(id);
    }

    /**
     * @Author wxz
     * @Description 根据id修改用户信息
     * @Param
     * @return
     **/
    @PostMapping("/updateUserById")
    public Integer updateUserById(@RequestBody User user){
        return userService.updateUser(user);
    }


}
