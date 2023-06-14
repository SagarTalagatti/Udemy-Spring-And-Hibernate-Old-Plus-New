package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController{
	
	//controller method to show form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	//controller method to process form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}

	//new controller method to read form data and add data to the model
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request,Model model) {

		//read request param from HTML form
		String msg=request.getParameter("studentName");
		
		//convert msg to uppercase
		msg=msg.toUpperCase();
		
		//create the reply message
		String result="Yo! "+msg;
		
		//add result to model
		model.addAttribute("message",result);
		
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String msg,Model model) {

		//read request param from HTML form
		//String msg=request.getParameter("studentName");
		
		//convert msg to uppercase
		msg=msg.toUpperCase();
		
		//create the reply message
		String result="Hey my friend from v3! "+msg;
		
		//add result to model
		model.addAttribute("message",result);
		
		return "helloworld";
	}
}
