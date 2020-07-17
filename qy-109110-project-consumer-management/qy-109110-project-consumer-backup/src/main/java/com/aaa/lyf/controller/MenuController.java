package com.aaa.lyf.controller;

import com.aaa.lyf.base.BaseController;
import com.aaa.lyf.base.ResultData;
import com.aaa.lyf.model.Menu;
import com.aaa.lyf.service.IProjectService;
import com.sun.xml.internal.messaging.saaj.soap.impl.FaultElementImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: LYF MESSI
 * @Date: 2020/7/17 15:09
 * @version: 1.0
 * @Description: 菜单控制层
 */

@RestController
@RequestMapping("/menu")
@Api(tags = "菜单管理的接口",value = "菜单信息")
public class MenuController extends BaseController {
    @Autowired
    private IProjectService iProjectService;

    /**
     * @Author  LYF MESSI
     * @date: 2020/7/17 15:13
     * @description: 获取全部菜单
     * @param null
     * @return
     */

    @GetMapping("/getMenus")
    @ApiOperation(value = "菜单管理",notes = "查询所有菜单功能")
    public ResultData<Menu> selectAllMenus(){
        List<Menu> menus = iProjectService.selectAllMenus();
        if (null == menus || menus.size() < 0){
            return super.selectFalse();
        }
        return super.selectSuccess(menus);
    }

    /**
     * @Author  LYF MESSI
     * @date: 2020/7/17 15:24
     * @description: 新增菜单
     * @param null
     * @return
     */
    @PostMapping("/insertMenuOrButton")
    @ApiOperation(value = "新增菜单或按钮", notes = "新增菜单或按钮的功能")
    public ResultData<Menu> insertMenuOrButton(@RequestBody Menu menu){
        return iProjectService.inserMenuOrButton(menu);
    }
    /**
     * @Author  LYF MESSI
     * @date: 2020/7/17 15:21
     * @description: 修改菜单和按钮
     * @param null
     * @return
     */
    @PostMapping("/insertMenusOrButton")
    @ApiOperation(value = "修改菜单或者按钮", notes = "修改菜单和按钮信息的功能")
    public ResultData<Menu> updateMenuOrButton(@RequestBody Menu menu) {
        return iProjectService.updateMenuOrButton(menu);
    }

    /**
     * @Author  LYF MESSI
     * @date: 2020/7/17 15:27
     * @description:  删除菜单和按钮
     * @param null
     * @return
     */
    @PostMapping("/deleteMenuOrButton")
    @ApiOperation(value = "删除菜单或按钮", notes = "删除菜单或按钮的功能")
    public ResultData<Menu> deleteMenuOrButton(@RequestParam("menuId") Long menuId){
        return iProjectService.deleteMenuOrButton(menuId);
    }
}
