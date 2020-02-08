package Schedule;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Random r =new Random();
		System.out.println(r.nextDouble());
		String sdate="2019-07-26T09:10";
		long millies=System.currentTimeMillis();
		
//		System.out.println(current_date);
//		String sdate2[] =sdate1.split("T");
//		java.sql.Date current_date = new java.sql.Date(millies);
//		java.sql.Time time= new Time(millies);
//		time=java.sql.Time.valueOf(sdate2[1]+":00");
//		System.out.println(sdate2[1]);
//		String timee = sdate2[1]+":00";
		
		sdate=sdate.replace("T", " ");
		sdate=sdate+":00";
		System.out.println(sdate);
//		java.util.Date date=null;
//		DateFormat d=null;
//		 
//		
//		try {
//		
//			date = new SimpleDateFormat("YYYY-MM-DD HH:MM:SS").parse(sdate);
//			
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		System.out.println(date);
//		
		java.sql.Timestamp sdate11 =null;
		sdate11=sdate11.valueOf(sdate);
		System.out.println(sdate11);
		
		
		
		
		
		
		
		
		
		
//		System.out.println(Date.valueOf(sdate2[0]));
//		System.out.println(Time.valueOf(timee));
		
//		java.util.Date date =null;
//		date.parse(sdate2[0]);
//		date.
//		date.setTime(Time.valueOf(timee).getTime());
//		
//		System.out.println(date);
	/*	java.sql.Timestamp date = new Timestamp(millies);
		
		DateTimeDateFormat d = new DateTimeDateFormat();
		DateFormat d1 = new SimpleDateFormat();
		try {
			d1.parse(source)
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(date);*/
		

	}

}
