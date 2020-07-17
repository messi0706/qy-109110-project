package com.aaa.lyf.mapper;


import com.aaa.lyf.model.Audit;
import tk.mybatis.mapper.common.Mapper;
import java.util.List;

public interface AuditMapper extends Mapper<Audit> {
    List selectAuditInfo();
    List fuzzySelectAudit(String projectName);
}
