package Admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import p1.UloginBean;
import p1.UserLogin;

/**
 * Servlet implementation class Alogin
 */
@WebServlet("/Alogin")
public class Alogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Alogin() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String email= request.getParameter("email");
		String Password= request.getParameter("pwd");
		AdminLoginBean al = new AdminLoginBean();
		al.setEmail(email);
		al.setpassword(Password);
		System.out.println(al.getemail());
		AdminloginClass alc = new AdminloginClass(al);
		String s = alc.aLogin();
			
		if(s=="SUCCESS")
		{
			HttpSession hs= request.getSession();
			hs.setAttribute("object", al);
			response.sendRedirect("Ahome.jsp");
		}
		else
		{
			out.println(s);
			response.sendRedirect("AdminLogin.jsp");
		}
		
		
		
		
		
	}

}
