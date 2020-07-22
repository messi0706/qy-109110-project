package com.aaa.lyf.mapper;

import com.aaa.lyf.model.MappingProject;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


public interface MappingProjectMapper extends Mapper<MappingProject> {
    /**
     * 项目汇交
     */
  //查询全部信息
    List<MappingProject> selectAllMP(Long id);
//项目类型条件查找
    List<MappingProject>selectByType(String projectType);


//    /**
//     *项目管理
//     */
//   //项目管理中查询全部信息
//    List<MappingProject>selectALlMp(Long id);
//
//    //项目管理中通过类型查询信息
//    List<MappingProject>selectALlByType(String ProjectType);
//
//    //项目管理中新增信息
//    int insertAll(MappingProject mappingProject);
}