package schedule2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.io.IOException;




import Admin.Default_Values;
import p1.DBConn;

public class DailyCode {

	
	public static void checkBidTimeLimit()
	{
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
				{	do
					{
							java.sql.Date info_date = rs4.getDate("informed_time"); //Date taken from the bid table
							
							//System.out.println(info_date);
							// System.out.println(info_time);
							
							java.util.Calendar c = Calendar.getInstance(); //Created Calendar Object
							
							c.setTime(info_date); //that calendar object now refers to the info date..
													//means now c contains the date taken from bid table
							
							//Now d contains the days which user is permitted the time
							
							c.add(Calendar.DAY_OF_MONTH, d); //this adds d days in the date
							
							//now c contains the date upto which user is allowed to claim the product
							//now for comparision c is converted into java.sql.Date format
							
							java.sql.Date limit_date = new java.sql.Date(c.getTimeInMillis());
						//	System.out.println(limit_date);
		
							if (limit_date.before(current_date)) //Comparision
								{
		
											System.out.println("Opportunity to buy for user " + rs4.getString("userid")
													+ " is Gone ..and informing the next higher bidder");
					
// TASK 1
											String query9 = " update bid set Owned='False' where prid=? and userid=?";
											preparedStatement = con.prepareStatement(query9);
											preparedStatement.setString(1, rs4.getString("prid"));
											preparedStatement.setString(2, rs4.getString("userid"));
											int n = preparedStatement.executeUpdate();
											if (n != 0) {
												System.out.println("Status in Bid Table for Owned is set False");
											} else {
												System.out.println("Status in Bid Table for Owned is NOT set False");
											}
// TASK 2
					
											String query10 = " update auctioned_product set status='False' where prid=?";
											preparedStatement = con.prepareStatement(query10);
											preparedStatement.setString(1, rs4.getString("prid"));
											int o = preparedStatement.executeUpdate();
											if (o != 0) {
												System.out.println("Status in auctioned_product Table  is set False");
											} else {
												System.out.println("Status in auctioned_product Table  is NOT set False");
											}

							} else {
								System.out.println("Still we have to wait  for user " + rs4.getString("userid") + " to buy");
							}
						} while (rs4.next());

				}
				else {
				System.out.println("No work to do");
				}
				
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	System.out.println("checkBidTimeLimit() is completed");
	}
	
	
	public static void auctionCompleted()
	{
			try {
						Connection con = DBConn.createConnection();
						PreparedStatement preparedStatement;
						String query = "insert into auctioned_product(name,prid,cat,price,sold_by,sdate,ldate) select name,prid,cat,price,sold_by,sdate,ldate from product where ldate < CURDATE()";
						preparedStatement = con.prepareStatement(query);
						int i = preparedStatement.executeUpdate();
						if (i != 0) 
							{
									System.out.println("Total " + i + " Rows Are added from Product table to Auctioned Table");
									String query2 = "Delete from product where ldate < Curdate()";
									preparedStatement = con.prepareStatement(query2);
									int j = preparedStatement.executeUpdate();
									if (j != 0) {
										System.out.println("Total " + j + " Rows Are Deleted from Product table");
									} else {				
										System.out.println("No Records Deleted in Product Table");
									}
							} 
						else {
			
							System.out.println("No Records Entered in Auction Table");
			
				}
			} catch (Exception e) {
				System.out.println(e);
			}
	
			/*
			 * All the entries from the Product table whose last Date of Auction is ended is
			 * moved from "product" table to "auctioned_product" table and those records are
			 * deleted from main product table
			 */
	}
	
	public static void work()
	{
		int topbiders= Default_Values.topbiders;
		int biders=0;
		
		try {
			Connection con = DBConn.createConnection();
			PreparedStatement preparedStatement;
			String query="select * from auctioned_product where status='False'";
			preparedStatement = con.prepareStatement(query);
			ResultSet rs =preparedStatement.executeQuery();
			if(rs.next())
			{	
			do {
					Connection con1 = DBConn.createConnection();
					PreparedStatement preparedStatement1;
					String prid=rs.getString("prid");
					String query2="select * from bid where prid=? and Owned!='False' order by bidamt desc";
					preparedStatement1 = con1.prepareStatement(query2);
					preparedStatement1.setString(1, prid);
					ResultSet rs2 = preparedStatement1.executeQuery();
					if(rs2.next())
					{
						do {
							biders++;
						
							if(biders<=topbiders)
							{
								
								String  str= "False";
								String Owned= rs2.getString("Owned");
							
//Block1-----------------------------------------------------------------------------------------------------------------------
								if(!(Owned.equals(str)))
								{
									Connection con2 = null;
									try {
										con2 = DBConn.createConnection();
										PreparedStatement preparedStatement2;
										String query3 = "insert into user_product(name,prid,user_id,cat,price,sold_by,sdate,ldate,descrip,shipping_cost_local,shipping_cost_other)values(?,?,?,?,?,?,?,?,?,?,?)";
										preparedStatement2 = con2.prepareStatement(query3);
										System.out.println("Check4");
										preparedStatement2.setString(1, rs.getString(1));
										preparedStatement2.setString(2, rs.getString(2));
										preparedStatement2.setString(3, rs2.getString("userid"));
										preparedStatement2.setString(4, rs.getString(3));
										preparedStatement2.setString(5, rs.getString(4));
										preparedStatement2.setString(6, rs.getString(5));
										preparedStatement2.setString(7, rs.getString(6));
										preparedStatement2.setString(8, rs.getString(7));
										preparedStatement2.setString(9, rs.getString(8));
										preparedStatement2.setString(10, rs.getString(9));
										preparedStatement2.setString(11, rs.getString(10));
										int j = preparedStatement2.executeUpdate();
										if (j != 0) {
											System.out.println("Details for " + prid + " is forwaded to user "
													+ rs2.getString("userid"));
	
										} else {
	
											System.out.println("Error Occured");
	
										}
									} catch (Exception e) {
										System.out.println(e);
									}
									
									con2.close();
									
										
//Block 2	--------------------------------------------------------------------------------------------------------------
										//Updating status in Auctioned table
										
										Connection con3=null;
										try {
										con3= DBConn.createConnection();
										PreparedStatement preparedStatement3;
										String query4= "update auctioned_product set status='True' where prid=?";
										preparedStatement3 = con3.prepareStatement(query4);
										preparedStatement3.setString(1, prid);
										int k= preparedStatement3.executeUpdate();
										if(k!=0)
										{
											System.out.println("Status in Auctioned Table is set TRUE");
										}
										else {
											System.out.println("Status in Auctioned Table is NOT set TRUE");
										}
										}catch (Exception e) {
											System.out.println(e);
										}
										con3.close();
					
//Block3-------------------------------------------------------------------------------------------------------------------
										
										Connection con4 = null;
										try {
											con4 = DBConn.createConnection();
											PreparedStatement preparedStatement3;
											String query5 = "update bid set informed_time=sysdate(),Mail_sent='True' where prid=? and userid=?";
											preparedStatement3 = con4.prepareStatement(query5);
											preparedStatement3.setString(1, prid);
											preparedStatement3.setString(2, rs2.getString("userid"));
											int l = preparedStatement3.executeUpdate();
											if (l != 0) {
												System.out
														.println("Informed time and Mail Sent is updated in bid table for prid "
																+ prid + " FOR USER ID " + rs2.getString("userid"));
											} else {
												System.out.println("Informed time and Mail Sent is NOT updated in bid table ");
											}
										} catch (Exception e) {
											System.out.println(e);
										}
										con4.close();
														
						
										break;
								}
							}else {
								System.out.println("Maximum bider check limit reached");
								break;
							}
						}while(rs2.next());		//Iteration of every bid table record corresponding to every auctioned_product record
					}
					
//Block4------------------------------------------------------------------------------------------------------------------------------------------
					//When no bid for the product is found in the Bidding Table....
					else
					{
									Connection con5=null;
									try {
									con5 = DBConn.createConnection();
									PreparedStatement preparedStatement3;
									String query6= "insert into unauc_pro(name,prid,cat,price,sold_by,sdate,ldate,descrip,shipping_cost_local,shipping_cost_other) select name,prid,cat,price,sold_by,sdate,ldate,descrip,shipping_cost_local,shipping_cost_other from auctioned_product where prid=?";
									preparedStatement3 = con5.prepareStatement(query6);
									preparedStatement3.setString(1, prid);
									
									int l= preparedStatement3.executeUpdate();
									if(l!=0)
									{
										System.out.println("No bid is found for the prid= "+prid+" therfore it is added in the table of unauctioned table");
										String query7 = "Delete from auctioned_product where prid=?";
										preparedStatement3 = con.prepareStatement(query7);
										preparedStatement3.setString(1, prid);
										int m = preparedStatement3.executeUpdate();
										if (m != 0) {
											System.out.println("product with prid= " + prid + " is Deleted from auctioned table");
										} else {

											System.out.println("error deleting product in Auctioned product table");

										}

										
									}
					
									else {
										System.out.println("error adding product in unauctioned product table ");
									}
									}catch (Exception e) {
										System.out.println(e);
									}
									con5.close();
						
					}	
					
			}while(rs.next());		//Iteration of every auctioned_product table record
		}
	}
	catch(Exception e) 
	{
		System.out.println(e);
	}
		
	}
	
}
