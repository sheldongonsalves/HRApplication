

import java.io.IOException;
import java.util.List;

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

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HrInterviewtable interviewTable = new HrInterviewtable();
		HttpSession session = request.getSession();
		String rolename = (String) session.getAttribute("rolename");
		String username = (String) session.getAttribute("username");
		DBLogin dbl=new DBLogin();
		DBConnect dbc=new DBConnect();
		HrInterviewtable hrit= new HrInterviewtable();

		HrLogin user = (HrLogin)session.getAttribute("user");			
		long  roleid = (long)session.getAttribute("roleid");

		//getting input from Interview page
		//Interview status: pass/fail
		String interviewStatus = request.getParameter("status");
		System.out.println("...................................."+interviewStatus);
		//Coding test: taken or not
		String codingTest = request.getParameter("test");
		//Coding test if taken: pass/fail
		String codingTestStatus = request.getParameter("teststatus");
		long applicantId = (long) session.getAttribute("applicantid");

		List<HrInterviewtable> CandidateRecord =dbc.getInterviewList(applicantId).getResultList();

		//assume only these 3 roles can make it here
		if(roleid == 1) //human resource manager
		{
			//update interview table for HR manager here
			//dbl.insertNewInterviewTable(applicantId, "Yes", interviewStatus);
			dbc.updateHrResult(applicantId, interviewStatus);

		}
		if(roleid == 6)	//hiring manager and coding test
		{
			//update interview table for Hiring Manager here
			//dbc.updateScheduleHiringManagerInterview(applicantId);
			dbc.updateHMInterviewResult(applicantId, interviewStatus);
			/*if(!CandidateRecord.get(0).getCodingtest().equalsIgnoreCase("taken")||CandidateRecord.get(0).getCodingtest()==null) 
			{*/
				dbc.updateCodingTestTaken(applicantId, codingTest);
				dbc.updateCodingTestResult(applicantId, codingTestStatus);
			//}
		}
		if(roleid == 7) //if(user.getHrRole().getRolename().equalsIgnoreCase("Group Interview Manager"))
		{
			//update interview table for group interview here
			dbc.updateGroupInterviewResult(applicantId, interviewStatus);
			/*if(!CandidateRecord.get(0).getCodingtest().equalsIgnoreCase("taken")||CandidateRecord.get(0).getCodingtest()==null) 
			{*/
				dbc.updateCodingTestTaken(applicantId, codingTest);
				dbc.updateCodingTestResult(applicantId, codingTestStatus);
			//}
		}
		session.setAttribute("rolename", rolename);
		session.setAttribute("username", username);
		request.getRequestDispatcher("/ApplicantList.jsp").forward(request, response);

	}

}
