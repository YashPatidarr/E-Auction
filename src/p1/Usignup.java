package p1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Usignup
 */
@WebServlet("/Usignup")
public class Usignup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Usignup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	doGet(request, response);
		PrintWriter out=response.getWriter();
		 String Name = request.getParameter("nm");
		 String email = request.getParameter("email");
		 String city = request.getParameter("city");
		 String password = request.getParameter("pwd");
		 String num = request.getParameter("num");
		 String gen = request.getParameter("gen");
		 
		 System.out.println("check");
		 RegisBean rb = new RegisBean();
		 rb.setName(Name);
		 rb.setemail(email);
		 rb.setcity(city);
		 rb.setpassword(password);
		 rb.setnum(num);
		 rb.setgen(gen);
		 
		 Registration rg = new Registration(rb);
		 String s =rg.registeruser();
		 if(s=="SUCCESS")
			{
				response.sendRedirect("Ulogin.jsp");
			}
			else
			{
				
				response.sendRedirect("UReg.jsp");
			}
		
	}

}
