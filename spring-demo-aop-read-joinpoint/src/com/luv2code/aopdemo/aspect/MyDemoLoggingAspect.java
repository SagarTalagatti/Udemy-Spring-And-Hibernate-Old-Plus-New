package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	// this is where we add all of our related advices for logging
		
	// lets start with an @Before advice
	//@Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
//	@Before("forDaoPackage()")
	@Before("com.luv2code.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		
		System.out.println("\n====>>> Executing @Before advice on method");
		
		//display the method signature
		MethodSignature methodSig=(MethodSignature)theJoinPoint.getSignature();
		System.out.println("Method: "+methodSig);
		
		//display method arguments
		//get method args
		Object[] args=theJoinPoint.getArgs();
		
		//loop through args and print
		for(Object arg:args) {
			System.out.println(arg);
			if(arg instanceof Account) {
				//downcast and print Account specific stuff
				Account acct=(Account)arg;
				
				System.out.println("account name: "+acct.getName());
				System.out.println("account level: "+acct.getLevel());
			}
		}
	}
	
}
