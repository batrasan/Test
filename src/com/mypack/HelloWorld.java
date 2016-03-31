package com.mypack;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorld extends HttpServlet {

	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException
	{
		
		System.out.println("you are in HelloHelloWorld servlet by sanjay new changes");
			

	}

}
