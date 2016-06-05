package userManagement;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class login extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		doGetANDdoPost(req,res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		doGetANDdoPost(req,res);		
	}
	
	protected void doGetANDdoPost(HttpServletRequest req, HttpServletResponse res)
	{
		Connection conn = null;
		try
		{
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			conn = dataLayer.getConnection.get();
			
			conn.close();
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		finally
		{
			exceptionHandler.sqlSafeClose.closeConnection(conn);
		}
	}
	
}
