package com.aaa.lyf.mapper;


import com.aaa.lyf.model.Dept;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface DeptMapper extends Mapper<Dept> {

    /**
     * @Description 查询部门信息，根据主键id查询部门的信息
     * @Param
     * @return
     **/
    Dept selectDeptByDeptId(Integer deptId);


    /**
     * @Description 查询所有的部门
     * @Param
     * @return
     **/
    List<Dept> selectDeptByParentId(Integer parentId);


    /**
     * @Description 查询-动态sql查询条件：部门名称 创建时间区间
     * @Param
     * @return
     **/
    List<Dept> selectDeptInfoByField(Map map);


    /**
     * @Description 新增部门信息
     * @Param
     * @return
     **/
    int insertDept(Dept dept);


}