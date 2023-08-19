package com.manglik.aopdemo.aspect;

import com.manglik.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoginAspect {

    @Around("execution(* com.manglik.aopdemo.Service.*.getFortune(..))")
    public Object arounfGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("----->Executing @Around on method "+ method);
        long begin = System.currentTimeMillis();
        Object result = null;
        try {
          result = proceedingJoinPoint.proceed();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            result = "Major accodent ur private aop is on the way";
//            throw ex;
        }
        long end = System.currentTimeMillis();
        long duration = end - begin;
        System.out.println("----> Duration "+ duration / 1000.0 +"Seconds");
        return result;
    }

    @After("execution(* com.manglik.aopdemo.dao.AccountDao.findAccounts(..))")
    public void afterFinallyFindAccountAdvice(JoinPoint theJoinPonit){
        String method = theJoinPonit.getSignature().toShortString();
        System.out.println("----->Executing @After (finally) on method "+ method);
    }

    @AfterThrowing(
            pointcut = "execution(* com.manglik.aopdemo.dao.AccountDao.findAccounts(..))",
            throwing = "theExe"
    )
    public void afterThrowingFindAccountAdvice(JoinPoint theJoinPonit, Throwable theExe){
        String method = theJoinPonit.getSignature().toShortString();
        System.out.println("----->Executing @AfterThrowing on method "+ method);
        System.out.println("Exception is "+ theExe);
    }

    @AfterReturning(
            pointcut = "execution(* com.manglik.aopdemo.dao.AccountDao.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountAdvice(JoinPoint theJoinPoint, List<Account> result){
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("----->Executing @AfterReturning on method "+ method);
        System.out.println("result is "+ result);

        convertAccountNameToUpperCase(result);
        System.out.println("result is "+ result);
    }

    private void convertAccountNameToUpperCase(List<Account> result) {
        for(Account ac: result){
            String name = ac.getName();
            ac.setName(name.toUpperCase());
        }
    }
    @Before("com.manglik.aopdemo.aspect.LuvAOPExpression.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("\n =====> Executing @Before advice on method");
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method sign "+ methodSignature);

        Object[] args = joinPoint.getArgs();
        for(Object ob: args){
            System.out.println(ob);
            if (ob instanceof Account){
                Account account = (Account) ob;
                System.out.println( account.getName());
            }
        }
     }
}


