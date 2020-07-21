package com.aaa.lyf.service;

import com.aaa.lyf.base.BaseService;
import com.aaa.lyf.mapper.CheckPersonMapper;
import com.aaa.lyf.model.CheckPerson;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 双随机抽查--->抽查人员
 */
@Service
public class CheckPersonService extends BaseService<CheckPerson> {
    @Autowired
    private CheckPersonMapper checkPersonMapper;

    /**
     * 分页查询
     * @param checkPerson
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageInfo<CheckPerson>selectAllCPerson(CheckPerson checkPerson,Integer pageNo,Integer pageSize){
        PageHelper.startPage(pageNo,pageSize);
        try {
            PageInfo pageInfo = checkPersonMapper.selectListByCheckPson(checkPerson,pageNo,pageSize);
            if (!"".equals(pageInfo) && null != pageInfo){
                return pageInfo;
            }
        }catch (Exception e ){
            e.printStackTrace();
        }
      return null;
    }

    /**
     * 修改数据
     * @param checkPerson
     * @return
     */
    public Integer updateById(CheckPerson checkPerson){
        //先判断数据是否为空
        if (!"".equals(checkPerson) && null != checkPerson){
            try {
                //调用父类方法进行删除
                Integer inte = super.delete(checkPerson);
                //判断受影响的行数
                if (inte > 0 ){
                    return inte;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     *删除数据
     * @param checkPerson
     * @return
     */
    public Integer delectById(CheckPerson checkPerson){
        if (!"".equals(checkPerson) && null != checkPerson){
            try {
                Integer inta = super.delete(checkPerson);
                if (inta >0){
                    return inta;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 新增数据
     * @param checkPerson
     * @return
     */
    public Integer insertById(CheckPerson checkPerson){
     if (!"".equals(checkPerson) && null != checkPerson){
         checkPerson.setId(checkPerson.getId())
                 .setName(checkPerson.getName())
                 .setUnitName(checkPerson.getUnitName())
                 .setDuty(checkPerson.getDuty())
                 .setPhone(checkPerson.getPhone());
         Integer intc = super.add(checkPerson);
         if (intc > 0){
             return intc;
         }
     }
     return null;
    }


}
