package Vendor;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.RandomAccess;

import javax.mail.search.SentDateTerm;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.helpers.DateTimeDateFormat;

import p1.DBConn;

@WebServlet("/AddProduct")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession hs = request.getSession();
		VloginBean vl = (VloginBean) hs.getAttribute("object");
		String email = vl.getemail();
		PrintWriter out = response.getWriter();
		String Name = request.getParameter("nm");

		String cat = request.getParameter("cat");
		String price1 = request.getParameter("price");

		int price = Integer.parseInt(price1);
		String sdate = request.getParameter("sdate");
		String ldate = request.getParameter("ldate");
		String desc = request.getParameter("desc");
		String lcost = request.getParameter("lcost");
		String ocost = request.getParameter("ocost");
		int local_cost = Integer.parseInt(lcost);
		int other_cost = Integer.parseInt(ocost);

		
		sdate=sdate.replace("T", " ");
		sdate=sdate+":00";
		ldate=ldate.replace("T", " ");
		ldate=ldate+":00";
		java.sql.Timestamp sdate1 = null;
		java.sql.Timestamp ldate1 = null;
		sdate1= sdate1.valueOf(sdate);
		ldate1= ldate1.valueOf(ldate);
		
//		System.out.println(ldate1);
		
		Random r = new Random();

		String prid = email.substring(2, 6) + Name.substring(0, 3) + r.nextInt() ;
		if (prid.length() > 19)
			prid = prid.substring(0, 19);
		System.out.println(prid);
		

		try {
			Connection con = DBConn.createConnection();
			PreparedStatement preparedStatement;
			String query = "insert into product(name,prid,cat,price,sold_by,sdate,ldate,descrip,shipping_cost_local,shipping_cost_other) values (?,?,?,?,?,?,?,?,?,?)"; // Insert
																																										// user
																																										// details
																																										// into
																																										// the
																																										// table
																																										// 'USERS'
			preparedStatement = con.prepareStatement(query); // Making use of prepared statements here to insert bunch
																// of data
			preparedStatement.setString(1, Name);
			preparedStatement.setString(3, cat);
			preparedStatement.setInt(4, price);
			preparedStatement.setString(2, prid);
			preparedStatement.setString(5, email);
			preparedStatement.setTimestamp(6,sdate1);
			preparedStatement.setTimestamp(7, ldate1);
			preparedStatement.setString(8, desc);
			preparedStatement.setInt(9, local_cost);
			preparedStatement.setInt(10, other_cost);

			int i = preparedStatement.executeUpdate();
			if (i != 0) {
				out.println("Product added");
				request.setAttribute("pid", prid);
				request.getRequestDispatcher("/Uploadmage.jsp").forward(request,response);
			} else {

				out.println("Product Not added");

				request.getRequestDispatcher("/vhome.jsp").forward(request,response);
			}
			
			con.close();
		} catch (Exception e) {
			out.println(e);
		}

	}
}
