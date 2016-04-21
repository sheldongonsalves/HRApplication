
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
import javax.servlet.http.HttpSession;import customTools.DBConnect;import model.HrApplicant;
import model.HrInterviewtable;@WebServlet("/ApplicantServlet")
public class ApplicantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;    public ApplicantServlet() {
		super();

	}    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{        
		doPost(request, response);
	}    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{       
		HttpSession session = request.getSession();        
		session.getAttribute("user");       
		//    session.getAttribute("Applicantid");     
		//long applicant_id=2;
		long roleid=(long) session.getAttribute("roleid");
		String rolename = (String) session.getAttribute("rolename");
		String username = (String) session.getAttribute("username");
		long applicantid=Long.parseLong(request.getParameter("applicantid"));
		//    long roleid=(long) session.getAttribute("roleid");     
		DBConnect Applicant = new DBConnect();
		System.out.println("Check1");        //    long applicant_id = 0;      
		List<HrApplicant> candidate= Applicant.getApplicantDetails(applicantid).getResultList();

	//	List<HrInterviewtable> rejectedrecord =Applicant.getApplicantInterviewDetails(applicantid).getResultList();
		System.out.println("Check2");
		{
			//    HrApplicant u =candidate.get((int) session.getAttribute("Applicantid"));
			//gets 1st user out of list as resultlist contains one user
			//    session.setAttribute("candidatesession", u);     
			session.setAttribute("candidate", candidate);
			session.setAttribute("roleid", roleid);
			session.setAttribute("rolename", rolename);
			session.setAttribute("username", username);
			session.setAttribute("applicantid", applicantid);
			
	/*		if(!rejectedrecord.isEmpty())
			{
				if(rejectedrecord.get(0).getHrinterviewresult().equalsIgnoreCase("Fail")||candidate.get(0).getDrugtestresult().equalsIgnoreCase("Fail")||rejectedrecord.get(0).getHminterviewresult().equalsIgnoreCase("Fail")||rejectedrecord.get(0).getGroupinterviewresult().equalsIgnoreCase("Fail")||rejectedrecord.get(0).getCodingtestresult().equalsIgnoreCase("Fail"))
				{
					request.setAttribute("rejectmessage", "Applicant Rejected!!!");
				}
				else if(rejectedrecord.get(0).getHrinterviewresult()==null||rejectedrecord.get(0).getHminterviewresult()==null||rejectedrecord.get(0).getGroupinterviewresult()==null||rejectedrecord.get(0).getCodingtestresult()==null)
				{
					request.setAttribute("rejectmessage", "Interview process pending!!!");
				}

			}
*/

			request.getRequestDispatcher("/DisplayForm.jsp").forward(request, response);      
		}   
	}
}