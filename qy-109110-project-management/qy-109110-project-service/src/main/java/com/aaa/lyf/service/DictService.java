package com.aaa.lyf.service;

import com.aaa.lyf.base.BaseService;
import com.aaa.lyf.mapper.DictMapper;
import com.aaa.lyf.model.Dict;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * sevice：就是写判断，if， for，事务，锁，
 */

@Service
public class DictService extends BaseService<Dict> {

    @Autowired
    private DictMapper dictMapper;
/**
 * 查询操作
 */
    /**
     * 分页查询全部信息
     *   就是打开页面出现的信息是分页码的出现
     *   super：用于调用父类的方法
     * @return
     */
    public PageInfo<Dict> selectAllDictByPage(Dict dict,Integer pageNo,Integer pageSizez){
        PageHelper.startPage(pageNo,pageSizez);
        try {
            //并不是每次都调用xxxmapper里面的方法，所以不一定用到dictMapper
            //调用父类(就是继承的BaseService)分页方法把参数穿进去查询
            PageInfo<Dict> pageInfo = super.selectListByPage(dict,pageNo,pageSizez);
            //判断查询的结果是否为空
            if (!"".equals(pageInfo) && null != pageInfo){
                //返回结果
                return pageInfo;
            }
        }catch (Exception e ){
            e.printStackTrace();
        }
      return null;
    }


    /**
     * 通过ID查询信息
     * 调用的是mapper里面定义的方法
     * @param dictId
     * @return
     */
    public Dict selectByIdD(Integer dictId) {
        //判断前段是否传值成功
        if (dictId != null){
            try {
                //根据ID查询
                Dict dict=dictMapper.selectById(dictId);
                //判断查询结果是否为空
                if (!"".equals(dict) && null != dict){
                    return dict;
                }else {
                    return null;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }
/**
 * 删除操作
 */
    /**
     * public <T>  t
     * 通过主键ID删除信息
     * @param dict
     * @return
     */
    public Integer delectDict(Dict dict){
        //先判断要删除的信息是否为空
        if (!"".equals(dict) && null != dict){
            try {
                //调用父类方法删除
                Integer de = super.delete(dict);
                //受影响的行数
                if (de > 0){
                    return de;
                }else {
                    return null;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 批量删除
     * @param dictIds
     * @return
     */
    public Integer delectAllDict(List<Integer> dictIds){
        //先判断查询到的数据是否大于0，
        if (dictIds.size() > 0){
            try {
                //大于0，根据dictIds删除字典信息
                Integer deleted = super.deleteByIds(dictIds);
                //判断修改受影响的行数
                if (deleted > 0){
                    return deleted;
                }else {
                    return null;
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        return null;
    }

/**
 * 修改操作
 */
    /**
     * 修改字典信息
     * @param dict
     * @return
     */
    public Integer updateDict( Dict dict){
        //判断要修改的信息是否为空
        if (!"".equals(dict) && null != dict){
            try {
                //不为空，调用父类的方法执行修改操作
                Integer integer = super.update(dict);
                //判断修改受影响的行数（说明已经修改了）
                if (integer > 0){
                    //如果大于0就返回受影响的行数
                    return integer;
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        return null;
    }
/**
 * 新增操作
 */
    /**
     * 新增数据
     * @param dict
     * @return
     */
    public Integer inserDict(Dict dict){
        //判断是否传值成功
        if (!"".equals(dict) && null !=dict){
            //把值引进来
            dict.setKeyy(dict.getKeyy())
               .setValuee(dict.getValuee())
               .setFieldName(dict.getFieldName())
               .setTableName(dict.getTableName());
            Integer ins = super.add(dict);
            // 判断 受影响行数是否大于0，新增是否成功
            if (ins >0){
                return ins;//TODO 待定,返回值不确定
            }else {
                return null;
            }
        }
        return null;
    }
}
