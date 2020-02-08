package Product;

public class ProductBean {
	
	private String name;
	private String prid;
	private String price;
	private String soldby;
	private String cat;
	private java.sql.Timestamp start_date=null;
	private java.sql.Timestamp  last_date=null;
	private String desc;
	private int shipping_cost_local;
	private int shipping_cost_other;
	
	
	
	public void setname(String name )
	{
		this.name=name;
	}
	public String getname()
	{
		return name;
	}
	
	public void setprid(String prid )
	{
		this.prid=prid;
	}
	public String getprid()
	{
		return prid;
	
	}
	
	public void setprice(String price )
	{
		this.price=price;
	}
	public String getprice()
	{
		return price;
	
	}
	
	public void setsoldby(String soldby )
	{
		this.soldby=soldby;
	}
	public String getsoldby()
	{
		return soldby;
	
	}
	
	public void setcat(String cat )
	{
		this.cat=cat;
	}
	public String getcat()
	{
		return cat;
	
	}
	
	public void setStart_date(java.sql.Timestamp sdate )
	{
		start_date=sdate;
	}
	public java.sql.Timestamp getStart_date()
	{
		return start_date;
	
	}
	
	public void setLast_date(java.sql.Timestamp ldate )
	{
		last_date=ldate;
	}
	public java.sql.Timestamp getLast_date()
	{
		return last_date;
	
	}
	
	public void setdesc(String desc )
	{
		this.desc=desc;
	}
	public String getdesc()
	{
		return desc;
	
	}
	public void setshipping_cost_local(int shipping_cost_local )
	{
		this.shipping_cost_local=shipping_cost_local;
	}
	public int getshipping_cost_local()
	{
		return shipping_cost_local;
	
	}
	public void setshipping_cost_other(int shipping_cost_other)
	{
		this.shipping_cost_other=shipping_cost_other;
	}
	public int getshipping_cost_other()
	{
		return shipping_cost_other;
	
	}
	

}
