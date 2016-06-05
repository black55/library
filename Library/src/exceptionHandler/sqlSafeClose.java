package exceptionHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class sqlSafeClose {

	public static void closeConnection(Connection conn)
	{
		try
		{
			if(conn != null)
				conn.close();
		}
		catch(SQLException e)
		{}
	}
	
	public static void closePreparedStatement(PreparedStatement stmt)
	{
		try
		{
			if(stmt != null)
				stmt.close();
		}
		catch(SQLException e)
		{}
	}
	
	public static void closeResultSet(ResultSet res)
	{
		try
		{
			if(res != null)
				res.close();
		}
		catch(SQLException e)
		{}
	}
	
	public static void closeAll(Connection conn, PreparedStatement stmt, ResultSet res)
	{
		try
		{
			if(res != null)
				res.close();
			
			if(stmt != null)
				stmt.close();
			
			if(conn != null)
				conn.close();
		}
		catch(SQLException e)
		{}
	}
}
