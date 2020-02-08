package Schedule;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import p1.DBConn;

@WebServlet("/Autocode")
public class Autocode1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Connection con = DBConn.createConnection();
			PreparedStatement preparedStatement;
			String query = "insert into auctioned_product(name,prid,cat,price,sold_by,sdate,ldate) select name,prid,cat,price,sold_by,sdate,ldate from product where ldate < CURDATE()";
			preparedStatement = con.prepareStatement(query);
			int i = preparedStatement.executeUpdate();
			if (i != 0) {
				System.out.println("Total " + i + " Rows Are added from Product table to Auctioned Table");
				String query2 = "Delete from product where ldate < Curdate()";
				preparedStatement = con.prepareStatement(query2);
				int j = preparedStatement.executeUpdate();
				if (j != 0) {
					System.out.println("Total " + j + " Rows Are Deleted from Product table");
				} else {

					System.out.println("No Records Deleted in Product Table");

				}

			} else {

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

}
