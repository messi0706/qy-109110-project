package com.aaa.lyf.controller;

import com.aaa.lyf.base.BaseController;
import com.aaa.lyf.model.MappingUnit;
import com.aaa.lyf.service.BaiMUnitService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaiMUnitController extends BaseController {

    @Autowired
    private BaiMUnitService baiMUnitService;
    @PostMapping("/selectAllMaUnBai")
     public PageInfo<MappingUnit> selectAllMaUnBai(@RequestBody MappingUnit mappingUnit, @RequestParam("pageNo") Integer pageNo,@RequestParam("pageSize") Integer pageSize){
         PageInfo pageInfo = baiMUnitService.selectAllMaUnBai(mappingUnit,pageNo,pageSize);
         if (!"".equals(pageInfo) && null != pageInfo){
             return pageInfo;
         }
         return null;
     }
}
