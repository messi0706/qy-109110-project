package com.aaa.lyf.controller;

import com.aaa.lyf.base.BaseController;
import com.aaa.lyf.base.ResultData;
import com.aaa.lyf.model.Menu;
import com.aaa.lyf.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * @Author: LYF MESSI
 * @Date: 2020/7/17 15:49
 * @version: 1.0
 * @Description:
 */
public class MenuController extends BaseController {

    @Autowired
    private MenuService menuService;

    /**
     * @Description: 查询所有菜单
     * @Author: guohang
     * @Date: 2020/6/3 18:36
     * @Param: []
     * @return: List<Menu>
     */
    @GetMapping("/getMenus")
    public List<Menu> selectAllMenus(){
        return menuService.selectAllMenus();
    }


   /**
    * @Author  LYF MESSI
    * @date: 2020/7/17 15:51
    * @description: 在菜单管理中新增菜单和按钮
    * @param null
    * @return
    */
    @PostMapping("/insertMenuOrButton")
    public ResultData<Menu> insertMenuOrButton(@RequestBody Menu menu){
        Boolean aBoolean = menuService.insertMenuOrButton(menu);
        if (true == aBoolean){
            return super.insertSuccess();
        }else {
            return super.insertFalse();
        }
    }

 /**
  * @Author  LYF MESSI
  * @date: 2020/7/17 15:51
  * @description: 在菜单管理中修改菜单和按钮
  * @param null
  * @return
  */
    @PostMapping("/updateMenuOrButton")
    public ResultData<Menu> updateMenuOrButton(@RequestBody Menu menu){
        Boolean aBoolean = menuService.updateMenuOrButton(menu);
        if (true == aBoolean){
            return super.updateSuccess();
        }else {
            return super.updateFalse();
        }
    }

   /**
    * @Author  LYF MESSI
    * @date: 2020/7/17 15:50
    * @description: 删除菜单和按钮
    * @param null
    * @return
    */
    @PostMapping("/deleteMenuOrButton")
    public ResultData<Menu> deleteMenuOrButton(@RequestParam("menuId") Long menuId){
        Boolean aBoolean = menuService.deleteMenuOrButton(menuId);
        if (aBoolean == true){
            return super.delectSuccess();
        }else {
            return super.delectFalse();
        }
    }

}
