

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.DBConnect;


@WebServlet("/Citizenship")
public class Citizenship extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public Citizenship() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 doPost(request,response);
	 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
HttpSession session= request.getSession() ;
		
		DBConnect d= new DBConnect();
		
		String citizenship=(String) request.getAttribute("citizenship");
	
		//For when this method is created
	//	d.InsertCitizenship(citizenship); 
		
		//Call method getApplicantDetails to display citizenship and return dispatcher to DisplayForm
	}

}
