

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
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		
		HrLogin record = null;
		DBLogin.getLogin("username", "password");
		
		HttpSession session = request.getSession();
		
		
		
		session.setAttribute("username", "Matt");
		session.setAttribute("password", "MattChuang");
		request.getRequestDispatcher("j_login.jsp").forward(request, response);

	}

}
