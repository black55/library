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
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		try
		{
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			conn = dataLayer.getConnection.get();
			stmt = conn.prepareStatement("select username from user where username = ? and password = md5(?)");
			stmt.setString(1,username);
			stmt.setString(2, password);
			resultSet = stmt.executeQuery();
			if(resultSet.next())
			{
				System.out.println("Success");
			}
			else
			{
				System.out.println("failed");	
			}
		}
		catch( Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			exceptionHandler.sqlSafeClose.closeAll(conn, stmt, resultSet);
		}
	}
	
}
