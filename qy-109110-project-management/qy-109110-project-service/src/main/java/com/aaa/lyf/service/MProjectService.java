package com.aaa.lyf.service;

import com.aaa.lyf.base.BaseService;
import com.aaa.lyf.mapper.MappingProjectMapper;
import com.aaa.lyf.model.MappingProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 项目汇交
 */
@Service
public class MProjectService extends BaseService<MappingProject> {
    @Autowired
    private MappingProjectMapper mappingProjectMapper;
    /**
     *   查询全部信息
      */
    public List<MappingProject> selectAllMappingPrjt(Long id){
        List<MappingProject> list = null;
        try {
            list = mappingProjectMapper.selectAllMP(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        if (!"".equals(list) && null != list){
            return list;
        }
        return null;
    }
   // 通过类型查询全部信息
    public List<MappingProject>selectByProjectType(String projectType){
        List<MappingProject> projectList = null;
        try {
            projectList = mappingProjectMapper.selectByType(projectType);
        }catch (Exception e){
            e.printStackTrace();
        }
        if (!"".equals(projectList) && null != projectList){
            return projectList;
        }
        return null;
    }
}
