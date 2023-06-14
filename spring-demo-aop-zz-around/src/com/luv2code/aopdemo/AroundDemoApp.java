package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get bean from container
		TrafficFortuneService theFortuneService=ctx.getBean("trafficFortuneService",TrafficFortuneService.class);

		System.out.println("\nMain program: AroundDemoApp");
		
		System.out.println("Calling getFortune");
		
		String fortune=theFortuneService.getFortune();
		
		System.out.println("\nMy fortune is: "+fortune);
		
		System.out.println("Finished");
		
		//close the context
		ctx.close();

	}

}
