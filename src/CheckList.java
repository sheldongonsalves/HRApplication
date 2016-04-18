

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.DBConnect;
import model.HrApplicant;
import model.HrInterviewtable;


@WebServlet("/CheckList")
public class CheckList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CheckList() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session= request.getSession() ;
		
		//long applicantid= (long) session.getAttribute("applicantid");
			
			long applicantid=2;
		
			DBConnect d= new DBConnect();
			
			d.getInterviewList(applicantid); 
			
		
			List<HrInterviewtable> checklist= d.getInterviewList(applicantid).getResultList();

			request.setAttribute("checklist", checklist);
			
		
				
			request.getRequestDispatcher("/CheckList.jsp").forward(request, response);
	}

}
