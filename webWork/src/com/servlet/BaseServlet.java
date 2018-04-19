package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet{ 

	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) {
		String method = request.getParameter("method");		
		try {
			Method m = this.getClass().getMethod(method,HttpServletRequest.class,HttpServletResponse.class);
			m.invoke(this.getClass().newInstance(),request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void out_write(HttpServletResponse response, String tips)
			throws IOException {
		PrintWriter writer = response.getWriter();
		writer.write("{\"tips\":\""+tips+"\"}");
	}
	
}
