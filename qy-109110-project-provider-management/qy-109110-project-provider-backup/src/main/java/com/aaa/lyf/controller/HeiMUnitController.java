package com.aaa.lyf.controller;

import com.aaa.lyf.base.BaseController;
import com.aaa.lyf.model.MappingUnit;
import com.aaa.lyf.service.BaiMUnitService;
import com.aaa.lyf.service.HeiMUnitService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public class HeiMUnitController extends BaseController {
    @Autowired
    private HeiMUnitService heiMUnitService;
    @PostMapping("/selectAllMaUHei")
    public PageInfo<MappingUnit> selectAllMaUHei(@RequestBody MappingUnit mappingUnit, @RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize){
        PageInfo pageInfo = heiMUnitService.selectAllMaUnHei(mappingUnit,pageNo,pageSize);
        if (!"".equals(pageInfo) && null != pageInfo){
            return pageInfo;
        }
        return null;
    }
}
