

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
import model.HrApplicant;
import model.HrInterviewtable;

@WebServlet("/PreInterview")
public class PreInterview extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public PreInterview() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		DBConnect dbc= new DBConnect();
		DBLogin dbl =new DBLogin();
		HrInterviewtable hrit = new HrInterviewtable();
		HrApplicant hra = new HrApplicant();
		String hrinterviewschedule="Yes";
		long applicantid = (long)session.getAttribute("applicantid");
		long roleId = (long)session.getAttribute("roleid");
		List<HrInterviewtable> interviewresult =dbc.getApplicantInterviewDetails(applicantid).getResultList();

		System.out.println("===============applicantid is "+applicantid);
		System.out.println("===============roleid is "+roleId);


		if(roleId == 1) 
		{
			dbl.insertNewInterviewTable(applicantid, hrinterviewschedule, "");	//insert or update hrinterviewschedule
		}
		hrit = dbc.getInterviewList(applicantid).getSingleResult();
        
			if(roleId == 6)	//hiring manager and coding test
			{
				//update interview table for Hiring Manager here
				dbc.updateScheduleHiringManagerInterview(applicantid);
			}
			if (roleId == 7)
			{
				dbc.updateScheduleGroupInterview(applicantid);
			}
			//session.setAttribute("interviewtable", hrit);

			//if HR employee's roles are HR Manager, Hiring Manager, or Group interview
			if (roleId == 1 || (roleId == 6 && hrit.getHrinterviewresult().equals("Pass")) || (roleId == 7 && hrit.getHminterviewresult().equals("Pass")))
			{
				session.setAttribute("interviewresult",interviewresult);
				request.getRequestDispatcher("/Interview.jsp").forward(request, response);
			}
			else if((roleId == 6 && hrit.getHrinterviewresult().equals("Fail")) || 
					(roleId == 7 && (hrit.getHrinterviewresult().equals("Fail") || 
							hrit.getHminterviewresult().equals("Fail"))))
			{
				hra = dbc.getApplicantDetails(applicantid).getSingleResult();
				//session.setAttribute("applicantname", hra.getApplicantname());
				request.getRequestDispatcher("/Reject.jsp").forward(request, response);

			}
			
		}
	
		
}
	

