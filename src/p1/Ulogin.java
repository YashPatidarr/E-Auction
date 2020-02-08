package p1;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Ulogin")

public class Ulogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Ulogin() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String email= request.getParameter("email");
		String Password= request.getParameter("pwd");
		UloginBean ul = new UloginBean();
		ul.setEmail(email);
		ul.setpassword(Password);
		
		UserLogin us = new UserLogin(ul);
		String s = us.Ulogin();
			
		if(s=="SUCCESS")
		{
			HttpSession hs= request.getSession();
			hs.setAttribute("object", ul);
			response.sendRedirect("Uhome.jsp");
		}
		else
		{
			
			response.sendRedirect("Ulogin.jsp");
		}
		
		
		
		
		
	}

}
