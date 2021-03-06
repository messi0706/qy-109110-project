package com.aaa.lyf.mapper;

import com.aaa.lyf.model.MappingUnit;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

public interface MappingUnitMapper extends Mapper<MappingUnit> {
 //分页查询，双随机抽查-->单位抽查
    PageInfo<MappingUnit> selectListByMaUnit(MappingUnit mappingUnit, Integer pageNo, Integer pageSize);

    //分页条件查询，双随机抽查-->单位抽查
    PageInfo<MappingUnit>selectByNmMUtin(String unitName,Integer pageNo, Integer pageSize);

    //黑白名单
    /**
     * 白名单
     */
    PageInfo<MappingUnit> selectAllMaUnitBai(MappingUnit mappingUnit, Integer pageNo, Integer pageSize);
    /**
     * 黑名单
     */
    PageInfo<MappingUnit> selectAllMaUnitHei(MappingUnit mappingUnit, Integer pageNo, Integer pageSize);
}