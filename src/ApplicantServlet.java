/*yash*/

import java.io.IOException;
import java.util.ArrayList;
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
		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		session.getAttribute("user");

		//	session.getAttribute("Applicantid");

		long applicant_id=2;
		long roleid=1;
	//	long applicant_id=Long.parseLong(request.getParameter("Applicantid"));
	//	long roleid=(long) session.getAttribute("roleid");


		DBConnect Applicant = new DBConnect();
		System.out.println("Check1");


		//	long applicant_id = 0;

		List<HrApplicant> candidate= Applicant.getApplicantDetails(applicant_id).getResultList();
		System.out.println("Check2");
		{
			//	HrApplicant u =candidate.get((int) session.getAttribute("Applicantid"));//gets 1st user out of list as resultlist contains one user
			//	session.setAttribute("candidatesession", u);

			session.setAttribute("candidate", candidate);
			session.setAttribute("roleid", roleid);
			session.setAttribute("applicantid", applicant_id);
			request.getRequestDispatcher("/DisplayForm.jsp").forward(request, response);

		}



	}

}
