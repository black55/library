package userManagement;

import java.io.*;
import java.sql.*;
import java.util.HashMap;

import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.commons.lang3.RandomStringUtils;

import dataLayer.user;

public class signup extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		doPost(req,res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		if(req.getParameterMap().isEmpty())
		{
			RequestDispatcher dispatch = req.getRequestDispatcher("/jsp/signup.jsp");
			dispatch.forward(req, res);
		}
		else
		{
			String username = req.getParameter("username");
			
			if(user.isUserExist("user", username))
			{
				PrintWriter writer = res.getWriter();
				writer.write("user exist");
			}
			else if(user.isUserExist("tempuser", username))
			{
				PrintWriter writer = res.getWriter();
				writer.write("user already registered ... please verify email ...");
			}
			else if(user.addNewUser(req))
			{
				PrintWriter writer = res.getWriter();
				writer.write("user inserted");
			}
			else
			{
				PrintWriter writer = res.getWriter();
				writer.write("user insertion failed ... please try again ..");
			}
		}
	}
}
