package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get bean from container
		AccountDAO theAccountDAO=ctx.getBean("accountDAO",AccountDAO.class);
		
		//call the method to find accounts
		List<Account> accounts=null;
		
		try {
			//add a boolean flag to simulate an exception
			boolean tripWire=false;
			accounts=theAccountDAO.findAccounts(tripWire);
		}
		catch(Exception exc) {
			System.out.println("\n\nMain program... caught exception: "+exc);
		}
		//display the accounts
		System.out.println("\n\nMain program: AfterFinallyDemoApp");
		System.out.println("----");
		
		System.out.println(accounts);
		
		System.out.println("\n");
		
		//close the context
		ctx.close();

	}

}
