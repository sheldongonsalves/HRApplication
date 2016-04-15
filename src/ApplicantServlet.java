/*yash*/

import java.io.IOException;
import java.util.Date;
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


@WebServlet("/ApplicantServlet")
public class ApplicantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ApplicantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
HttpSession session = request.getSession();
		


	//	session.getAttribute("Applicantid");
      long applicant_id=1;
      

		DBConnect Applicant = new DBConnect();
		System.out.println("Check1");
		

	//	long applicant_id = 0;

		List<HrApplicant> candidate= Applicant.getApplicantDetails(applicant_id).getResultList();
		System.out.println("Check2");
		{
		//	HrApplicant u =candidate.get((int) session.getAttribute("Applicantid"));//gets 1st user out of list as resultlist contains one user
		//	session.setAttribute("candidatesession", u);
			
			String name = candidate.get(0).getApplicantname();
			
			System.out.println("Name is:" + name);
			String address = candidate.get(0).getAddress();
			Date birthdate = candidate.get(0).getBirthdate(); 
			String education = candidate.get(0).getEducation();
			String jobhistory = candidate.get(0).getJobhistory();
			String reference = candidate.get(0).getJobreference();
			String veteran = candidate.get(0).getVeteranstatus();
			String drugtest = candidate.get(0).getDrugtestresult();
			String citizenship = candidate.get(0).getCitizenstatus();
			
			request.setAttribute("name", name);
			request.setAttribute("address", address);
			request.setAttribute("birthdate", birthdate);
			request.setAttribute("education", education);
			request.setAttribute("jobhistory", jobhistory);
			request.setAttribute("reference", reference);
			request.setAttribute("veteran", veteran);
			request.setAttribute("drugtest", drugtest);
			request.setAttribute("citizenship", citizenship);
			
			request.getRequestDispatcher("/DisplayForm.jsp").forward(request, response);
					}
		
		
		
		
	}

}
