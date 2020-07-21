package com.aaa.lyf.mapper;

import com.aaa.lyf.model.RoleMenu;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


/**
 * @author: lyf
 * @Date: 2020/07/17
 * @Time: 16:00
 * @Desc  角色菜单表
 */
public interface RoleMenuMapper extends Mapper<RoleMenu> {

    /**
     * @Author  LYF MESSI
     * @date: 2020/7/18 10:56
     * @description: 在RoleMenu表中根据roleId删除
     * @param null
     * @return
     */
    int deleteRoleMenu(Long roleId);

    /**
     * @Author  LYF MESSI
     * @date: 2020/7/17 10:56
     * @description: 批量新增
     * @param null
     * @return
     */
    int batchInsertRoleMenu(List<RoleMenu> roleMenus);

    /**
     * @Author  LYF MESSI
     * @date: 2020/7/17 10:56
     * @description: 查询表里面有没有roleId
     * @param null
     * @return
     */
    List<RoleMenu> selectByRoleId(Long roleId);

}