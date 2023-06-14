package com.luv2code.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		try {
			//create object mapper
			ObjectMapper mapper=new ObjectMapper();
			
			//read JSON file and convert to POJO
			//Student theStudent=mapper.readValue(new File("data/sample-lite.json"), Student.class);
			Student theStudent=mapper.readValue(new File("data/sample-full.json"), Student.class);
			
			//print student object
			System.out.println(theStudent);
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
