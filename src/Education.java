

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.HrApplicant;
import customTools.DBConnect;


@WebServlet("/Education")
public class Education extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Education() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session= request.getSession() ;
		
		DBConnect d= new DBConnect();
		
		
		long applicantid = (long) session.getAttribute("Applicantid");
		
		String education =request.getParameter("education");
		
		d.updateEducation(applicantid, education); 
		
		
		
		
	
		
		
	}

}
