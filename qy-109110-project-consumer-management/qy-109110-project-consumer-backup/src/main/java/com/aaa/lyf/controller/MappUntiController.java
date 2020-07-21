package com.aaa.lyf.controller;

import com.aaa.lyf.base.BaseController;
import com.aaa.lyf.base.ResultData;
import com.aaa.lyf.model.MappingUnit;
import com.aaa.lyf.service.IProjectService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 双随机抽查-->单位抽查
 */
@RestController
public class MappUntiController extends BaseController {
    @Autowired
    private IProjectService iProjectService;

    /**
     * 分页查询数据
     * @param mappingUnit
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping("/selectMappingUnit")
    public ResultData selectMappingUnit(@RequestBody MappingUnit mappingUnit, @RequestParam("/pageNo") Integer pageNo, @RequestParam("/pageSize") Integer pageSize){
       PageInfo pageInfoa = iProjectService.selectAll(mappingUnit,pageNo,pageSize);
       if (!"".equals(pageInfoa) && null !=pageInfoa){
           return super.selectSuccess(pageInfoa);
       }
            return null;
    }

    /**
     * 分页条件查询
     * @param unitName
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping("/selectByMUname")
    public ResultData selectByMUname(@RequestParam("unitName") String unitName, @RequestParam("pafeNo")Integer pageNo, @RequestParam("pageSize")Integer pageSize){
        PageInfo pageInfoc = iProjectService.selectByName(unitName,pageNo,pageSize);
        if (!"".equals(pageInfoc) && null !=pageInfoc){
            return super.selectSuccess(pageInfoc);
        }
        return null;
    }
}
