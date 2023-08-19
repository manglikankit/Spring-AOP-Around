package com.manglik.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudAsynAspect {
    @Before("com.manglik.aopdemo.aspect.LuvAOPExpression.forDaoPackageNoGetterSetter()")
    public void logToCloud(){
        System.out.println("\n =====> Executing @Before advice logToCloud on method");
    }
}

