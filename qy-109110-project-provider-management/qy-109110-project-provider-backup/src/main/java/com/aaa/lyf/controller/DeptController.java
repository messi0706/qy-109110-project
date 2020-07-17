package com.aaa.lyf.controller;

import com.aaa.lyf.model.Dept;
import com.aaa.lyf.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 部门管理
 **/
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    /**
     * 递归查询根据 parentId（父id）查询该部门及其子部门
    **/
    @GetMapping("/selectAllDeptByParentId")
    public List<Dept> selectAllDeptByParentId(@RequestParam("parentId") Integer parentId) {
        // 调用 deptService 中的 selectAllDeptByParentId 方法，得到查询结果
        List<Dept> allDept = deptService.selectAllDeptByParentId(parentId);

        // 判断 结果是否为空
        if (allDept != null) {
            // 说明结果不为空，返回查询的结果
            return allDept;
        }else {
            // 返回null
            return null;
        }
    }

    /**
     * 查询-动态sql查询条件：部门名称 创建时间区间
    **/
    @PostMapping("/selectDeptInfoByField")
    public List<Dept> selectDeptInfoByField(@RequestBody Map map) {
        // 调用 deptService 中的 selectDeptInfoByField 方法，得到查询结果
        List<Dept> deptList = deptService.selectDeptInfoByField(map);

        // 判断 结果是否为空
        if (deptList != null) {
            // 说明结果不为空，查询成功，返回查询的结果
            return deptList;
        }else {
            // 查询失败，返回null
            return null;
        }
    }

    /**
     * 查询部门信息，根据主键id查询部门的信息
    **/
    @GetMapping("/selectDeptByDeptId")
    public Dept selectDeptByDeptId(@RequestParam("deptId") Integer deptId) {
        // 调用 deptService 中的 selectDeptByDeptId 方法，得到查询结果
        Dept dept = deptService.selectDeptByDeptId(deptId);

        // 判断 结果是否为空
        if (dept != null) {
            // 说明结果不为空，返回查询的结果
            return dept;
        }else {
            // 返回null
            return null;
        }
    }


    /**
    新增部门信息
    **/
    @PostMapping("/insertDept")
    public Boolean insertDept(@RequestBody Dept dept) {
        // 调用 deptService 中的 insertDept 方法，得到结果
        Boolean aBoolean = deptService.insertDept(dept);

        // 判断 结果是否为true
        if (aBoolean == true) {
            // 说明结果为true，新增成功，返回true
            return true;
        }else {
            // 新增失败，返回false
            return false;
        }
    }


    /**
    通过主键 执行删除操作
    **/
    @PostMapping("/deleteDeptByPrimaryKey")
    public Boolean deleteDeptByPrimaryKey(@RequestBody Dept dept) {
        // 调用 deptService 中的 deleteDeptByPrimaryKey 方法，得到结果
        Boolean aBoolean = deptService.deleteDeptByPrimaryKey(dept);

        // 判断 结果是否为true
        if (aBoolean == true) {
            // 说明结果为true，删除成功 返回true
            return true;
        }else {
            // 删除失败，返回false
            return false;
        }
    }

    /**
    *  批量删除 调用父类的批量删除方法（根据主键），执行删除操作
    **/
    @PostMapping("/batchDeleteByPrimaryKey")
    public Boolean batchDeleteByPrimaryKey(@RequestBody List<Object> ids) {
        // 调用 deptService 中的 batchDeleteByPrimaryKey 方法，得到结果
        Boolean aBoolean = deptService.batchDeleteByPrimaryKey(ids);

        // 判断 结果是否为true
        if (aBoolean == true) {
            // 说明结果为true，删除成功 返回true
            return true;
        }else {
            // 删除失败，返回false
            return false;
        }
    }


    /**
     * 修改，通过主键-修改部门信息
    **/
    @PostMapping("/updateDeptByPrimaryKey")
    public Boolean updateDeptByPrimaryKey(@RequestBody Dept dept) {
        // 调用 deptService 中的 updateDeptByPrimaryKey 方法，得到结果
        Boolean aBoolean = deptService.updateDeptByPrimaryKey(dept);

        // 判断 结果是否为true
        if (aBoolean == true) {
            // 说明结果为true，修改成功 返回true
            return true;
        }else {
            // 修改失败，返回false
            return false;
        }
    }


}
