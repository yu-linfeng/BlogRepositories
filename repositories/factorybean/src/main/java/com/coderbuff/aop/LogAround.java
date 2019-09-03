package com.coderbuff.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author cdyulinfeng
 * @date 2019/9/3
 **/
public class LogAround implements MethodInterceptor {
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("调用目标方法【前】打印日志");
        Object result = invocation.proceed();
        System.out.println("调用目标方法【后】打印日志");
        return result;
    }
}
