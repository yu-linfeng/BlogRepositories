package com.manager.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 日志切面
 * Created by Kevin on 2017/10/29.
 */
@Aspect
@Component
public class LogAspect {
    /**
     * 操作日志文件名
     */
    private static final String OPERATION_LOG_NAME = "operationLog";
    private static final String LOG_FORMATTER = "%s.%s - %s";
    Logger log = Logger.getLogger(OPERATION_LOG_NAME);
    /**
     * 对查询方法记录日志的切点
     */
    @Pointcut("execution(* com.manager..*.*Controller.query*(..))")
    public void query(){}

    /**
     * 对新增方法记录日志的切点
     */
    @Pointcut("execution(* com.manager..*.*Controller.add*(..))")
    public void add(){}

    /**
     * 对修改方法记录日志的切点
     */
    @Pointcut("execution(* com.manager..*.*Controller.update*(..))")
    public void update(){}

    /**
     * 对删除方法记录日志的切点
     */
    @Pointcut("execution(* com.manager..*.*Controller.delete*(..))")
    public void delete(){}

    @AfterReturning(value = "query()", returning = "rvt")
    public void queryLog(JoinPoint joinPoint, Object rvt) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        String returnResult = rvt.toString();
        log.info(String.format(LOG_FORMATTER, className, methodName, returnResult));
    }

    @Before("add()")
    public void addLog(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] params = joinPoint.getArgs();
        log.info(String.format(LOG_FORMATTER, className, methodName, Arrays.toString(params)));
    }

    @Before("update()")
    public void updateLog(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] params = joinPoint.getArgs();
        log.info(String.format(LOG_FORMATTER, className, methodName, Arrays.toString(params)));
    }

    @Before("delete()")
    public void deleteLog(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] params = joinPoint.getArgs();
        log.info(String.format(LOG_FORMATTER, className, methodName, Arrays.toString(params)));
    }
}
