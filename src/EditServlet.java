

import java.io.IOException;
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


@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public EditServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		long roleid=(long) session.getAttribute("roleid");
		long applicantid = (long) session.getAttribute("applicantid");
		
		DBConnect EditApplicant = new DBConnect();
		List<HrApplicant> editList = null;
		
		String name = request.getParameter("Name");
		
		String address = request.getParameter("Address");
		
		
		String jobhistory = request.getParameter("Jobhistory");
		String reference = request.getParameter("Reference");
		String veteranstatus = request.getParameter("Veteranstatus");
		System.out.println(name + address + jobhistory + reference + veteranstatus);
		EditApplicant.UpdateApplicant(name, address, jobhistory, reference, veteranstatus, applicantid);// change this
		editList = EditApplicant.getApplicantList().getResultList(); // change this
		session.setAttribute("roleid", roleid);
		session.setAttribute("applicantlist", editList);
		request.getRequestDispatcher("ApplicantList.jsp").forward(request, response);
		
	}

}
