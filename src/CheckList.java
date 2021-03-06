

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
import model.HrInterviewtable;


@WebServlet("/CheckList")
public class CheckList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CheckList() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session= request.getSession() ;
		
		DBConnect d= new DBConnect();
		String rolename = (String) session.getAttribute("rolename");
		String username = (String) session.getAttribute("username");
		
		long applicantid = (long) session.getAttribute("applicantid");
		
		
		
		d.getInterviewList(applicantid);
		
		d.getApplicantDetails(applicantid); 
		
		
		//Call method getApplicantDetails to display education and return dispatcher to DisplayForm
		
		List<HrInterviewtable> interviewtable= d.getInterviewList(applicantid).getResultList();

		request.setAttribute("interviewtable", interviewtable);
		
	
		List<HrApplicant> candidate= d.getApplicantDetails(applicantid).getResultList();

		request.setAttribute("candidate", candidate);
		session.setAttribute("applicantid", applicantid);
		session.setAttribute("rolename", rolename);
		session.setAttribute("username", username);
		request.getRequestDispatcher("/CheckList.jsp").forward(request, response);
	}

}
