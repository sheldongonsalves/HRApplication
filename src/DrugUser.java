

import java.io.IOException;

import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.DBConnect;
import model.HrApplicant;


@WebServlet("/DrugUser")
public class DrugUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public DrugUser() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	HttpSession session= request.getSession() ;
	
	long applicantid= (long) session.getAttribute("applicantid");
		
		DBConnect d= new DBConnect();
		
		String test1=(String) request.getAttribute("test1");
		String test2=(String) request.getAttribute("test2");
		String test3=(String) request.getAttribute("test3");
		
		//For when this method is created
	//	d.InsertDrugTest(test1,test2,test3); 
		
		//Call method getApplicantDetails to display druguser and return dispatcher to DisplayForm
	
		
		TypedQuery<HrApplicant> r = null;
		
		r = d.getApplicantDetails(applicantid);

		request.setAttribute("applicantDrug", r);
			
		request.getRequestDispatcher("/DisplayForm.jsp").forward(request, response);
	}

}
