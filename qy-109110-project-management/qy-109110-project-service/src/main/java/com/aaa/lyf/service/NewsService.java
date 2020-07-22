package com.aaa.lyf.service;

import com.aaa.lyf.base.BaseService;
import com.aaa.lyf.mapper.NewsMapper;
import com.aaa.lyf.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class NewsService extends BaseService<News> {
    @Autowired
    private NewsMapper newsMapper;

    /**
     * 查询全部
     * @param id
     * @return
     */
    public List<News> selectAllNw(Long id){
        List<News> lista = null;
        try {
            lista = newsMapper.selectAllNews(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        if (!"".equals(lista) && null != lista){
            return lista;
        }
        return null;
    }

    /**
     * 通过标题查询信息
     * @param title
     * @return
     */
    public News selectByTit(String title){
        if (title != null){
            try {
                News news = newsMapper.selectByTitle(title);
                if (!"".equals(news) && null != news){
                    return news;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }
}
