package dataLayer;

import java.sql.*;
import javax.naming.*;
import javax.sql.DataSource;
public class getConnection {
	static DataSource pool;
	
	static
	{
		try
		{
			pool = (DataSource)(new InitialContext()).lookup("java:/comp/env/mysql/library");
		}
		catch(NamingException e)
		{
		}
	}
	
	
	
	public static Connection get() throws SQLException
	{
		Connection conn = null;
		try
		{
			if(pool == null)
				throw new SQLException("Data pool creation failed ...");
			conn = pool.getConnection();
		}
		catch(SQLException e)
		{
		}
		return conn;
	}

}
