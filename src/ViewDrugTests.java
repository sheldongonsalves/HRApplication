

import java.io.IOException;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.DBConnect;
import model.HrApplicant;
import model.HrDrugtest;


@WebServlet("/ViewDrugTests")
public class ViewDrugTests extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ViewDrugTests() {
        super();
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session= request.getSession() ;
		String rolename = (String) session.getAttribute("rolename");
		String username = (String) session.getAttribute("username");
		long applicantid= (long) session.getAttribute("applicantid");
		long roleid = (long) session.getAttribute("roleid");
			
		
		
			DBConnect d= new DBConnect();

			
		   d.getApplicantDrugDetails(applicantid); 
			
			

			List<HrDrugtest> viewTests= d.getApplicantDrugDetails(applicantid).getResultList();

		
			System.out.println("---------------------"+viewTests.get(0).getAlcoholtest());
			
			
			request.setAttribute("viewTests", viewTests);
			
			session.setAttribute("roleid", roleid);
			session.setAttribute("rolename", rolename);
			session.setAttribute("username", username);
			session.setAttribute("applicantid", applicantid);
				
			request.getRequestDispatcher("/DisplayForm.jsp").forward(request, response);
	}

}
