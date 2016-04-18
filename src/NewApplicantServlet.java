

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.DBConnect;



@WebServlet("/NewApplicantServlet")
public class NewApplicantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public NewApplicantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		DBConnect NewApplicant = new DBConnect();
		
		String name = request.getParameter("Name");
		String address = request.getParameter("Address");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");   
		Date birthdate = null;
		try {
			birthdate = (Date) formatter.parse(request.getParameter("Birthdate"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String jobhistory = request.getParameter("Jobhistory");
		String reference = request.getParameter("Reference");
		String veteranstatus = request.getParameter("Veteranstatus");
		
		NewApplicant.insertNewApplicant(name, address, birthdate, jobhistory, reference, veteranstatus );
		
		request.getRequestDispatcher("/ApplicantList.jsp").forward(request, response);
		
 		
	}

}
