package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get bean from container
		AccountDAO theAccountDAO=ctx.getBean("accountDAO",AccountDAO.class);
		
		Account myAccount=new Account();
		//call business method
		theAccountDAO.addAccount(myAccount,true);
		
		theAccountDAO.doWork();
		
		//call getter/setter methods on accountDao
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");
		
		String name=theAccountDAO.getName();
		String serviceCode=theAccountDAO.getServiceCode();
		
		//call business method again
		//theAccountDAO.addAccount();
		
		//get the membershipDAO bean
		MembershipDAO theMembershipDAO=ctx.getBean("membershipDAO",MembershipDAO.class);
		
		//call the method on this object
		theMembershipDAO.addSillyMember();
		
		theMembershipDAO.goToSleep();
		
		//close the context
		ctx.close();

	}

}
