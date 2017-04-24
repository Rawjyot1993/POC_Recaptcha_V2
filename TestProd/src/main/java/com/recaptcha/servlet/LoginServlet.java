package main.java.com.recaptcha.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet
{
	
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
	{

					String user = request.getParameter("user");
					String pwd = request.getParameter("pwd");

					String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
					System.out.println(gRecaptchaResponse);
					
					boolean verify = VerifyRecaptcha.verify(gRecaptchaResponse);

					String userID = "Rawjyot";
					String password = "qwerty";

					System.out.println("User=" + user + "::password=" + pwd + "::Captcha Verify"+verify);

					  if (userID.equals(user) && password.equals(pwd) && verify)
					  {
					      response.sendRedirect("LoginSuccess.jsp");
					  } 
					  
					  else
						  
					  {
						  RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
						  PrintWriter out = response.getWriter();
						  
						   if (verify) 
						   {
						     out.println("<font color=red>Either user name or password is wrong.</font>");
						   }
						   
						   else
						   {
						     out.println("<font color=red>You missed the Captcha.</font>");
						   }
						   
					rd.include(request, response);
					
				     }
		}

}
