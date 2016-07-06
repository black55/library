package userManagement;

import java.io.*;
import java.sql.*;

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
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			String username = req.getParameter("username");
			String email = req.getParameter("email");
			String roll = req.getParameter("roll");
			String country = req.getParameter("country");
			String mobile = req.getParameter("mobile");
			String pass = req.getParameter("password");
			try
			{
				
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
				else
				{
					exceptionHandler.sqlSafeClose.closeAll(null,stmt,rs);
					stmt = conn.prepareStatement("insert into tempuser (username, password, email, rollid, mobile, testkey) values (?,?,?,?,?,?)");
					stmt.setString(1, username);
					stmt.setString(2, pass);
					stmt.setString(3, email);
					stmt.setString(4, roll);
					stmt.setString(5, country.toString().concat(mobile));
					String testkey = RandomStringUtils.randomAlphanumeric(15);
					stmt.setString(6,testkey);
					stmt.executeUpdate();
					PrintWriter writer = res.getWriter();
					writer.write("user inserted");
				}
			}
			catch(SQLException e)
			{			
				System.out.println(e);
			}
			finally
			{
				exceptionHandler.sqlSafeClose.closeAll(conn,stmt,rs);
			}
		}
	}
}
