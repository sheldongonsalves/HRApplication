

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.DBLogin;
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

		record = DBLogin.getLogin(request.getParameter("username"), request.getParameter("password"));
		
		if(record == null) {
			
//System.out.println("record is null, username: "+request.getParameter("username"));
			
			request.setAttribute("message","Invalid User or Password!!");
			request.getRequestDispatcher("/j_login.jsp").forward(request, response);
			
		}
		else {
			
//System.out.println("record is not null");

			request.setAttribute("message", "working great");
			request.getRequestDispatcher("j_login.jsp").forward(request, response);
		}
	}

}
