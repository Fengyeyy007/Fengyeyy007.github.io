package edu.tinzel.mvccompany.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CountryServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String opt=request.getParameter("opt");
		if(opt.equals("i18n")){
			this.i18n(request, response);
		}
		
	}
	
	public void i18n(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String language=request.getParameter("language");
		
		request.getSession().setAttribute("language",language);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}


}
