

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.DBConnect;
import model.HrApplicant;



@WebServlet("/NewApplicantServlet")
public class NewApplicantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public NewApplicantServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		HttpSession session = request.getSession();
		long roleid=(long) session.getAttribute("roleid");
		String rolename = (String) session.getAttribute("rolename");
		String username = (String) session.getAttribute("username");
		DBConnect NewApplicant = new DBConnect();
		List<HrApplicant> appList = null;
		
		String name = request.getParameter("Name");
		String address = request.getParameter("Address");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");   
		java.util.Date birthdate = null;
		try {
			birthdate = (java.util.Date) formatter.parse(request.getParameter("Birthdate"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//String birthdate = request.getParameter("Birthdate");
		String education = request.getParameter("Education");
		String jobhistory = request.getParameter("Jobhistory");
		String reference = request.getParameter("Reference");
		String veteranstatus = request.getParameter("Veteranstatus");
		
		NewApplicant.insertNewApplicant(name, address, birthdate, education, jobhistory, reference, veteranstatus );
		appList = NewApplicant.getApplicantList().getResultList();
		session.setAttribute("roleid", roleid);
		session.setAttribute("rolename", rolename);
		session.setAttribute("username", username);
		session.setAttribute("applicantlist", appList);
		request.getRequestDispatcher("ApplicantList.jsp").forward(request, response);
		
 		
	}

}
