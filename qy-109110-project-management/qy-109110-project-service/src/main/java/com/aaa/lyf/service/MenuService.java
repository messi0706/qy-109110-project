package com.aaa.lyf.service;

import cn.hutool.core.date.DateUtil;
import com.aaa.lyf.base.BaseService;
import com.aaa.lyf.mapper.MenuMapper;
import com.aaa.lyf.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: LYF MESSI
 * @Date: 2020/7/17 14:47
 * @version: 1.0
 * @Description:
 */
@Service
public class MenuService extends BaseService<Menu> {

    @Autowired
    private MenuMapper menuMapper;

    /**
     * @Author  LYF MESSI
     * @date: 2020/7/17 14:47
     * @description:    获取菜单信息
     * @param null
     * @return
     */

    public List<Menu> selectAllMenus(){
        //菜单
        List<Menu> menusList = new ArrayList<Menu>();
        //菜单的全部信息
        List<Menu> allMenusList = menuMapper.selectAll();
        if (null != allMenusList&& allMenusList.size() > 0 ){
            //拿到一级菜单
            for (int i = 0 ; i  < allMenusList.size(); i++) {
                Menu menu = allMenusList.get(i);
                if (menu.getParentId()==0){
                    //是一级菜单
                    menusList.add(menu);
                }

            }
            //给一级菜单设置子菜单
            for (Menu menu:menusList){
                menu.setSubMenu(getSubMenu(menu.getMenuId(),allMenusList));

            }
        }

        return menusList;
    }
/**
 * @Author  LYF MESSI
 * @date: 2020/7/17 15:41
 * @description: 获取上一级菜单的子菜单
 * @param null
 * @return
 */

private List<Menu> getSubMenu(Long menuId,List<Menu> allMenus){
    //子菜单
    List<Menu> subMenus=new ArrayList<Menu>();
    for (Menu menu:
            allMenus) {
        if (menu.getParentId().equals(menuId)){
            subMenus.add(menu);
        }
    }
    //子菜单的下一级
    //疑问：当递归进入，查找子菜单的子菜单，那么子菜单的数据现在在哪，是在下面循环代码中的subMenus中
    for (Menu menu: subMenus) {
        menu.setSubMenu(getSubMenu(menu.getMenuId(),allMenus));
    }
    if (subMenus.size()==0){
        return null;
    }
    return subMenus;
}
/**
 * @Author  LYF MESSI
 * @date: 2020/7/17 15:42
 * @description: 新增菜单和按钮
 * @param null
 * @return
 */
public Boolean insertMenuOrButton(Menu menu){
    String createTime = DateUtil.now();
    menu.setCreateTime(createTime);
    try{
        Integer add = super.add(menu);
        if (add > 0){
            return true;
        }else {
            return false;
        }
    }catch (Exception e){
        e.printStackTrace();
    }
    return false;
}
/**
 * @Author  LYF MESSI
 * @date: 2020/7/17 15:43
 * @description: 根据主键修改菜单和按钮信息
 * @param null
 * @return
 */
public Boolean updateMenuOrButton(Menu menu){
    String time = DateUtil.now();
    menu.setModifyTime(time);
    try {
        Integer update = super.update(menu);
        if (update>0){
            return true;
        }else {
            return false;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return false;
}
/**
 * @Author  LYF MESSI
 * @date: 2020/7/17 15:43
 * @description: 根据主键id删除菜单和按钮
 * @param null
 * @return
 */
public Boolean deleteMenuOrButton(Long menuId){
    int i = menuMapper.deleteByPrimaryKey(menuId);
    if (i>0){
        return true;
    }else {
        return false;
    }
}
}
