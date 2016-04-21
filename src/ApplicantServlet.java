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

		
		long roleid=(long) session.getAttribute("roleid");
		String rolename = (String) session.getAttribute("rolename");
		String username = (String) session.getAttribute("username");
	long applicantid=Long.parseLong(request.getParameter("applicantid"));
	


		DBConnect Applicant = new DBConnect();
		System.out.println("Check1");


		

		List<HrApplicant> candidate= Applicant.getApplicantDetails(applicantid).getResultList();
		System.out.println("Check2");
		{
	

			session.setAttribute("candidate", candidate);
			session.setAttribute("roleid", roleid);
			session.setAttribute("rolename", rolename);
			session.setAttribute("username", username);
			session.setAttribute("applicantid", applicantid);
			request.getRequestDispatcher("/DisplayForm.jsp").forward(request, response);

		}



	}

}
