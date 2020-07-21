package com.aaa.lyf.controller;

import com.aaa.lyf.model.MappingUnit;
import com.aaa.lyf.service.MappUnitSerivce;
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
public class MappUntiController {
    @Autowired
    private MappUnitSerivce mappUnitSerivce;

    /**
     * 分页查询
     * @param mappingUnit
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping("/selectAll")
    public PageInfo selectAll(@RequestBody MappingUnit mappingUnit, @RequestParam("/pageNo") Integer pageNo,@RequestParam("/pageSize") Integer pageSize){
        PageInfo pageInfo = mappUnitSerivce.selectByMaUnit(mappingUnit,pageNo,pageSize);
        if (!"".equals(pageInfo) && null != pageInfo){
            return pageInfo;
        }
        return null;
    }

    /**
     * 条件分页查询
     * @param unitName
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping("/selectByName")
    public PageInfo selectByName(@RequestParam("unitName") String unitName,@RequestParam("pafeNo")Integer pageNo,@RequestParam("pageSize") Integer pageSize){
        PageInfo pageInfo = mappUnitSerivce.selectByMUtin(unitName,pageNo,pageSize);
        if (!"".equals(pageInfo) && null != pageInfo){
            return pageInfo;
        }
        return null;
    }

}
