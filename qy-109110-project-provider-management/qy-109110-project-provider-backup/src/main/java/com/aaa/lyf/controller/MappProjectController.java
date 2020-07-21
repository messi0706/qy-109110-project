package com.aaa.lyf.controller;

import com.aaa.lyf.model.MappingProject;
import com.aaa.lyf.service.MProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/**
 * 项目汇交
 */
@RestController
public class MappProjectController {
    @Autowired
    private MProjectService mProjectService;

    /**
     * 查询全部信息
     * @param id
     * @return
     */
    @RequestMapping("/selectAllMappPrjt")
    public List<MappingProject> selectAllMappPrjt(@RequestParam("id") Long id){
        List<MappingProject> lista = mProjectService.selectAllMappingPrjt(id);
        if (null !=lista){
            return lista;
        }
        return null;
    }

    /**
     * 通过类型查询信息
     * @param projectType
     * @return
     */
    @RequestMapping("/selectByProjectT")
    public List<MappingProject>selectByProjectT(@RequestParam("projectType") String projectType){
        List<MappingProject> listc = mProjectService.selectByProjectType(projectType);
        if (null != listc){
            return listc;
        }
        return null;
    }
}
