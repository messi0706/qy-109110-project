package com.aaa.lyf.controller;

import com.aaa.lyf.base.BaseController;
import com.aaa.lyf.model.News;
import com.aaa.lyf.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class NewsController extends BaseController {
    @Autowired
    private NewsService newsService;

    /**
     * 查询全部
     * @param id
     * @return
     */
    @GetMapping("/selectAllN")
    public List<News> selectAllN(@RequestParam("id") Long id){
        List<News> list = newsService.selectAllNw(id);
        if (!"".equals(list) && null != list){
            return list;
        }
        return null;
    }

    /**
     * 通过标题查询信息
     * @param title
     * @return
     */
    @GetMapping("/selectByT")
    public News selectByT(@RequestParam("/title") String title){
        News news = newsService.selectByTit(title);
        if (!"".equals(news) && null != news){
            return news;
        }
        return null;
    }
}
