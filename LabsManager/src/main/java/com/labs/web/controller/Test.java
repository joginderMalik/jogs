package com.labs.web.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Test {

	public static void main(String[] args) {
		SimpleDateFormat parseFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
        Date date;
		try {
			date = parseFormat.parse(new Date().toString());
			 SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		        String formatedDate = format.format(date);
		        System.out.println("formatedDate: "+ formatedDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
		
	}
}
