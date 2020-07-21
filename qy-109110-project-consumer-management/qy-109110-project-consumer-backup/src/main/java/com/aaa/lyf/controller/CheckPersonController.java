package com.aaa.lyf.controller;

import com.aaa.lyf.base.BaseController;
import com.aaa.lyf.base.ResultData;
import com.aaa.lyf.model.CheckPerson;
import com.aaa.lyf.service.IProjectService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 双随机抽查--->抽查人员
 */
@RestController
public class CheckPersonController extends BaseController {

    @Autowired
    private IProjectService iProjectService;

    /**
     * 分页查询数据
     * @param checkPerson
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping("/selectAllCPSumer")
    public ResultData selectAllCPSumer(@RequestBody CheckPerson checkPerson, @RequestParam("pageNo")Integer pageNo, @RequestParam("pageSize")Integer pageSize){
        PageInfo pageInfo = iProjectService.selectAllCP(checkPerson,pageNo,pageSize);
        if (!"".equals(pageInfo) && null != pageInfo){
            return super.selectSuccess(pageInfo);
        }
        return super.selectFalse();
    }

    /**
     * 修改数据
     * @param checkPerson
     * @return
     */
    @RequestMapping("/updateByIdSumer")
    public ResultData updateByIdSumer(@RequestBody CheckPerson checkPerson){
        Integer inta = iProjectService.updateByIdCont(checkPerson);
        if (!"".equals(inta) && null != inta){
            return super.updateSuccess(inta);
        }
        return super.updateFalse();
    }

    /**
     * 删除数据
     * @param checkPerson
     * @return
     */
    @RequestMapping("/delectByIdSumer")
    public ResultData delectByIdSumer(@RequestBody CheckPerson checkPerson){
        Integer intb = iProjectService.delectByIdCont(checkPerson);
        if (!"".equals(intb) && null != intb){
            return super.delectSuccess(intb);
        }
        return  super.delectFalse();
    }

    /**
     * 新增数据
     * @param checkPerson
     * @return
     */
    @RequestMapping("/insertByIdSumer")
    public ResultData insertByIdSumer(@RequestBody CheckPerson checkPerson){
        Integer intc = iProjectService.insertByIdCont(checkPerson);
        if (!"".equals(intc) && null != intc){
            return super.insertSuccess(intc);
        }
        return super.insertFalse();
    }
}
