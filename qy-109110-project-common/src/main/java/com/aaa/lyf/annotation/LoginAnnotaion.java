package com.aaa.lyf.annotation;

/**
 * @Author: LYF MESSI
 * @Date: 2020/7/15 19:50
 * @version: 1.0
 * @Description:
 *
 *        @Target():
 *            标识了自己所自定义注解的使用范围(也就是说标识了自定义使用于方法，类，属性...)
 *        @Retention():
 *            标识了自定义注解所生效的时间
 *            RUNTIME:项目运行的时候该自定义生效
 *            TEST:在有junit的时候生效
 *        @Inherited:
 *           继承(当该注解的时候，自定义的作用范围必须是类)
 *
 *        所有的注解是没有任何实际意义的，只是起到了一个标识的作用，真正有意义的代码在于实现了这个注解的业务逻辑
 *       自定义注解+AOP实现自动日志，真正实现的地方在于AOP，自定义注解只是做了一个标识
 *
 */
public @interface LoginAnnotaion {
    /**
     * @Author  LYF MESSI
     * @date: 2020/7/15 19:53
     * @description:
     *       要操作的类型
     * @param null
     * @return
     */
   String opeationType();

   /**
    * @Author  LYF MESSI
    * @date: 2020/7/15 19:54
    * @description:  要操作的具体内容
    * @param null
    * @return
    */
   String opeationName();
}
