package com.zff.permissiontest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)   //作用域为方法
@Retention(RetentionPolicy.RUNTIME)   //生命周期是运行时
public @interface Permission {
    String[] value() default {"-1","-2"};   //权限值

    int requestCode() default 10086;
}
