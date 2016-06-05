package exceptionHandler;
import java.sql.Connection;
import java.sql.SQLException;

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
}
