package com.aaa.lyf.service;

import com.aaa.lyf.base.BaseService;
import com.aaa.lyf.mapper.RoleMapper;
import com.aaa.lyf.model.Role;
import com.aaa.lyf.utils.DateUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@Service
public class RoleService extends BaseService<Role> {
    @Autowired
    private RoleMapper roleMapper;
    /**
     *@Description:
     * 查询所有的角色的信息
     *@Param:
     *@return:
     *@Author: zyf
     *@date: 2020/7/16 0016
     */

    public PageInfo selectAllRole(Integer pageNo,Integer pageSize){
        //页数和数量
        PageHelper.startPage(pageNo,pageSize);
        try{
            //查询权限信息
            List<Role> roles = roleMapper.selectAll();
            //判断查询结果是否为空
            if (!"".equals(roles) && null !=roles){
                //将查询结果放入
                PageInfo<Role> rolePageInfo = new PageInfo<Role>(roles);
                //返回查询结果
                return rolePageInfo;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     *@Description:
     * 条件查询
     *@Param:
     *@return:
     *@Author: zyf
     *@date: 2020/7/16 0016
     */
    public PageInfo selectRoleByField(Map map,Integer pageNo,Integer pageSize){
        PageHelper.startPage(pageNo,pageSize);
        try{
            //查询角色信息，
            List<Role> roles =roleMapper.selectRoleByField(map);
            //判断查询结果是否为空
            if (!"".equals(roles) && null !=roles){
                //将结果放入
                PageInfo<Role> rolePageInfo = new PageInfo<Role>(roles);
                return rolePageInfo;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public Role selectRoleByParimaryKey(Long roleId){
        //判断前段是否传值成功
        if (null !=roleId){
            try {
                //根据id查询
                Role role = roleMapper.selectByPrimaryKey(roleId);
                //判断查询结果是否为空
                if (!"".equals(role) && null !=role){
                    //返回查询信息
                    return role;
                }
                return null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    /**
     * @Author wxz
     * @Description  新增角色和对应权限
     * @Param
     * @return
     **/
    public Long insertRole(Role role){
        //判断前段是否传值成功
        if (!"".equals(role) && null !=role){
            //将角色名称传入
            role.setRoleName(role.getRoleName())
                    //将角色描述传入
                    .setRemark(role.getRemark())
                    //将创建时间传入
                    .setCreateTime(DateUtils.getCurrentDate());
            //执行新增
            Integer integer = roleMapper.insertRoleResultId(role);
            //获取返回的生成的id
            @NotNull Long roleId = role.getRoleId();
            if (null !=integer){
                return roleId;
            }
        }
        return null;
    }

    /**
     * @Author wxz
     * @Description  根据id修改角色
     * @Param
     * @return
     **/
    public Integer updateRoleByPrimaryKey(Role role){
        //判断前段是否传值成功
        if (!"".equals(role) && null !=role){
            //将当前时间传入修改时间
            role.setModifyTime(DateUtils.getCurrentDate());
            //调用修改方法
            try {
                int i = roleMapper.updateRoleByPrimaryKey(role);
                //判断是否修改成功
                if (i>0 ){
                    //返回受影响的行数
                    return i;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * @Author wxz
     * @Description  根据角色id批量删除角色信息
     * @Param
     * @return
     **/
    public Boolean deleteRoleByRoleId(List<Object> roleIds){
        //判断前段是否传值成功
        if (!"".equals(roleIds) && null !=roleIds){
            try {
                //调用父类重载的批量删除方法
                Integer integer = super.batchDelete(roleIds);
                if (integer>0){
                    return true;
                }
                return false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
