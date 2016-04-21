

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.DBConnect;
import model.HrApplicant;


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

long applicantid= (long) session.getAttribute("applicantid");
String rolename = (String) session.getAttribute("rolename");
String username = (String) session.getAttribute("username");

		
		DBConnect d= new DBConnect();
		
		String citizenship=(String) request.getParameter("citizenship");
		
		System.out.println("Your status is "+citizenship);
	
		d.updateCitizenship(applicantid,citizenship); 
		
		//Call method getApplicantDetails to display citizenship and return dispatcher to DisplayForm
	

		List<HrApplicant> applicantUpdate= d.getApplicantDetails(applicantid).getResultList();

		request.setAttribute("applicantUpdate", applicantUpdate);
		session.setAttribute("applicantid", applicantid);
		session.setAttribute("rolename", rolename);
		session.setAttribute("username", username);
	
			
		request.getRequestDispatcher("/DisplayForm.jsp").forward(request, response);
	}

}
