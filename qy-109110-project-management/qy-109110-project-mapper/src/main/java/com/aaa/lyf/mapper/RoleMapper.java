package com.aaa.lyf.mapper;

import com.aaa.lyf.model.Role;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface RoleMapper extends Mapper<Role> {

    List<Role> selectRoleByField(Map map);

    //新增角色

    Integer insertRoleResultId(Role role);

    //修改角色信息

    Integer updateRoleByPrimaryKey(Role role);

}