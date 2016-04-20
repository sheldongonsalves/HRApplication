

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.DBConnect;
import customTools.DBLogin;
import model.HrInterviewtable;

@WebServlet("/Reject")
public class Reject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Reject() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String rolename = (String) session.getAttribute("rolename");
		String username = (String) session.getAttribute("username");
		DBLogin dbl= new DBLogin();
		HrInterviewtable hrit=new HrInterviewtable();
		String reject = request.getParameter("reject");
		long applicantId = (long)session.getAttribute("applicantid");
		String interviewschedule ="No";
		String status="";
		System.out.println("Applicant ID:" + applicantId);

		//insert or update a interviewTable row with schedule and status
		dbl.insertNewInterviewTable(applicantId,interviewschedule,status);

		//session.setAttribute("interviewtable", hrit);
		session.setAttribute("reject", reject);
		session.setAttribute("rolename", rolename);
		session.setAttribute("username", username);
		request.getRequestDispatcher("/Reject.jsp").forward(request, response);

	}

}
