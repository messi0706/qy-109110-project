package com.aaa.lyf.controller;

import com.aaa.lyf.model.CheckPerson;
import com.aaa.lyf.service.CheckPersonService;
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
public class CheckPersonController {
    @Autowired
    private CheckPersonService checkPersonService;

    /**
     * 查询信息
     * @param checkPerson
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping("/selectAllCP")
    public PageInfo selectAllCP(@RequestBody CheckPerson checkPerson, @RequestParam("pageNo")Integer pageNo,@RequestParam("pageSize")Integer pageSize){
        PageInfo pageInfo = checkPersonService.selectAllCPerson(checkPerson,pageNo,pageSize);
        if (!"".equals(pageInfo) && null != pageInfo){
            return pageInfo;
        }
        return null;
    }

    /**
     * 修改数据
     * @param checkPerson
     * @return
     */
    @RequestMapping("/updateByIdCont")
    public Integer updateByIdCont(@RequestBody CheckPerson checkPerson){
        Integer inta = checkPersonService.updateById(checkPerson);
        if (!"".equals(inta) && null != inta){
            return inta;
        }
        return null;
    }

    /**
     * 删除数据
     * @param checkPerson
     * @return
     */
    @RequestMapping("/delectByIdCont")
    public Integer delectByIdCont(@RequestBody CheckPerson checkPerson){
        Integer intb = checkPersonService.delectById(checkPerson);
        if (!"".equals(intb) && null != intb){
            return intb;
        }
        return  null;
    }

    /**
     * 新增数据
     * @param checkPerson
     * @return
     */
    @RequestMapping("/insertByIdCont")
    public Integer insertByIdCont(@RequestBody CheckPerson checkPerson){
        Integer intc = checkPersonService.insertById(checkPerson);
        if (!"".equals(intc) && null != intc){
            return intc;
        }
        return null;
    }

}
