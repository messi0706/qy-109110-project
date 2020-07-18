package com.aaa.lyf.service;


import com.aaa.lyf.base.ResultData;
import com.aaa.lyf.model.LoginLog;
import com.aaa.lyf.model.*;

import com.github.pagehelper.PageInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

/**
 * @Author: LYF MESSI
 * @Date: 2020/7/15 19:03
 * @version: 1.0
 * @Description:
 */
@FeignClient(value = "")
public interface IProjectService {
    /**
     * @Author  LYF MESSI
     * @date: 2020/7/15 19:06
     * @description:
     * 执行登录操作
     * @param null
     * @return
     */
    @PostMapping("/doLogin")
    ResultData doLogin(@RequestBody User user);

    /**
     * @Description: 新增日志
     * @Param:
     * @return:
     * @Author: zyf
     * @date: 2020/7/16 0016
     */
    @PostMapping("/addLoginLog")
    Integer addLoginLog(@RequestBody LoginLog loginLog);
    /**
     *@Description:
     * 新增用户
     *@Param:
     *@return:
     *@Author: zyf
     *@date: 2020/7/16 0016
     */
    @PostMapping("/addUser")
    Boolean addUser(@RequestBody User user);

    /**
     *@Description:
     * 查询所有的角色信息
     *@Param:
     *@return:
     *@Author: zyf
     *@date: 2020/7/16 0016
     */
    @GetMapping("/selectAllRole")
    PageInfo selectAllRole(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize);

    /**
     *@Description:
     * 根据条件查询
     *@Param:
     *@return:
     *@Author: zyf
     *@date: 2020/7/16 0016
     */
    @PostMapping("/selectRoleByField")
    PageInfo selectRoleByField(@RequestBody Map map,@RequestParam("pageNo") Integer pageNo,@RequestParam("pageSize") Integer pageSize);

    /**
     *@Description:
     * 根据主键查询角色信息
     *
     *@Param:
     *@return:
     *@Author: zyf
     *@date: 2020/7/16 0016
     */
    @GetMapping("selectRoleByPrimaryKey")
    Role selectRoleByPrimaryKey(@RequestParam("ruleId") Long roleId);

    /**
     *@Description:
     * 查询所有的用户
     *@Param:
     *@return:
     *@Author: zyf
     *@date: 2020/7/16 0016
     */
    @PostMapping("/selectAllUser")
    PageInfo selectAllUser(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize);
    /**
     *@Description:
     * 根据主键删除用户
     *@Param:
     *@return:
     *@Author: zyf
     *@date: 2020/7/16 0016
     */
    @PostMapping("/deleteUser")
    Integer deleteUser(@RequestBody User user);
    /**
     *@Description:
     * 根据id删除多用户
     *@Param:
     *@return:
     *@Author: zyf
     *@date: 2020/7/16 0016
     * @param id
     */
    @PostMapping("/deleteUsersById")
    Integer deleteUsersById(@RequestParam("id") List<Integer> ids);
    /**
     *@Description:
     * 根据id查询用户信息
     *
     *@Param:
     *@return:
     *@Author: zyf
     *@date: 2020/7/16 0016
     */
    @GetMapping("/selectUserById")
    User selectUserById(@RequestParam("id") Long id);
    /**
     *@Description:
     * 根据id修改用户信息
     *@Param:
     *@return:
     *@Author: zyf
     *@date: 2020/7/16 0016
     */
    @PostMapping("/updateUserById")
    Integer updateUserById(@RequestBody User user);


    //Menu

    /**
     * @Author  LYF MESSI
     * @date: 2020/7/17 14:56
     * @description: 获取全部菜单信息
     * @param null
     * @return
     */
    @GetMapping("/menu/getMenus")
    List<Menu> selectAllMenus();


    /**
     * @Author  LYF MESSI
     * @date: 2020/7/17 14:59
     * @description: 添加菜单和按钮
     * @param null
     * @return
     */
    @GetMapping("/menu/insrtMenuOrButton")
    ResultData<Menu> inserMenuOrButton(@RequestBody Menu menu);

    /**
     * @Author  LYF MESSI
     * @date: 2020/7/17 15:01
     * @description: 修改菜单和按钮
     * @param null
     * @return
     */
    @PostMapping("/menu/updateMenuOrButton")
    ResultData<Menu> updateMenuOrButton(@RequestBody Menu menu);

    /**
     * @Author  LYF MESSI
     * @date: 2020/7/17 15:02
     * @description:  删除按钮和菜单
     * @param null
     * @return
     */
    @PostMapping("/menu/deleteMenuOrButton")
    ResultData<Menu> deleteMenuOrButton(@RequestParam ("menuId") long menuId);

    /**
     * 字典
     */
    /**
     * 分页查询全部信息
     * @param dict
     * @param pageNo
     * @param pageSizez
     * @return
     */
    @RequestMapping("/sselectAlDictByPage")
    PageInfo selectAlDictByPage(@RequestBody Dict dict,@RequestParam("pageNo") Integer pageNo,@RequestParam("pageSize") Integer pageSizez);

    /**
     * 通过ID查询信息
     * @param dictId
     * @return
     */
    @RequestMapping("/selectById")
    Dict selectById(@RequestParam("dictId") Integer dictId);

    /**
     * 通过主键ID删除信息
     * @param dict
     * @return
     */
    @RequestMapping("/delectDict")
    Integer delectDict(@RequestBody Dict dict);

    /**
     * 批量删除
     * @param dictIds
     * @return
     */
    @RequestMapping("/delectAllDict")
    Integer delectAllDict(@RequestParam("dictIds") List<Integer> dictIds);

    /**
     * 修改操作
     * @param dict
     * @return
     */
    @RequestMapping("/updateDict")
    Integer updateDict(@RequestBody Dict dict);

    /**
     * 新增数据
     * @param dict
     * @return
     */
    @RequestMapping("/inserDict")
    Integer inserDict(@RequestBody Dict dict);

    //dept

    /**
     *  递归查询根据 parentId（父id）查询该部门及其子部门
     **/
    @GetMapping("/selectAllDeptByParentId")
    List<Dept> selectAllDeptByParentId(@RequestParam("parentId") Long parentId);


    /**
     * 查询-动态sql查询条件：部门名称 创建时间区间
     **/
    @PostMapping("/selectDeptInfoByField")
    List<Dept> selectDeptInfoByField(@RequestBody Map map);

    /**
     *查询部门信息，根据主键id查询部门的信息
     **/
    @GetMapping("/selectDeptByDeptId")
    Dept selectDeptByDeptId(@RequestParam("deptId") Integer deptId);

    /**
     *新增部门信息
     **/
    @PostMapping("/insertDept")
    Boolean insertDept(@RequestBody Dept dept);

    /**
     * 通过主键 执行删除操作

     **/
    @PostMapping("/deleteDeptByPrimaryKey")
    Boolean deleteDeptByPrimaryKey(@RequestBody Dept dept);

    /**
     *批量删除 调用父类的批量删除方法（根据主键），执行删除操作

     **/
    @PostMapping("/batchDeleteByPrimaryKey")
    Boolean batchDeleteByPrimaryKey(@RequestBody List<Object> ids);

    /**
     *  修改，通过主键-修改部门信息
     **/
    @PostMapping("/updateDeptByPrimaryKey")
    Boolean updateDeptByPrimaryKey(@RequestBody Dept dept);
    /**
     *@Description:
     * 获取登记的项目信息
     *@Param:
     *@return:
     *@Author: zyf
     *@date: 2020/7/17 0017
     */
    @GetMapping("/selectAuditInfo")
    PageInfo selectAuditInfo(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize);
    /**
     *@Description:
     * 模糊查询项目信息
     *@Param:
     *@return:
     *@Author: zyf
     *@date: 2020/7/17 0017
     */
    @GetMapping("/fuzzySelectAudit")
    PageInfo fuzzySelectAudit(@RequestParam("pageNo") Integer pageNo,@RequestParam("pageSize") Integer pageSize,
                              @RequestParam("projectName") String projectName);
}



