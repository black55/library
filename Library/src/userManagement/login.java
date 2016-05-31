package userManagement;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class login extends HttpServlet {
/*	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		doGetANDdoPost(req,res);
	}*/
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		doGetANDdoPost(req,res);		
	}
	
	protected void doGetANDdoPost(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			Connection conn = dataLayer.getConnection.get();
			System.out.println("username : " + username + "\n password : " + password);
		}
		catch(SQLException e)
		{
			
		}
	}
	
}
