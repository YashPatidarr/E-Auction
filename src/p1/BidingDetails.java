package p1;

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

import Product.BidBean;

/**
 * Servlet implementation class BidingDetails
 */
@WebServlet("/BidingDetails")
public class BidingDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request,response);	
	}
	
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String useremail=null;
		
		HttpSession  hs = request.getSession();
		UloginBean ul = (UloginBean)hs.getAttribute("object");
		useremail = ul.getemail();
		
		ArrayList<BidBean> st = new ArrayList<BidBean>();

		

		PreparedStatement preparedStatement = null;
		try {
			Connection con = DBConn.createConnection();
			String query = "select * from bid where userid=? order by date desc";
//preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, useremail);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				do {

					BidBean bb = new BidBean();
					
					bb.setprid(rs.getString("prid"));
					bb.setprice(rs.getString("bidamt"));
					bb.setdate(rs.getString("date"));
				

					st.add(bb);
					
					
				} while (rs.next());
			}

			else {
				System.out.println("no records found");
			}
			con.close();
			request.setAttribute("ProductList", st);
			request.getRequestDispatcher("BidingDetails.jsp").forward(request, response);
			
			
		} catch (Exception e) {
			System.out.println(e);
		}

		
		
	}

}
