package com.aaa.lyf.service;

import com.aaa.lyf.base.BaseService;
import com.aaa.lyf.mapper.MappingUnitMapper;
import com.aaa.lyf.model.MappingUnit;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

public class HeiMUnitService extends BaseService<MappingUnit> {
    @Autowired
    private MappingUnitMapper mappingUnitMapper;

    /**
     * 查询全部数据
     * @param mappingUnit
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageInfo<MappingUnit> selectAllMaUnHei(MappingUnit mappingUnit, Integer pageNo, Integer pageSize){
        PageHelper.startPage(pageNo,pageSize);
        try {
            PageInfo pageInfo = mappingUnitMapper.selectAllMaUnitHei(mappingUnit,pageNo,pageSize);
            if (!"".equals(pageInfo) && null != pageInfo){
                return pageInfo;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
