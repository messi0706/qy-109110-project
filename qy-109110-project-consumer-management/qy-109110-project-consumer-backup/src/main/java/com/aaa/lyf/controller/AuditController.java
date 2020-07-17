package com.aaa.lyf.controller;


import com.aaa.lyf.base.BaseController;
import com.aaa.lyf.base.ResultData;
import com.aaa.lyf.service.IProjectService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "项目审核",tags = "项目信息")
public class AuditController extends BaseController {
    @Autowired
    private IProjectService iProjectService;

    /**
    *@Description:
     * 查询项目信息
     *
    *@Param:
    *@return:
    *@Author: zyf
    *@date: 2020/7/17 0017
    */
    @GetMapping("/selectAuditIn" )
    public ResultData selectAuditInfo(Integer pageNo,Integer pageSize){
        PageInfo audits=iProjectService.selectAuditInfo(pageNo,pageSize);
        if (audits != null){
            return  super.selectSuccess(audits);
        }
        else {
            return super.selectFalse();
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
    public ResultData fuzzySelectAudit(Integer pageNo,Integer pageSize,String projectName){
        PageInfo auditPageInfo = iProjectService.fuzzySelectAudit(pageNo,pageSize,projectName);
        if (auditPageInfo !=null){
            return super.selectSuccess(auditPageInfo);

        }else
        {
            return super.selectFalse();
        }


    }
}
