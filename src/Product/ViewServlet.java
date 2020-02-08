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

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String prid=request.getParameter("prid");
		PreparedStatement preparedStatement = null;
		Connection con= null;
		try {
			
			 con = DBConn.createConnection();
			String query = "select * from product where prid='"+prid+"'";

			ProductBean pb = new ProductBean();
			preparedStatement = con.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()){
				
					pb.setname(rs.getString("name"));
					pb.setprice(rs.getString("price"));
					pb.setprid(rs.getString("prid"));
					pb.setcat(rs.getString("cat"));
					pb.setsoldby(rs.getString("sold_by"));
					pb.setStart_date(rs.getTimestamp("sdate"));
					pb.setLast_date(rs.getTimestamp("ldate"));
					pb.setdesc(rs.getString("descrip"));
					pb.setshipping_cost_local(Integer.parseInt(rs.getString("shipping_cost_local")));
					pb.setshipping_cost_other(Integer.parseInt(rs.getString("shipping_cost_other")));
					
			}
			ArrayList<BidBean > topbid = new ArrayList<BidBean >();
			
			String querry="select * from bid where prid=? order by bidamt desc";
			preparedStatement = con.prepareStatement(querry);
			preparedStatement.setString(1, prid);
			rs = preparedStatement.executeQuery();
			int i=3;
			if(rs.next()){
				do {
					i--;
					BidBean pb2 = new BidBean();
					pb2.setprice(rs.getString("bidamt"));
					pb2.setuserid(rs.getString("userid"));
					topbid.add(pb2);
					
				} while (rs.next() && i > 0);
				
			}
			
			con.close();
			request.setAttribute("Product", pb);
			request.setAttribute("Topbids", topbid);
			request.getRequestDispatcher("viewproduct.jsp").forward(request, response);
			
			
		} catch (Exception e) {
			System.out.println(e);
		}


		
		
	}

}
