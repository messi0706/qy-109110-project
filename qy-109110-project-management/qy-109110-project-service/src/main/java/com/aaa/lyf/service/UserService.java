package com.aaa.lyf.service;


import com.aaa.lyf.base.BaseService;
import com.aaa.lyf.mapper.UserMapper;
import com.aaa.lyf.model.User;

import com.aaa.lyf.utils.IDUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;



import static com.aaa.lyf.staticproperties.TimeForatProperties.TIME_FORMAT;


@Service
public class UserService extends BaseService<User> {
    @Autowired
    private UserMapper userMapper;
    /**
     * @return
     * @Author  lyf
     * @Description 查询所有用户
     * @Param
     **/
    public PageInfo<User> selectAllUser(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<User> users = userMapper.selectAll();
        if (users.size()>0){
            PageInfo<User> pageInfo = new PageInfo(users);
            return pageInfo;
        }else{
            return null;
        }
    }
    /**
     * @author lyf
     * @description
     * 这个方法用来添加用户的 参数user是前端传来的
     *
     * @param
     *
     * @return java.lang.Boolean
     * @throws
     **/
    public Boolean addUser(User user){

        try {

            //获取当前时间
            Date date = new Date();
            //设置日期格式
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String format = simpleDateFormat.format(date);
            //获取一个token值
            String token = IDUtils.getUUID();
            //获取前段传递的参数 放入user中
            //将username传入
            user.setUsername(user.getUsername())
                    .setToken(token)
                    //将password传入
                    .setPassword(user.getPassword())
                    //将Email传入
                    .setEmail(user.getEmail())
                    //将手机号传入
                    .setMobile(user.getMobile())
                    //将角色传入
                    .setType(user.getType())
                    //将部门传入
                    .setDeptId(user.getDeptId())
                    //将状态传入
                    .setStatus(user.getStatus())
                    //将性别传入
                    .setSsex(user.getSsex())
                    //将创建时间传入
                    .setCreateTime(format)
                    //传入id
                    .setId(user.getId());
            int insert = userMapper.insert(user);
            if (insert>0){
                return true;
            }else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * @Author lyf
     * @Description 通过主键删除用户
     * @Param
     * @return
     **/
    public Integer deleteUser(User user){
        //判断前段是否传值成功
        if (!"".equals(user) && null !=user){
            try {
                //执行删除操作
                Integer delete = delete(user);
                if (delete>0){
                    return delete;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    /**
     * @Author lyf
     * @Description 根据id批量删除用户
     * @Param
     * @return
     *
     * @param ids*/
    public Integer deleteMoreUser(List<Object> ids){
        //判断前段是否传值成功
        if (!"".equals(ids) && null !=ids){
            try {
                //调用父类的批量删除方法
                Integer integer = super.deleteByIds(ids);
                //判断是否查询出结果
                if (integer>0){
                    return integer;
                }
                return null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    /**
     * @Author lyf
     * @Description 根据id查询用户信息
     * @Param
     * @return
     **/
    public User selectUserById(Long id){
        //判断前端是否传值成功
        if (!"".equals(id) && null !=id){
            try {
                //通过id查询信息
                User user = userMapper.selectByPrimaryKey(id);
                //判断是否查询出数据
                if (!"".equals(user) && null !=user){
                    return user;
                }
                return null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    /**
     * @Author lyf
     * @Description 根据id修改用户信息
     * @Param
     * @return
     **/
    public Integer updateUser(User user){
        if (!"".equals(user) && null !=user){
            //获取当前时间作为修改时间
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TIME_FORMAT);
            String format = simpleDateFormat.format(new Date());
            //把时间存到实体中
            user.setModifyTime(format);
            try {
                //通过父类方法修改用户信息
                Integer update = super.update(user);
                //判断受影响的行数
                if (update>0){
                    return update;
                }
                return null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}

