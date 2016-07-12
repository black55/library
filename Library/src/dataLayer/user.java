package dataLayer;
import java.sql.*;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.RandomStringUtils;

public class user {
	
	public static boolean isUserExist(String tableName, String userName)
	{
		boolean returnValue = false;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet res = null;
		try
		{
			conn = getConnection.get();
			
			if(tableName.equals("user"))
				stmt = conn.prepareStatement("select  from user where username = ?");
			else if(tableName.equals("tempuser"))
				stmt = conn.prepareStatement("select  from tempuser where username = ?");
			
			stmt.setString(1, tableName);
			stmt.setString(2, userName);
			res = stmt.executeQuery();
			if(res.next())
			{
				returnValue = true;
			}
		}
		catch(SQLException e)
		{
		}
		finally
		{
			exceptionHandler.sqlSafeClose.closeAll(conn,stmt,res);
		}
		
		return returnValue;
	}
	
	public static boolean addNewUser(HttpServletRequest userInfo)
	{  
		boolean returnValue = false;
		Connection conn = null;
		PreparedStatement stmt = null;
		try
		{
			conn = getConnection.get();
			stmt = conn.prepareStatement("insert into tempuser (username, password, email, rollid, mobile, testkey) values (?,?,?,?,?,?)");
			stmt.setString(1, userInfo.getParameter("username"));
			stmt.setString(2, userInfo.getParameter("password"));
			stmt.setString(3, userInfo.getParameter("email"));
			stmt.setString(4, userInfo.getParameter("roll"));
			stmt.setString(5, userInfo.getParameter("country").toString().concat(userInfo.getParameter("mobile")));
			stmt.setString(6, RandomStringUtils.randomAlphanumeric(15));
			stmt.executeUpdate();
			returnValue = true;
		}
		catch(SQLException e)
		{
		}
		finally
		{
			exceptionHandler.sqlSafeClose.closeAll(conn,stmt,null);
		}
		return returnValue;
	}
	
	
}
