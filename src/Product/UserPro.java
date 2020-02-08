package Product;

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

import p1.DBConn;
import p1.UloginBean;


@WebServlet("/UserPro")
public class UserPro extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
String useremail=null;
		
		HttpSession  hs = request.getSession();
		UloginBean ul = (UloginBean)hs.getAttribute("object");
		useremail = ul.getemail();
		
		ArrayList<ProductBean> st = new ArrayList<ProductBean>();

		

		PreparedStatement preparedStatement = null;
		try {
			Connection con = DBConn.createConnection();
			String query = "select * from user_product where user_id=? order by ldate desc";
//preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, useremail);
			ResultSet rs = preparedStatement.executeQuery();
			
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
					pb.setStart_date(rs.getTimestamp("sdate"));
					pb.setLast_date(rs.getTimestamp("ldate"));
					pb.setdesc(rs.getString("descrip"));
					 st.add(pb);
					
					
				} while (rs.next());
			}

			else {
				System.out.println("no records found");
			}
			con.close();
			request.setAttribute("ProductList", st);
			request.getRequestDispatcher("user_Prod.jsp").forward(request, response);
			
			
		} catch (Exception e) {
			System.out.println(e);
		}

		

		
		
		
	}

}
