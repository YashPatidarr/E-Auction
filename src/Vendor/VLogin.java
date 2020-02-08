package Vendor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import p1.UloginBean;
import p1.UserLogin;

/**
 * Servlet implementation class VLogin
 */
@WebServlet("/VLogin")
public class VLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email= request.getParameter("email");
		String Password= request.getParameter("pwd");
		VloginBean vl = new VloginBean();
		vl.setEmail(email);
		vl.setpassword(Password);
		
		VendorLogin vs = new VendorLogin(vl);
		String s = vs.Vlogin();
			
		if(s=="SUCCESS")
		{
			HttpSession hs= request.getSession();
			hs.setAttribute("object", vl);
			response.sendRedirect("Vhome.jsp");
		}
		else
		{
			
			response.sendRedirect("VendorLogin.jsp");
		}
		
	}

}
