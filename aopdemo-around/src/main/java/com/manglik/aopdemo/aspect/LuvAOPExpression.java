package com.manglik.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAOPExpression {
    @Pointcut("execution(* add*(com.manglik.aopdemo.Account, ..))")
    public void forDaoPackage(){}
    @Pointcut("execution(* com.manglik.aopdemo.dao.*.get*(..))")
    public void getter(){}

    @Pointcut("execution(* com.manglik.aopdemo.dao.*.set*(..))")
    public void setter(){}
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter(){}
}
