package com.aaa.lyf.controller;

import com.aaa.lyf.base.BaseController;
import com.aaa.lyf.base.ResultData;
import com.aaa.lyf.model.MappingUnit;
import com.aaa.lyf.service.IProjectService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaiMUnitController extends BaseController {

    @Autowired
    private IProjectService iProjectService;
    @PostMapping("/selectAllMaUBai")
    public ResultData selectAllMaUBai(@RequestBody MappingUnit mappingUnit, @RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize){
        PageInfo pageInfo = iProjectService.selectAllMaUnBai(mappingUnit,pageNo,pageSize);
        if (!"".equals(pageInfo) && null != pageInfo){
            return super.selectSuccess(pageInfo);
        }
        return super.selectFalse();
    }
}
