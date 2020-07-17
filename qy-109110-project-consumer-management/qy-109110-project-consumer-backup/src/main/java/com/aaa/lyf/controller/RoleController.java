package com.aaa.lyf.controller;


import com.aaa.lyf.base.BaseController;
import com.aaa.lyf.base.BaseController;
import com.aaa.lyf.base.ResultData;
import com.aaa.lyf.model.Role;
import com.aaa.lyf.service.IProjectService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Api(value = "角色管理" ,tags = "角色管理接口")
public class RoleController extends BaseController {
    @Autowired
    private IProjectService iProjectService;
    /**
     *@Description:
     * 查询所有角色信息
     *@Param:
     *@return:
     *@Author: zyf
     *@date: 2020/7/16 0016
     */
    @GetMapping("selectAllRole")
    public ResultData selectAllRole(Integer pageNo, Integer pageSize){
        PageInfo pageInfo = iProjectService.selectAllRole(pageNo,pageSize);
        //判断
        if (!"".equals(pageInfo) && null !=pageInfo){
            return super.selectSuccess(pageInfo);
        }
        return super.selectFalse();
    }

    /**
     *@Description:
     * 根据条件查询
     *@Param:
     *@return:
     *@Author: zyf
     *@date: 2020/7/16 0016
     */
    @PostMapping("selectRoleByField")
    public ResultData selectRoleByField(@RequestBody Map map, Integer pageNo, Integer pageSize){
        PageInfo pageInfo = iProjectService.selectRoleByField(map,pageNo,pageSize);
        if (!"".equals(pageInfo) && null !=pageInfo){
            return super.selectSuccess(pageInfo);
        }
        return super.selectFalse();
    }
    @GetMapping("selectRoleByPrimaryKey")
    public ResultData selectRoleByPrimaryKey(Long roleId){
        Role role = iProjectService.selectRoleByPrimaryKey(roleId);
        if (!"".equals(role) && null !=role){
            return super.selectSuccess(role);

        }
        return super.selectFalse();
    }

}
