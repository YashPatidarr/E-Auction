package Vendor;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Admin.AdminLoginBean;
import p1.DBConn;

/**
 * Servlet implementation class VendorReg
 */
@WebServlet("/VendorReg")
public class VendorReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VendorReg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession  hs = request.getSession();
		AdminLoginBean al = (AdminLoginBean)hs.getAttribute("object");
		String adminemail = al.getemail();
		
		PrintWriter out=response.getWriter();
		 String Name = request.getParameter("nm");
		 String email1 = request.getParameter("email");
		 String city = request.getParameter("city");
		 String password = request.getParameter("pwd");
		 String num = request.getParameter("num");
		 String gen = request.getParameter("gen");
		 String slnm = request.getParameter("slnm");
		
		 try
			{
			 Connection con  = DBConn.createConnection();
			 PreparedStatement preparedStatement ;
			String query = "insert into vendor(email,name,pwd,seller_name,city,num,gen,added_by) values (?,?,?,?,?,?,?,?)"; //Insert user details into the table 'USERS'
			preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
			preparedStatement.setString(2, Name);
			preparedStatement.setString(1, email1);
			preparedStatement.setString(5, city);
			preparedStatement.setString(4, slnm);
			preparedStatement.setString(6, num);
			preparedStatement.setString(7, gen);
			preparedStatement.setString(3, password);
			preparedStatement.setString(8, adminemail);
			int i= preparedStatement.executeUpdate();
			if(i!=0)
			{
				out.println("Vendor added");
			}
			else
			{
				
				out.println("Vendor not added");
			}
			}
		 	catch(Exception e)
		 {
		 		out.println(e);
		 }

}
}
