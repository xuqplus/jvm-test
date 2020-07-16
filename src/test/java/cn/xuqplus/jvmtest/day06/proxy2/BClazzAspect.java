package cn.xuqplus.jvmtest.day06.proxy2;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Slf4j
@Aspect
@Service
public class BClazzAspect {

    @Pointcut("execution(* cn.xuqplus.jvmtest.day06.proxy2.BClazz.*(..))")
    public void joinPoint() {
    }

    @Before("execution(* cn.xuqplus.jvmtest.day06.proxy2.BClazz.*(..))")
    public void before() {
        log.info("{}", Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @After("joinPoint()")
    public void After() {
        log.info("{}", Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @AfterReturning("joinPoint()")
    public void AfterReturning() {
        log.info("{}", Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @AfterThrowing("joinPoint()")
    public void AfterThrowing() {
        log.info("{}", Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Around("joinPoint()")
    public void Around(ProceedingJoinPoint point) throws Throwable {
        log.info(">> {}", Thread.currentThread().getStackTrace()[1].getMethodName());
        point.proceed();
        log.info("<< {}", Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
