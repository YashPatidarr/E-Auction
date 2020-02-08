package Vendor;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Product.ProductBean;
import p1.DBConn;


@WebServlet("/AuctProductServletVendor")
public class AuctProductServletVendor extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<ProductBean> st = new ArrayList<ProductBean>();

		HttpSession hs = request.getSession();
		VloginBean vs = (VloginBean) hs.getAttribute("object");
		String vendoremail = vs.getemail();
		
		long millies=System.currentTimeMillis();
		java.sql.Date current_date = new java.sql.Date(millies);
		
		PreparedStatement preparedStatement = null;
		try {
			Connection con = DBConn.createConnection();
			String query = "select * from product where ldate < ? and sold_by=?";
			System.out.println("Check-1");
//preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setDate(1, current_date);
			preparedStatement.setString(2, vendoremail);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				do {
					System.out.println("Check-3");
					String name = rs.getString("name");
					String price = rs.getString("price");
					String cat = rs.getString("cat");
					String prid = rs.getString("prid");
					String soldby = rs.getString("sold_by");
					ProductBean pb = new ProductBean();
					pb.setname(name);
					pb.setprice(price);
					System.out.println("Check-4");
					pb.setprid(prid);
					pb.setcat(cat);
					pb.setsoldby(soldby);

					st.add(pb);
					System.out.println(pb.getname());
				} while (rs.next());
			}

			else {
				System.out.println("no records found");
			}
			con.close();
			request.setAttribute("ProductList", st);
			request.getRequestDispatcher("AuctShowprouser.jsp").forward(request, response);
			
			
		} catch (Exception e) {
			System.out.println(e);
		}

		
		
	}

}
