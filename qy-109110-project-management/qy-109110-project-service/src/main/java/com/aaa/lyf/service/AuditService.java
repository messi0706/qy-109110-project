package com.aaa.lyf.service;


import com.aaa.lyf.mapper.AuditMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditService {
    @Autowired
    private AuditMapper auditMapper;
    public List selectAuditInfo(){
        List list = auditMapper.selectAuditInfo();
        if (list.size()>0){
            return list;
        }
return null;
    }

    public List fuzzySelectAudit(String projectName){
        List list = auditMapper.fuzzySelectAudit(projectName);
        if (list.size()>0){
            return list;
        }
        return null;
    }
}
