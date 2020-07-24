package com.zff.aspectjdemo;

import android.util.Log;
import android.view.View;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

@Aspect
public class ClickAspect {
    private static final String TAG = "ClickAspectJ";

    // 方式一、
//    @Around("execution(* android.view.View.OnClickListener.onClick(..))")
//    public void onClickMethodAround(ProceedingJoinPoint joinPoint) throws Throwable {
//   ...
//    }

    // * 所处的位置表示的是返回值，* 是通配符，表示的是任意类型,空格可不要
    // .. 表示任意类型、任意个数的参数
    @Pointcut("execution(* android.view.View.OnClickListener.onClick(..))")
    public void clickMethod(){}

    // onClickMethodAround 表示的实际切入代码
    @Around("clickMethod()")
    public void onClickMethodAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Log.d(TAG,joinPoint.toString()); // execution(void com.zff.aspectjdemo.MainActivity.2.onClick(View))
        Log.d(TAG,joinPoint.getSignature().toString()); // void com.zff.aspectjdemo.MainActivity.2.onClick(View)
        Log.d(TAG,joinPoint.getTarget().toString()); // com.zff.aspectjdemo.MainActivity$2@e924fe8
        Log.d(TAG,joinPoint.getThis().toString()); // com.zff.aspectjdemo.MainActivity$2@e924fe8
        Log.d(TAG,joinPoint.getKind()); // method-execution
        Log.d(TAG,joinPoint.getSourceLocation().toString()); // MainActivity.java:26
        Log.d(TAG,joinPoint.getStaticPart().toString()); // execution(void com.zff.aspectjdemo.MainActivity.2.onClick(View))
        Log.d(TAG,"===================这是分割线====================");
        Object[] args = joinPoint.getArgs();
        Log.d(TAG, Arrays.toString(args));
        View view = null;
        for(Object arg:args){
            if (arg instanceof View) {
                view = (View) arg;
            }
        }
        //获取View 的 string id
        String resEntryName = null;
        String resName = null;
        if(view != null){
            // btn1
            resEntryName = view.getContext().getResources().getResourceEntryName(view.getId());
            // com.zff.aspectjdemo:id/btn1
            resName = view.getContext().getResources().getResourceName(view.getId());
        }
        Log.d(TAG, resEntryName);
        Log.d(TAG, resName);
        // 不加下面这行代码会拦截掉点击事件
        joinPoint.proceed();
    }
}

// @Around：是advice，也就是具体的插入点。
// @Around该方法的逻辑会包含切入点前后，如果用到该注解，记得自己需要控制切入点的执行逻辑，调用joinPoint.proceed()。
// 如果使用@Before注解，表示的是在切入点之前执行，
// @After表示在切入点之后执行，此时不需要调用joinPoint.proceed()。


// execution：处理JPoint的类型，例如call、execution。

// execution表示JPoint是执行方法的地方，AspectJ会对被执行方法做处理。
// 而call表示JPoint是调用方法的地方，AspectJ会对调用处做处理。

//任意公共方法的执行：
//        execution（public * *（..））

//任何一个名字以“set”开始的方法的执行：
//        execution（* set*（..））

//AccountService接口定义的任意方法的执行：
//        execution（* com.xyg.service.AccountService.*（..））

//在service包或其子包中定义的任意方法的执行：
//        execution（* com.xyz.service..*.*（..））
