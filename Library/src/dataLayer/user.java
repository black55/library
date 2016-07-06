package dataLayer;
import java.sql.*;

public class user {
	
	public static boolean isUserExist(String tableName, String userName)
	{
		boolean returnValue = false;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet res = null;
		try
		{
			conn = dataLayer.getConnection.get();
			
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
	
	public static boolean addNewUser()
	{  
		return true;
	}
	
	
}
