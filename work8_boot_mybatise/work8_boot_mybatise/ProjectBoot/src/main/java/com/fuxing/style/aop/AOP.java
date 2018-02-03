package com.fuxing.style.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AOP {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //匹配com.fuxing.style.service.impl包类的所有方法
    @Pointcut("execution(* com.fuxing.style.controller.UserController.*(..))")
    public void userService(){ }

    @Before("userService()")
    public void doBeforeAdvice(JoinPoint joinPoint){
        logger.info("我是前置通知!!!");
    }

    @After("userService()")
    public void doAfterAdvice(JoinPoint joinPoint){
        logger.info("我是后置通知!!!");
    }

    @Around("userService())")
    public Object doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
        logger.info("环绕通知的目标方法名："+proceedingJoinPoint.getSignature().getName());
        try {
            Object obj = proceedingJoinPoint.proceed();
            return obj;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

}
