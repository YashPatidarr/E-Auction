package p1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Registration {
	private String Name;
	 private String email;
	 private String city;
	 private String password;
	 private String num;
	 private String gen;
	 
	 public Registration( RegisBean rb)
	 {
		 Name= rb.getName();
		 email=rb.getemail();
		 city = rb.getcity();
		 password=rb.getpassword();
		 num=rb.getnum();
		 gen=rb.getgen();
	 }
	 
		public String registeruser()
		{
			
			Connection con = null;
			PreparedStatement preparedStatement = null;
			try
			{
			con = DBConn.createConnection();
			String query = "insert into users(email,name,pwd,city,num,gen) values (?,?,?,?,?,?)"; //Insert user details into the table 'USERS'
			preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
			preparedStatement.setString(2, Name);
			preparedStatement.setString(1, email);
			preparedStatement.setString(4, city);
			preparedStatement.setString(5, num);
			preparedStatement.setString(6, gen);
			preparedStatement.setString(3, password);
			int i= preparedStatement.executeUpdate();
			if (i!=0)  //Just to ensure data has been inserted into the database
			return "SUCCESS"; 
			}
			catch(SQLException e)
			{
			e.printStackTrace();
			}
			System.out.println("check4");
			return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
			}
	
}
