package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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

	//add new advice for @AfterReturning on findAccounts method
	@AfterReturning(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account>result) {
		
		String method=theJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> Executing @AfterReturning on method: "+method);
		
		//print out the results of the method call
		System.out.println("\n=====>>> Result of method call is: "+result);
		
		//lets post-process the data. modify it before it makes it back to caller
		//convert all account names to upper case
		System.out.println("\n=====>>> Result of method call being modified with forEach method on List");
		result.forEach((x)->{x.setName(x.getName().toUpperCase());});
//		converAccountNamesToUpperCase(result);
		
		System.out.println("\n=====>>> Result of method call after modification is: "+result);
	}
	
//	private void converAccountNamesToUpperCase(List<Account> result) {
//		for(Account acct:result) {
//			acct.setName(acct.getName().toUpperCase());
//		}
//		
//	}

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
