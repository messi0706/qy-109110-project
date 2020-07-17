package com.aaa.lyf.controller;

import com.aaa.lyf.model.Dict;
import com.aaa.lyf.service.DictService;
import com.github.pagehelper.PageInfo;
import lombok.experimental.Accessors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 在controller只有boolean类型的才需要判断，其他不需要判断
 */

@RestController
public class DictController {
    @Accessors
    private DictService dictService;

    /**
     * 分页查询全部信息
     * @RequestMapping("/selectAllDictByPage")==public PageInfo selectAllDictByPag名字一样，可以随便写
     * dictService.selectAllDictByPage-->调用的是service中的方法
     * @param dict
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping("/selectAlDictByPage")
    public PageInfo selectAlDictByPage(@RequestBody Dict dict, @RequestParam("pageNo")Integer pageNo,@RequestParam("pageSize")Integer pageSize){
        PageInfo pageInfo = dictService.selectAllDictByPage(dict,pageNo,pageSize);
        if (!"".equals(pageInfo) && null != pageInfo){
            return pageInfo;
        }
        return null;
    }

    /**
     * 通过ID查询信息
     * @param dictId
     * @return
     */
    @RequestMapping("/selectById")
    public Dict selectById(@RequestParam("dictId")Integer dictId){
        Dict dict = dictService.selectById(dictId);
        if (!"".equals(dict) && null !=dict){
            return dict;
        }
        return null;
    }

    /**
     * 通过主键ID删除信息
     * @param dict
     * @return
     */
    @RequestMapping("/delectDict")
    public Integer delectDict(@RequestBody Dict dict){
        Integer in1 = dictService.delectDict(dict);
        if (!"".equals(in1) && null != in1){
            return in1;
        }
        return null;
    }
    /**
     * 批量删除
     */
    @RequestMapping("/delectAllDict")
    public Integer delectAllDict(@RequestParam("dictIds") List<Integer> dictIds){
        Integer in2 = dictService.delectAllDict(dictIds);
        if (!"".equals(in2) && null != in2){
            return in2;
        }
        return null;
    }

    /**
     * 修改字典信息
     * @param dict
     * @return
     */
    @RequestMapping("/updateDict")
    public Integer updateDict(@RequestBody Dict dict){
        Integer in3 = dictService.updateDict(dict);
        if (!"".equals(in3) && null != in3){
            return in3;
        }
        return null;
    }

    /**
     * 新增数据
     * @param dict
     * @return
     */
    @RequestMapping("/inserDict")
    public Integer inserDict(@RequestBody  Dict dict){
        Integer in4 = dictService.inserDict(dict);
        if (!"".equals(in4) && null != in4){
            return in4;
        }
        return null;
    }
}
