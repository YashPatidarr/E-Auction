package Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import p1.DBConn;
import p1.UloginBean;

public class AdminloginClass {

	private String email;
	private String pwd;
	
	public AdminloginClass(AdminLoginBean al)
	{
		email= al.getemail();
		pwd = al.getpassword();
	}
	public String aLogin()
	{
		Connection con = null;
		PreparedStatement preparedStatement = null;
		try
		{
		con = DBConn.createConnection();
		String query = "select * from admin where email=? and pwd=?";
		preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
		preparedStatement.setString(2, pwd);
		preparedStatement.setString(1, email);
		ResultSet rs = preparedStatement.executeQuery();
		
		if (rs.next())  //Just to ensure data has been inserted into the database
		return "SUCCESS"; 
		}
		catch(SQLException e)
		{
		e.printStackTrace();
		}
		
		return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
		}
	
}
