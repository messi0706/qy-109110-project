package com.aaa.lyf.controller;

import com.aaa.lyf.base.BaseController;
import com.aaa.lyf.model.Role;
import com.aaa.lyf.service.RoleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class RoleController extends BaseController {
    @Autowired
    private RoleService roleService;

    /**
     * 查询所有角色信息
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping("/selectAllRole")
    public PageInfo selectAllRole(@RequestParam("pageNo") Integer pageNo,@RequestParam("pageSize")Integer pageSize){
        PageInfo pageInfo = roleService.selectAllRole(pageNo,pageSize);
        if (null != pageInfo){
            return pageInfo;
        }
        return null;
    }

    /**
     * 根据条件查询
     * @param map
     * @param pageNo
     * @param pageSize
     * @return
     */
    @PostMapping("/selectRoleByField")
    public PageInfo selectRoleByField(@RequestBody Map map, @RequestParam("pageNo")Integer pageNo,@RequestParam("pageSize")Integer pageSize){
        PageInfo pageInfo = roleService.selectRoleByField(map,pageNo,pageSize);
        if (!"".equals(pageInfo) && null != pageInfo){
            return pageInfo;
        }
        return null;
    }
    /**
     * 根据主键查询角色信息
     */
    @GetMapping("/selectRoleByPrimaryKey")
    public Role selectRoleByPrimaryKey(@RequestParam("roleId") Long roleId){
        Role role = roleService.selectRoleByParimaryKey(roleId);
        if (!"".equals(role) && null != role){
            return role;
        }
        return null;
    }
}
