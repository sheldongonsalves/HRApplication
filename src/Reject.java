

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
		DBLogin dbl= new DBLogin();
		HrInterviewtable hrit=new HrInterviewtable();

		long applicantId = (long)session.getAttribute("applicantid");
		String interviewschedule ="No";
		String status="";
		System.out.println("Applicant ID:" + applicantId);

		dbl.insertNewInterviewTable(applicantId,interviewschedule,status);

		session.setAttribute("interviewtable", hrit);

		request.getRequestDispatcher("/DisplayForm.jsp").forward(request, response);

	}

}
