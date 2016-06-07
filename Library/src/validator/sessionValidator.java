package validator;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class sessionValidator {

	public static void sessionValidity(HttpServletRequest req, HttpServletResponse res)
	{
		HttpSession session = req.getSession(false);
		if(session == null)
		{
			try
			{
				RequestDispatcher dispatcher = req.getRequestDispatcher("html/login");
				dispatcher.forward(req, res);
			}
			catch(IOException | ServletException e)
			{}
		}
	}
}
