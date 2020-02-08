package Product;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import p1.DBConn;
import p1.UloginBean;


@WebServlet("/Bid")
public class Bid extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
			
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		String bid = request.getParameter("bidamt");
		int bidamt = Integer.parseInt(bid);
		String prid= request.getParameter("prid");
		
		String base= request.getParameter("base_price");
		int base_price = Integer.parseInt(base);
		HttpSession  hs = request.getSession();
		UloginBean ul = (UloginBean)hs.getAttribute("object");
		String useremail = ul.getemail();
		
		long millies=System.currentTimeMillis();
		java.sql.Date current_date = new java.sql.Date(millies);
		if(bidamt>=base_price)
		{
		PreparedStatement preparedStatement= null; ;
		Connection con=null;
		 try
			{
			 con  = DBConn.createConnection();
			 String query11= "select * from bid where userid=?";
			 preparedStatement = con.prepareStatement(query11);
			 preparedStatement.setString(1, useremail);
			 ResultSet rs = preparedStatement.executeQuery();
			 int count=0;
			 if(rs.next())
			 {
				 do {
				 String prid1=rs.getString("prid");
				 java.sql.Date Date1 = rs.getDate("date");
				
				 if(prid1.compareTo(prid)==0)
				 {	
					 String query1= "update bid set bidamt=? , date=? where prid=? and userid=?";
						preparedStatement = con.prepareStatement(query1);
						preparedStatement.setString(3, prid);
						preparedStatement.setInt(1, bidamt);
						preparedStatement.setString(4, useremail);
						preparedStatement.setDate(2, current_date);
						int j= preparedStatement.executeUpdate();
						if(j!=0)
						{
							con.close();
							request.getRequestDispatcher("/BidingDetails").forward(request, response);
						}
						else {
							out.println("ERROR ");
						}
				 
				 }
				if((Date1.getDate()==current_date.getDate())&&(Date1.getMonth()==current_date.getMonth()))
				 {
				 count++;
				 }
				 
				 
				 }while(rs.next())	; 
			 }
			 System.out.println(count);
			 if(count<3)
			 {
			 
			String query = "insert into bid(prid,userid,bidamt,date) values (?,?,?,?)"; //Insert user details into the table 'USERS'
			preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
			preparedStatement.setString(1, prid);
			preparedStatement.setInt(3, bidamt);
			preparedStatement.setDate(4, current_date);
			preparedStatement.setString(2, useremail);
			int i= preparedStatement.executeUpdate();
			if(i!=0)
			{
				con.close();
				request.getRequestDispatcher("/BidingDetails").forward(request, response);
			}
			
			}
			 else
				{
					con.close();
//					out.println("Cannot Bid More than 3 Items");
					
//					request.getRequestDispatcher("/BidingDetails").forward(request, response);
					out.println("Cannot Bid More than 3 Items");
					RequestDispatcher rd=request.getRequestDispatcher("/BidingDetails");
					out.println("Cannot Bid More than 3 Items");
					rd.include(request, response);
					out.println("Cannot Bid More than 3 Items");
				}
			}
		 	catch(Exception e)
		 {
		 		e.printStackTrace();
		 		out.println(e);
		 }
		}
		out.println("You can only submit Bid more than the Base Price");
		RequestDispatcher rd=request.getRequestDispatcher("/BidingDetails");
				
	}

}
