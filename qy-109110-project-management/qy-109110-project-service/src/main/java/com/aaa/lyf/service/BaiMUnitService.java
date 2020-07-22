package com.aaa.lyf.service;

import com.aaa.lyf.base.BaseService;

import com.aaa.lyf.mapper.MappingUnitMapper;
import com.aaa.lyf.model.MappingUnit;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaiMUnitService extends BaseService<MappingUnit> {

    @Autowired
    private MappingUnitMapper mappingUnitMapper;

    /**
     * 查询全部数据
     * @param mappingUnit
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageInfo<MappingUnit>selectAllMaUnBai(MappingUnit mappingUnit, Integer pageNo, Integer pageSize){
        PageHelper.startPage(pageNo,pageSize);
        try {
            PageInfo pageInfo = mappingUnitMapper.selectAllMaUnitBai(mappingUnit,pageNo,pageSize);
            if (!"".equals(pageInfo) && null != pageInfo){
                return pageInfo;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
