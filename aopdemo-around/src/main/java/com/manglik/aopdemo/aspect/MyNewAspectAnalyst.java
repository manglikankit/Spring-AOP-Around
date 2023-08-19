package com.manglik.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyNewAspectAnalyst {
    @Before("com.manglik.aopdemo.aspect.LuvAOPExpression.forDaoPackageNoGetterSetter()")
    public void performApiAnalyst(){
        System.out.println("\n =====> Executing @Before advice Analyst on method");
    }
}
