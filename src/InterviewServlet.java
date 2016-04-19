

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
import model.HrLogin;


@WebServlet("/Interview")
public class InterviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public InterviewServlet() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HrInterviewtable interviewTable = new HrInterviewtable();
		HttpSession session = request.getSession();
		DBLogin dbl=null;
		DBConnect dbc=null;
		HrInterviewtable hrit=null;

		HrLogin user;

		if(request.getParameter("status").equals("pass")==true)
		{
			user = (HrLogin)session.getAttribute("user");

			//getting input from Interview page
			//Interview status: pass/fail
			String interviewStatus = request.getParameter("status");
			//Coding test: taken or not
			String codingTest = request.getParameter("test");
			//Coding test if taken: pass/fail
			String codingTestStatus = request.getParameter("teststatus");
			long applicantId = (long) session.getAttribute("Applicantid");


			//assume only these 3 roles can make it here
			if(user.getHrRole().getRolename().equalsIgnoreCase("HR Manager"))
			{
				//insert interview table for HR manager here
				dbl.insertNewInterviewTable(applicantId, "Yes", interviewStatus);
			}
			else if(user.getHrRole().getRolename().equalsIgnoreCase("Hiring Manager"))
			{
				//update interview table for Hiring Manager here
				dbc.updateScheduleHiringManagerInterview(applicantId);
				dbc.updateHMInterviewResult(applicantId, interviewStatus);
				dbc.updateCodingTestTaken(applicantId, codingTest);
				dbc.updateCodingTestResult(applicantId, codingTestStatus);
			}
			else //if(user.getHrRole().getRolename().equalsIgnoreCase("Group Interview Manager"))
			{
				//update interview table for group interview here
				dbc.updateScheduleGroupInterview(applicantId);
				dbc.updateGroupInterviewResult(applicantId, interviewStatus);
				dbc.updateCodingTestTaken(applicantId, codingTest);
				dbc.updateCodingTestResult(applicantId, codingTestStatus);
			}
			
			//retrieve the newly inserted or updated interview table
			hrit = dbc.getInterviewList(applicantId).getSingleResult();
			session.setAttribute("interviewtable", hrit);
			request.getRequestDispatcher("/CheckList.jsp").forward(request, response);
		}

	}

}
