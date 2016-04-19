

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.DBConnect;
import customTools.DBLogin;
import model.HrApplicant;
import model.HrLogin;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 
		HttpSession session = request.getSession();

		DBConnect dbc = new DBConnect();
		List <HrApplicant> applicantlist  =  dbc.getApplicantList().getResultList();		
		HrLogin record = DBLogin.getLogin(request.getParameter("username"), request.getParameter("password"));

		if(record==null) {

			request.setAttribute("message","Invalid User or Password!!");
			request.getRequestDispatcher("/Login.jsp").forward(request, response);

		}
		else {
			//pass on the whole user login record

			session.setAttribute("user", record);
			
			session.setAttribute("roleid", record.getHrRole().getRoleid());
			
/*
			if(applicantlist.isEmpty()){
				System.out.println("We are here if");
				session.setAttribute("applicantlist", "No Applicants");


				session.setAttribute("user", record);
				//long roleid = 3;
				session.setAttribute("roleid", record.getHrRole().getRoleid());
				session.setAttribute("rolename", record.getHrRole().getRolename());

				session.setAttribute("user",record);
				//long roleid = 3;
				session.setAttribute("roleid", record.getHrRole().getRoleid());
				//System.out.println("----------------------"+record.getHrRole().getRoleid());

*/

				if(applicantlist.isEmpty()){
					System.out.println("We are here if");

					session.setAttribute("applicantlist", "No Applicants");

					session.setAttribute("applicantlist","No Applicants");

					request.getRequestDispatcher("/ApplicantList.jsp").forward(request, response);
				}
				else {
					System.out.println("We are here else");
					try{
						request.setAttribute("applicantlist",applicantlist);
						request.getRequestDispatcher("/ApplicantList.jsp").forward(request, response);
						//request.getRequestDispatcher("Interview.jsp").forward(request, response);
					}
					catch (NumberFormatException ex)
					{
						ex.getMessage();
					}

				}

			}
		}

	}

