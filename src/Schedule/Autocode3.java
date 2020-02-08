package Schedule;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Admin.Default_Values;
import p1.DBConn;

@WebServlet("/Autocode3")
public class Autocode3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int d = Default_Values.days;
		long millies=System.currentTimeMillis();
		java.sql.Date current_date = new java.sql.Date(millies);

		try {
			Connection con = DBConn.createConnection();
			PreparedStatement preparedStatement;
			String query8="Select * from bid where Mail_sent='True' and Owned !='False'";
			preparedStatement= con.prepareStatement(query8);
			ResultSet rs4 = preparedStatement.executeQuery();
			if(rs4.next())
			{	do {
				java.sql.Date info_date = rs4.getDate("informed_time");
//				java.sql.Time info_time = rs4.getTime("informed_time");
				System.out.println(info_date);
//				System.out.println(info_time);
				java.util.Calendar c =Calendar.getInstance();
				c.setTime(info_date);
				c.add(Calendar.DAY_OF_MONTH, d);
				java.sql.Date limit_date=new java.sql.Date( c.getTimeInMillis());
				System.out.println(limit_date);
				
				
				if(limit_date.before(current_date))
				{
//					System.out.println("Opportunity to buy for user "+rs4.getString("userid")+" is Gone ..and informing the next higher bidder");
				
//	TASK 1				
					String query9 =  " update bid set Owned='False' where prid=? and userid=?";
					preparedStatement = con.prepareStatement(query9);
					preparedStatement.setString(1, rs4.getString("prid"));
					preparedStatement.setString(2, rs4.getString("userid"));
					int n= preparedStatement.executeUpdate();
					if(n!=0)
					{
						System.out.println("Status in Bid Table for Owned is set False");
					}
					else {
						System.out.println("Status in Bid Table for Owned is NOT set False");
					}
//TASK 2
					
					String query10 =  " update auctioned_product set status='False' where prid=?";
					preparedStatement = con.prepareStatement(query10);
					preparedStatement.setString(1, rs4.getString("prid"));
					
					int o= preparedStatement.executeUpdate();
					if(o!=0)
					{
						System.out.println("Status in auctioned_product Table  is set False");
					}
					else {
						System.out.println("Status in auctioned_product Table  is NOT set False");
					}
					
					
					
					
					
					
				}
				else {
					System.out.println("Still we have to wait  for user "+rs4.getString("userid")+" to buy");
				}
			}while(rs4.next());
				
			}
			else {
			System.out.println("No work to do");
			}
			
			
			
			
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		
		
		
		
	}

}
