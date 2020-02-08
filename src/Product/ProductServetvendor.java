package Product;

import java.io.IOException;
import java.io.PrintWriter;
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

import Vendor.VloginBean;
import p1.DBConn;

@WebServlet("/ProductServletVendor")
public class ProductServetvendor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession hs = request.getSession();
		VloginBean vs = (VloginBean) hs.getAttribute("object");
		String email = vs.getemail();

		ArrayList<ProductBean> st = new ArrayList<ProductBean>();

		PreparedStatement preparedStatement = null;
		try {

			Connection con = DBConn.createConnection();
			String query = "select * from product where sold_by=?";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, email);

//preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data

			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				do {

					String name = rs.getString("name");
					String price = rs.getString("price");
					String cat = rs.getString("cat");
					String prid = rs.getString("prid");

					ProductBean pb = new ProductBean();
					pb.setname(name);
					pb.setprice(price);

					pb.setprid(prid);
					pb.setcat(cat);

					st.add(pb);

				} while (rs.next());
			}

			else {

				PrintWriter out = response.getWriter();
				out.println("no records found");
				request.getRequestDispatcher("ShowProductsadmin.jsp").forward(request, response);
			}
			con.close();

			request.setAttribute("ProductListVendor", st);
			request.getRequestDispatcher("Showproduct.jsp").forward(request, response);

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}