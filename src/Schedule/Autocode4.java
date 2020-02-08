package Schedule;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/Autocode4")
public class Autocode4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
//
//	public void init(ServletConfig config) throws ServletException {
//
//		System.out.println("AutoStartup");
//		String args[] = null;
//		MyApp.main(args);
//		System.out.println("AutoStartup2");
//
//	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("AutoStartup");
		
		
		
		System.out.println("AutoStartup2");
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	
	

}
