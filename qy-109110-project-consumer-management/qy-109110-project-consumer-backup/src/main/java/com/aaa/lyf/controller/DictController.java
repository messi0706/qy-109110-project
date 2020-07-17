package com.aaa.lyf.controller;

import com.aaa.lyf.base.BaseController;
import com.aaa.lyf.base.ResultData;
import com.aaa.lyf.model.Dict;
import com.aaa.lyf.service.IProjectService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DictController extends BaseController {
    @Autowired
    private IProjectService iProjectService;

    /**
     * 分页查询全部信息
     * @param dict
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping("/selectAllDict")
    public ResultData selectAllDict(@RequestBody Dict dict, @RequestParam("pageNo")Integer pageNo, @RequestParam("pageSize")Integer pageSize){
        PageInfo pageInfo1 = iProjectService.selectAlDictByPage(dict,pageNo,pageSize);
        if (!"".equals(pageInfo1) && null != pageInfo1){
            return super.selectSuccess(pageInfo1);
        }
        return super.delectFalse();
    }

    /**
     * 通过ID查询信息
     * @param dictId
     * @return
     */
    @RequestMapping("/selectByIddict")
    public ResultData selectByIddict(@RequestParam("dictId") Integer dictId){
        Dict dict1 = iProjectService.selectById(dictId);
        if (!"".equals(dict1) && null != dict1){
            return super.selectSuccess(dict1);
        }
        return super.selectFalse();
    }

    /**
     * 通过主键ID删除信息
     * @param dict
     * @return
     */
    @RequestMapping("/delectDictById")
     public ResultData delectDictById(@RequestBody Dict dict){
        Integer int1 = iProjectService.delectDict(dict);
        if (!"".equals(int1) && null != int1){
            return super.delectSuccess(int1);
        }
        return super.insertFalse();

     }

    /**
     * 批量删除
     * @param dictIds
     * @return
     */
     @RequestMapping("/delectAllById")
     public ResultData delectAllById(@RequestParam("dictIds") List<Integer> dictIds){
         Integer int2 = iProjectService.delectAllDict(dictIds);
         if (!"".equals(int2) && null != int2){
             return super.delectSuccess(int2);
         }
         return super.delectFalse();
     }

    /**
     * 修改操作
     * @param dict
     * @return
     */
     @RequestMapping("/updateDictAll")
     public ResultData updateDictAll(@RequestBody Dict dict){
         Integer int3 = iProjectService.updateDict(dict);
         if (!"".equals(int3) && null != int3){
             return super.updateSuccess(int3);
         }
         return super.updateFalse();
     }

    /**
     * 新增数据
     * @param dict
     * @return
     */
     @RequestMapping("/inserDictAll")
     public ResultData inserDictAll(@RequestBody Dict dict){
         Integer int4 = iProjectService.inserDict(dict);
         if (!"".equals(int4) && null != int4){
             return super.insertSuccess(int4);
         }
         return super.insertFalse();
     }
}
