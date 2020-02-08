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

/**
 * Servlet implementation class Showproducts
 */
@WebServlet("/Showproducts")
public class Showproducts extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<ProductBean> st = new ArrayList<ProductBean>();

		HttpSession hs = request.getSession();

		PreparedStatement preparedStatement = null;
		try {
			Connection con = DBConn.createConnection();
			String query = "select * from product";
//preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
			preparedStatement = con.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			int i = 0;
			if (rs.next()) {
				do {

					String name = rs.getString("name");
					String price = rs.getString("price");
					String cat = rs.getString("cat");
					String prid = rs.getString("prid");
					String soldby = rs.getString("sold_by");
					ProductBean pb = new ProductBean();
					pb.setname(name);
					pb.setprice(price);

					pb.setprid(prid);
					pb.setcat(cat);
					pb.setsoldby(soldby);

					st.add(pb);
					ProductBean pb1 = st.get(i);
					System.out.println(pb1.getname());
					i++;
					
				} while (rs.next());
			}

			else {
				System.out.println("no records found");
			}
			con.close();
			request.setAttribute("ProductList", st);
			request.getRequestDispatcher("Showprouser.jsp").forward(request, response);
			
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}