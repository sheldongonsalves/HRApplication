

import java.io.IOException;
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

@WebServlet("/j_loginServlet")
public class j_loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public j_loginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HrLogin record = null;
		//HttpSession session = request.getSession();
		List<HrApplicant> appList = null;
		DBConnect dbc = new DBConnect();

		record = DBLogin.getLogin(request.getParameter("username"), request.getParameter("password"));

		if(record == null) {

			request.setAttribute("message","Invalid User or Password!!");
			request.getRequestDispatcher("/j_login.jsp").forward(request, response);

		}
		else {

			appList = dbc.getApplicantList().getResultList();			
			if(appList.isEmpty()){
				request.setAttribute("applicantlist", "No Applicants");
				request.getRequestDispatcher("ApplicantList.jsp").forward(request, response);
			}
			else {
				request.setAttribute("applicantlist", appList);
				request.getRequestDispatcher("ApplicantList.jsp").forward(request, response);
			}
		}
	}

}
