package com.aaa.lyf.service;

import com.aaa.lyf.base.BaseService;
import com.aaa.lyf.mapper.MappingUnitMapper;
import com.aaa.lyf.model.MappingUnit;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 双随机抽查-->单位抽查
 */
@Service
public class MappUnitSerivce extends BaseService<MappingUnit> {
    @Autowired
    private MappingUnitMapper mappingUnitMapper;

    /**
     * //分页查询，双随机抽查-->单位抽查
     * PageHelper--代表分页
     * 查询全部信息，
     * @param mappingUnit
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageInfo<MappingUnit> selectByMaUnit(MappingUnit mappingUnit, Integer pageNo, Integer pageSize){
        PageHelper.startPage(pageNo,pageSize);
        try {
            PageInfo pageInfoa = mappingUnitMapper.selectListByMaUnit(mappingUnit,pageNo,pageSize);
            if (!"".equals(pageInfoa) && null !=pageInfoa){
                return pageInfoa;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通过名字查询
     * @param unitName
     * @param pageNo
     * @param pageSize
     * @return
     */
   public PageInfo<MappingUnit>selectByMUtin(String unitName,Integer pageNo, Integer pageSize){
      PageHelper.startPage(pageNo,pageSize);
      try {
          PageInfo pageInfob = mappingUnitMapper.selectByNmMUtin(unitName,pageNo,pageSize);
          if (!"".equals(pageInfob) &&null != pageInfob){
              return pageInfob;
          }
      }catch (Exception e){
          e.printStackTrace();
      }
     return null;
   }
}
