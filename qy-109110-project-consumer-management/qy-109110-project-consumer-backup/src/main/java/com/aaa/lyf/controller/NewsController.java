package com.aaa.lyf.controller;

import com.aaa.lyf.base.BaseController;
import com.aaa.lyf.base.ResultData;
import com.aaa.lyf.model.News;
import com.aaa.lyf.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class NewsController  extends BaseController {
    @Autowired
    private IProjectService iProjectService;

    /**
     * 查询全部信息
     * @param id
     * @return
     */
    @GetMapping("/selectAll")
    public ResultData selectAll(@RequestParam("id") Long id){
        List<News> list = iProjectService.selectAllN(id);
        if (!"".equals(list) && null != list){
            return super.selectSuccess(list);
        }
        return super.selectFalse();
    }
    //通过标题查询数据
    @GetMapping("/selectBy")
    public ResultData selectBy(@RequestParam("/title") String title){
        News newssa = iProjectService.selectByT(title);
        if (!"".equals(newssa) && null != newssa){
            return  super.selectSuccess(newssa);
        }
        return super.selectFalse();
    }

}
