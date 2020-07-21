package com.aaa.lyf.controller;

import com.aaa.lyf.base.BaseController;
import com.aaa.lyf.base.ResultData;
import com.aaa.lyf.model.MappingProject;
import com.aaa.lyf.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MaProjectController extends BaseController {
    @Autowired
    private IProjectService iProjectService;
    @RequestMapping("/selectAllMappPt")
     public ResultData selectAllMappPt(@RequestParam("id") Long id){
         List<MappingProject> lisq = iProjectService.selectAllMappPrjt(id);
         if (!"".equals(lisq) && null != lisq){
             return super.selectSuccess(lisq);
         }
         return super.selectFalse();
     }
    @RequestMapping("/selectByProtT")
    public ResultData selectByProtT(@RequestParam("projectType") String projectType){
        List<MappingProject> listr = iProjectService.selectByProjectT(projectType);
        if (!"".equals(listr) && null != listr){
            return super.selectSuccess(listr);
        }
        return super.selectFalse();
    }
}
