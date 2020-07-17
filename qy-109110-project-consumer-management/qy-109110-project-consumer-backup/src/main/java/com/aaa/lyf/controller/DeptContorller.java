package com.aaa.lyf.controller;


import com.aaa.lyf.base.BaseController;
import com.aaa.lyf.base.ResultData;
import com.aaa.lyf.model.Dept;
import com.aaa.lyf.service.IProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

//部门管理
@RestController
public class DeptContorller extends BaseController {
    @Autowired
    private IProjectService iProjectService;
//递归查询 根据父类id查询该部门及其子部门
    @GetMapping("/getAllDeptByparentId")

    public ResultData getAllDeptByParentId(Long parentId){
//调用iqyservice中的selectAllDeptByParent方法，得到查询结果。
        List<Dept> deptList = iProjectService.selectAllDeptByParentId(parentId);
        //判断
        //结果是否为空
        if (deptList != null) {
// 不为空，使用系统消息返回
            return selectSuccess(deptList);
        }else {
//为空，使用系统消息
          return   selectFalse();
        }
    }
    // 查询动态SQL，查询条件：部门名称，创建时间
    @PostMapping("/GetDeptInofByField")
    public ResultData<Dept> getDeptInfoByFiled(@RequestBody Map map){
        //调用iqyservice中的selectDeptInfoByFiled方法，得到数据
        List<Dept> deptList = iProjectService.selectDeptInfoByField(map);
        //判断是非为空
        if (deptList != null) {
            // 不为空，使用系统信息返回
            return selectSuccess(deptList);
        }else {
            //空，使用系统信息返回
            return selectFalse();
        }

    }
    //查询部门信息，根据部门主键id、
    @GetMapping("/GetDeptByDeptId")
    public ResultData<Dept> getDeptByDeptId(Integer deptId){
        //调用iqyservice中的selectDeptByDeptId方法
        Dept dept = iProjectService.selectDeptByDeptId(deptId);
        //判断
        if (dept != null){
            //不为空，使用系统信息返回
            return selectSuccess(dept);
        }else {
            return selectFalse();
        }
    }

    //新增部门信息
    @GetMapping("/addDpet")
    public ResultData<Dept> addDpet(Dept dept){
        Boolean aBoolean = iProjectService.insertDept(dept);
        //判断
        if (aBoolean == true) {
            //成功增加
            return insertSuccess(dept);
        }else {
            //增加失败
            return insertFalse();
        }
    }



    //,通过主键，执行删除
    @PostMapping("/deleteDeptByPrimaryKey")
    public ResultData<Dept>delectDeptByPrimaryKey(Dept dept){
        Boolean aBoolean = iProjectService.deleteDeptByPrimaryKey(dept);
        //判断删除是否成功
        if (aBoolean == true){
            //删除成功,
            return delectSuccess(dept);
        }else {
            //删除失败
            return delectFalse();
        }
    }

    //批量删除,通过父类的批量删除方法，根据主键
    @PostMapping("/batchDeleteByPrimaryKey")
    public ResultData<Dept>batchDeleteByPrimaryKey(List<Object> dept){
       Object object = iProjectService.batchDeleteByPrimaryKey(dept);
       //判断删除是否成功
        if(true == object){
            //删除成功
            return delectSuccess(dept);
        }else {
            //删除失败
            return delectFalse();
        }
    }
    //修改，通过部门主键修改
    @PostMapping("/updateDeptByPrimaryKey")
    public ResultData<Dept>updateDeptByPrimaryKey(Dept dept){
      Boolean aBoolean= iProjectService.updateDeptByPrimaryKey(dept);
      //判断修改成功
        if (aBoolean ==true){
                //修改成功
            return updateSuccess(dept);
        }else {
            //修改失败
            return updateFalse();
        }
    }
}




