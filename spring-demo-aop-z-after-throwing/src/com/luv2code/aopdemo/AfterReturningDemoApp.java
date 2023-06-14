package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get bean from container
		AccountDAO theAccountDAO=ctx.getBean("accountDAO",AccountDAO.class);
		
		//call the method to find accounts
		List<Account> accounts=theAccountDAO.findAccounts(false);
		
		//display the accounts
		System.out.println("\n\nMain program: AfterReturningDemoApp");
		System.out.println("----");
		
		System.out.println(accounts);
		
		System.out.println("\n");
		
		//close the context
		ctx.close();

	}

}
