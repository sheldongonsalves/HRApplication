

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.DBConnect;
import model.HrInterviewtable;

@WebServlet("/PreInterview")
public class PreInterview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PreInterview() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		DBConnect dbc=null;
		HrInterviewtable hrit=null;

		long applicantId = (long)session.getAttribute("applicantid");
		hrit = dbc.getInterviewList(applicantId).getSingleResult();
		long roleId = (long)session.getAttribute("roleid");
		
		//if HR employee's roles are HR Manager, Hiring Manager, or Group interview
		if (roleId == 1 || roleId == 6 || roleId == 7)
		{
			session.setAttribute("interviewtable", hrit);
			request.getRequestDispatcher("/Interview.jsp").forward(request, response);
		}
		
	}

}
