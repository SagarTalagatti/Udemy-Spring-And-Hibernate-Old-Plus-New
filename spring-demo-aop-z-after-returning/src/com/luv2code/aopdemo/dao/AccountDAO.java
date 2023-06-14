package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	//add a new method: findAccounts()
	
	public List<Account> findAccounts(){
		List<Account> myAccounts=new ArrayList<>();
		
		//create sample accounts
		Account a1=new Account("John","Silver");
		Account a2=new Account("Madhu","Platinum");
		Account a3=new Account("Luca","Gold");
		
		//add them to the list
		myAccounts.addAll(Arrays.asList(a1,a2,a3));
		
		return myAccounts;
	}
	
	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.println(getClass()+": DOING MY DB WORK : ADDING AN ACCOUNT");
	}
	
	public boolean doWork() {
		
		System.out.println(getClass()+": doWork()");
		return false;
	}

	public String getName() {
		System.out.println(getClass()+": getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass()+": setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass()+": getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass()+": setServiceCode()");
		this.serviceCode = serviceCode;
	}
	
}
