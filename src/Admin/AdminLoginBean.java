package Admin;

public class AdminLoginBean {

	
	private String email;
	private String pwd;
	
	public void setEmail( String email)
	{
		this.email= email;
		
	}
	public String getemail()
	{
		return email;
	}
	
	public void setpassword( String pwd)
	{
		this.pwd= pwd;
		
	}
	public String getpassword()
	{
		return pwd;
	}
}
