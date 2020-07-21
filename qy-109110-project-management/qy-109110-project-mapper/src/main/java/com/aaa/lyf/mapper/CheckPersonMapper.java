package com.aaa.lyf.mapper;

import com.aaa.lyf.model.CheckPerson;
import com.github.pagehelper.PageInfo;
import tk.mybatis.mapper.common.Mapper;

public interface CheckPersonMapper extends Mapper<CheckPerson> {
    PageInfo<CheckPerson> selectListByCheckPson(CheckPerson checkPerson, Integer pageNo,Integer pageSize);
}