import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.DBConnect;
import customTools.DBLogin;
import model.HrApplicant;
import model.HrInterviewtable;

@WebServlet("/PreInterview")
public class PreInterview extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public PreInterview() {
        super();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBConnect dbc= new DBConnect();
        DBLogin dbl =new DBLogin();
        String reject = request.getParameter("reject");
        HrInterviewtable hrit = new HrInterviewtable();
        HrApplicant hra = new HrApplicant();
        String hrinterviewschedule="Yes";
        long applicantid = (long)session.getAttribute("applicantid");
        long roleId = (long)session.getAttribute("roleid");
        List<HrInterviewtable> interviewresult =dbc.getApplicantInterviewDetails(applicantid).getResultList();
        
        System.out.println("===============applicantid is "+applicantid);
        System.out.println("===============roleid is "+roleId);
        long roleid=(long) session.getAttribute("roleid");
        String rolename = (String) session.getAttribute("rolename");
        String username = (String) session.getAttribute("username");
       

        if(roleId == 1)
        {
            dbl.insertNewInterviewTable(applicantid, hrinterviewschedule, "");    //insert or update hrinterviewschedule
        }
        List<HrInterviewtable> isCandidatePresent =dbc.getInterviewList(applicantid).getResultList();
       
        if(isCandidatePresent.isEmpty())
        {
           
            System.out.println("Empty result");
            List <HrApplicant> applicantlist  =  dbc.getApplicantList().getResultList();
            request.setAttribute("applicantlist",applicantlist);
            session.setAttribute("applicantlist",applicantlist);
            session.setAttribute("roleid", roleid);
            session.setAttribute("rolename", rolename);
            session.setAttribute("username", username);
            session.setAttribute("applicantid", applicantid);
            request.setAttribute("messages","This applicant cannot be scheduled because he has not completed previous rounds!!");
            request.getRequestDispatcher("/ApplicantList.jsp").forward(request, response);
        }
        else
        {
           
       
            if(roleId == 6)    //hiring manager and coding test
            {
                //update interview table for Hiring Manager here
                dbc.updateScheduleHiringManagerInterview(applicantid);
            }
            if (roleId == 7)
            {
                dbc.updateScheduleGroupInterview(applicantid);
            }
           

            //if HR employee's roles are HR Manager, Hiring Manager, or Group interview
            if (roleId == 1 || (roleId == 6 && isCandidatePresent.get(0).getHrinterviewresult().equals("Pass")) || (roleId == 7 && isCandidatePresent.get(0).getHminterviewresult().equals("Pass")))
            {
                session.setAttribute("interviewresult",interviewresult);
                session.setAttribute("roleid", roleid);
                session.setAttribute("rolename", rolename);
                session.setAttribute("username", username);
                session.setAttribute("applicantid", applicantid);
                request.getRequestDispatcher("/Interview.jsp").forward(request, response);
            }
            else if((roleId == 6 && isCandidatePresent.get(0).getHrinterviewresult().equals("Fail")) ||
                    (roleId == 7 && (isCandidatePresent.get(0).getHrinterviewresult().equals("Fail") ||
                            isCandidatePresent.get(0).getHminterviewresult().equals("Fail"))))
            {
                session.setAttribute("roleid", roleid);
                session.setAttribute("rolename", rolename);
                session.setAttribute("username", username);
                session.setAttribute("applicantid", applicantid);
                session.setAttribute("reject", reject);
                request.getRequestDispatcher("/Reject.jsp").forward(request, response);

            }
        }   
       

    }


}