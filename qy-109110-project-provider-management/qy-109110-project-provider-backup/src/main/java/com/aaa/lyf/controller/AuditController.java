package com.aaa.lyf.controller;


import com.aaa.lyf.service.AuditService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuditController {
    @Autowired
    private AuditService auditService;
    /**
    *@Description:
     * 分页查询项目信息
     *
    *@Param:
    *@return:
    *@Author: zyf
    *@date: 2020/7/17 0017
    */
@GetMapping("/selectAuditInfo")
    PageInfo selectAuditInfo(@RequestParam("pageNo") Integer pageNo,@RequestParam("pageSize") Integer pageSize){
    List list = auditService.selectAuditInfo();
    //判断是否为空，设置起始页
    if (list != null){
        PageHelper.startPage(pageNo,pageSize);
        return new PageInfo(list);
    }else {
        return new PageInfo();
    }

}


/**
*@Description:
 * 模糊查询
*@Param:
*@return:
*@Author: zyf
*@date: 2020/7/17 0017
*/
@GetMapping("/fuzzySelectAudit")
PageInfo fuzzySelectAudit(@RequestParam("pageNo") Integer pageNo,
                         @RequestParam("pageSize") Integer pageSize,
                         @RequestParam("projectName") String projectName) {
    List list = auditService.fuzzySelectAudit(projectName);
    if (list != null) {
        PageHelper.startPage(pageNo,pageSize);
        return new PageInfo(list);
    }else {
        return new PageInfo();
    }
}


}
