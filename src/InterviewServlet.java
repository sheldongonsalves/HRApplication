

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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


			//assume only these 3 roles can make it here
			if(user.getHrRole().getRolename().equalsIgnoreCase("HR Manager"))
			{
				interviewTable.setHrinterviewscheduled("yes");
				interviewTable.setHrinterviewresult(interviewStatus);
				//need to insert interview table here
			}
			else if(user.getHrRole().getRolename().equalsIgnoreCase("Hiring Manager"))
			{
				interviewTable.setHminterviewscheduled("yes");
				interviewTable.setHminterviewresult(interviewStatus);
				//need to update interview table here
			}
			else if(user.getHrRole().getRolename().equalsIgnoreCase("Group Interview Manager"))
			{
				interviewTable.setGroupinterviewscheduled("yes");
				interviewTable.setGroupinterviewresult(interviewStatus);
				//need to update interview table here
			}
		}

	}

}
