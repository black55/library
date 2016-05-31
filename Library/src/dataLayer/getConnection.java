package dataLayer;

import java.sql.*;
import javax.naming.*;
import javax.sql.DataSource;
public class getConnection {
	public static Connection get() throws SQLException
	{
		Connection conn = null;
		try
		{
			InitialContext cont  = new InitialContext();
			DataSource pool = (DataSource) cont.lookup("java:/comp/env/mysql/library");
			if(pool == null)
				throw new SQLException("Data pool creation failed ...");
			conn = pool.getConnection();
		}
		catch(NamingException e)
		{
		}
		return conn;
	}

}
