package com.aaa.lyf.mapper;

import com.aaa.lyf.model.Dict;
import tk.mybatis.mapper.common.Mapper;

public interface DictMapper extends Mapper<Dict> {
    //通过ID查询全部
   Dict selectById(Integer dcitId);

}