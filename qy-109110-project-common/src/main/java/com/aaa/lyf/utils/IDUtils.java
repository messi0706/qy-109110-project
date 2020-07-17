package com.aaa.lyf.utils;

import java.util.UUID;

/**
 * @Author: LYF MESSI
 * @Date: 2020/7/16 20:55
 * @version: 1.0
 * @Description:
 */
public class IDUtils {
    private IDUtils(){

    }



    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
