package com.zff.permissiontest;

import android.content.Context;
import android.util.Log;

import androidx.fragment.app.Fragment;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

@Aspect
public class PermissionAspectJ {

    /**
     * 声明切入点
     *
     * @param permission 注解中的参数
     */
    @Pointcut("execution(@com.zff.permissiontest.Permission * *(..))&& @annotation(permission)")
    public void getPermissin(Permission permission) {
    }

    /**
     * 获取切入的方法
     *
     * @param point
     * @param permission
     * @throws Throwable
     */
    @Around("getPermissin(permission)")
    public void getPointMethod(final ProceedingJoinPoint point, Permission permission) throws Throwable {
        Log.d("PermissionAspectJ", "getPointMethod");
        Context context = null;
        //获取上下文对象
        final Object thisContext = point.getThis();


        if (thisContext instanceof Context) {
            context = (Context) thisContext;
        } else if (thisContext instanceof Fragment) {
            context = ((Fragment) thisContext).getActivity();
        }
        //判断权限和上下文 是否为null
        if (context == null || permission == null || permission.value().length <= 0) {
            return;
        }

        //获取权限数据
        String[] permissinValue = permission.value();
        final int requstCode = permission.requestCode();
        Log.d("PermissionAspectJ", Arrays.toString(permissinValue) + "::" + requstCode);
        point.proceed();
    }


    @Around("execution(@com.zff.permissiontest.Permission * *(..))&& @annotation(permission)")
    public void getPointMethoddd(final ProceedingJoinPoint point, Permission permission) throws Throwable {
        Log.d("PermissionAspectJ", "getPointMethoddd");
        Context context = null;
        //获取上下文对象
        final Object thisContext = point.getThis();


        if (thisContext instanceof Context) {
            context = (Context) thisContext;
        } else if (thisContext instanceof Fragment) {
            context = ((Fragment) thisContext).getActivity();
        }
        //判断权限和上下文 是否为null
        if (context == null || permission == null || permission.value().length <= 0) {
            return;
        }

        //获取权限数据
        String[] permissinValue = permission.value();
        final int requstCode = permission.requestCode();
        Log.d("PermissionAspectJ", Arrays.toString(permissinValue) + "::" + requstCode);
        point.proceed();
    }
}
