package com.aaa.lyf.service;

import com.aaa.lyf.base.BaseService;
import com.aaa.lyf.model.User;
import com.aaa.lyf.vo.TokenVo;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @Author: LYF MESSI
 * @Date: 2020/7/15 19:36
 * @version: 1.0
 * @Description:
 */
@Service
public class LoginService  extends BaseService<User> {
    /**
     * @Author  LYF MESSI
     * @date: 2020/7/15 21:36
     * @description:
     * 执行登录操作
     *
     *         pojo：实体类
     *         povo:封装类型(当在实际开发中，会有很多种情况导致多表联查的时候无法装载数据--->我就根据返回前端的数据自己
     *        去封装一个对象出来---->view object)
     * @param null
     * @return
     */
    public TokenVo doLogin(User user){
        TokenVo tokenVo = new TokenVo();
        User user1 = new User();
        if (null != user){
            user1.setUsername(user.getUsername());
            User user2 = super.selectOne(user1);
            if (null == user2){
                tokenVo.setIfsuccess(false).setType(1);
                return tokenVo;
            }else {
                user1.setPassword(user.getPassword());
                User user3 = super.selectOne(user1);
                if (null == user3){
                    tokenVo.setIfsuccess(false).setType(2);
                    return tokenVo;
                }else{
                    // 登录成功
                    /**
                     *
                     * !!!!!!mybatis是无法检测连接符的，他会把连接符进行转译(\\-)
                     * 需要把连接符替换掉
                     *
                     *
                     */
                    String token = UUID.randomUUID().toString().replaceAll("-","");
                    user3.setToken(token);
                    Integer updateResult = super.update(user3);
                    if (updateResult > 0 ){
                        tokenVo.setIfsuccess(true).setToken(token);

                    }else {
                        tokenVo.setIfsuccess(false).setType(4);
                        return tokenVo;
                    }
                }
            }
        }else {
            tokenVo.setIfsuccess(false).setType(4);
            return tokenVo;
        }
        return  tokenVo;
    }

}
