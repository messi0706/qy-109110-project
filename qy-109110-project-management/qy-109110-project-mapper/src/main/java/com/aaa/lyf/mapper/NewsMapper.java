package com.aaa.lyf.mapper;

import com.aaa.lyf.model.News;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface NewsMapper extends Mapper<News> {
    //查询全部信息
    List<News> selectAllNews(Long id);
    //通过标题查询数据
    News selectByTitle(String title);
}