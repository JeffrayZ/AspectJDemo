package com.zff.aspectjdemo;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

@Aspect
public class AnnotationAspect {
    private static final String TAG = "AnnotationAspect";

    // 方式一、
//    @Around("execution(* android.view.View.OnClickListener.onClick(..))")
//    public void onClickMethodAround(ProceedingJoinPoint joinPoint) throws Throwable {
//   ...
//    }

    // * 所处的位置表示的是返回值，* 是通配符，表示的是任意类型,空格可不要
    // .. 表示任意类型、任意个数的参数
    @Pointcut("execution(@com.zff.aspectjdemo.ToastMethodName * *(..))")
    public void toastMethod(){}

    // onClickMethodAround 表示的实际切入代码
   /* @Around("toastMethod()")
    public void onToastMethodAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Log.d(TAG,"===================这是分割线====================");
        Log.d(TAG,"我是没有返回值的方法");

        // execution(void com.zff.aspectjdemo.MainActivity.textClick())
//        Log.d(TAG,joinPoint.toString());


        // void com.zff.aspectjdemo.MainActivity.textClick()
//        Log.d(TAG,joinPoint.getSignature().toString());
        // textClick 方法名
//        Log.d(TAG,joinPoint.getSignature().getName());
        // com.zff.aspectjdemo.MainActivity 类名
//        Log.d(TAG,joinPoint.getSignature().getDeclaringTypeName());
        // MainActivity 简单类名
//        Log.d(TAG,joinPoint.getSignature().getDeclaringType().getSimpleName());

        // com.zff.aspectjdemo.MainActivity$2@e924fe8
//        Log.d(TAG,joinPoint.getTarget().toString());
        // com.zff.aspectjdemo.MainActivity 类全路径名
//        Log.d(TAG,joinPoint.getTarget().getClass().getName());


        // com.zff.aspectjdemo.MainActivity$2@e924fe8
//        Log.d(TAG,joinPoint.getThis().toString());
        // com.zff.aspectjdemo.MainActivity 类全路径名
//        Log.d(TAG,joinPoint.getThis().getClass().getName());



        // method-execution
//        Log.d(TAG,joinPoint.getKind());

        // // MainActivity.java:34
//        Log.d(TAG,joinPoint.getSourceLocation().toString());
        // class com.zff.aspectjdemo.MainActivity
//        Log.d(TAG,joinPoint.getSourceLocation().getWithinType().toString());
        // MainActivity.java
//        Log.d(TAG,joinPoint.getSourceLocation().getFileName());
        // 34
//        Log.d(TAG, String.valueOf(joinPoint.getSourceLocation().getLine()));



        // execution(void com.zff.aspectjdemo.MainActivity.textClick())
//        Log.d(TAG,joinPoint.getStaticPart().toString());


        Toast.makeText((Context) joinPoint.getTarget(),joinPoint.getSignature().getName(),Toast.LENGTH_SHORT).show();

        // 不加下面这行代码会拦截掉点击事件
        joinPoint.proceed();
    }*/

    @Around("execution(@com.zff.aspectjdemo.ToastMethodName String *(..))")
    public String onToastMethodAround1(ProceedingJoinPoint joinPoint) throws Throwable {
        Log.d(TAG,"===================这是分割线====================");
        Log.d(TAG,"我是有返回值的方法");
        // execution(void com.zff.aspectjdemo.MainActivity.textClick())
//        Log.d(TAG,joinPoint.toString());


        // void com.zff.aspectjdemo.MainActivity.textClick()
//        Log.d(TAG,joinPoint.getSignature().toString());
        // textClick 方法名
//        Log.d(TAG,joinPoint.getSignature().getName());
        // com.zff.aspectjdemo.MainActivity 类名
//        Log.d(TAG,joinPoint.getSignature().getDeclaringTypeName());
        // MainActivity 简单类名
//        Log.d(TAG,joinPoint.getSignature().getDeclaringType().getSimpleName());

        // com.zff.aspectjdemo.MainActivity$2@e924fe8
//        Log.d(TAG,joinPoint.getTarget().toString());
        // com.zff.aspectjdemo.MainActivity 类全路径名
//        Log.d(TAG,joinPoint.getTarget().getClass().getName());


        // com.zff.aspectjdemo.MainActivity$2@e924fe8
//        Log.d(TAG,joinPoint.getThis().toString());
        // com.zff.aspectjdemo.MainActivity 类全路径名
//        Log.d(TAG,joinPoint.getThis().getClass().getName());



        // method-execution
//        Log.d(TAG,joinPoint.getKind());

        // // MainActivity.java:34
//        Log.d(TAG,joinPoint.getSourceLocation().toString());
        // class com.zff.aspectjdemo.MainActivity
//        Log.d(TAG,joinPoint.getSourceLocation().getWithinType().toString());
        // MainActivity.java
//        Log.d(TAG,joinPoint.getSourceLocation().getFileName());
        // 34
//        Log.d(TAG, String.valueOf(joinPoint.getSourceLocation().getLine()));



        // execution(void com.zff.aspectjdemo.MainActivity.textClick())
//        Log.d(TAG,joinPoint.getStaticPart().toString());


        Toast.makeText((Context) joinPoint.getTarget(),joinPoint.getSignature().getName(),Toast.LENGTH_SHORT).show();
        // 获取返回值类型
//        Log.d(TAG,joinPoint.proceed().getClass().getName());
        // 这是返回值
        Log.d(TAG,joinPoint.proceed().toString());
        return "ahfkj";

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

// 也就是说target指代的是切入点方法的所有者，而this指代的是被织入代码所属类的实例对象。

// 1、为所有点击事件埋点
// @Aspect
// public class MethodAspect5 {
//     @Pointcut("execution(* android.view.View.OnClickListener+.onClick(..))")
//     public void callMethod() {
//     }
//
//     @Before("callMethod()")
//     public void beforeMethodCall(JoinPoint joinPoint) {
//        Log.e(TAG, "埋点");
//     }
// }
// android.view.View.OnClickListener+表示OnClickListener及其子类。


/*
    AspectJ现存的问题
            重复织入、不织入
            假如我们想对Activity生命周期织入埋点统计，我们可能写出这样的切点代码。
    @Pointcut("execution(* android.app.Activity+.on*(..))")
    public void callMethod() {}
            复制代码由于Activity.class不参与打包（android.jar位于android设备内），参与打包是那些支持库比如support-v7中的AppCompatActivity，还有项目里定义的Activity，这就导致：

            如果我们业务Activity中如果没有复写生命周期方法将不会织入。
            如果我们的Activity继承树上如果都复写了生命周期方法，那么继承树上的所有Activity都会织入统计代码，这会导致重复统计。

            解决办法是项目内定义一个基类Activity（比如BaseActivity），然后复写所有生命周期方法，然后将切点代码精确到这个BaseActivity。
    @Pointcut("execution(* com.xxx.BaseActivity.on*(..))")
    public void callMethod() {}
*/



