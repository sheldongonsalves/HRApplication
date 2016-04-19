package customTools;

import java.util.Date;
import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.HrApplicant;
import model.HrInterviewtable;
import model.HrLogin;

public class DBLogin {

	public static HrLogin getLogin(String username, String password)
	{

		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT h FROM HrLogin h where h.username=:username and h.password=:password";
		TypedQuery<HrLogin> q = em.createQuery(qString, model.HrLogin.class);
		q.setParameter("username", username);
		q.setParameter("password", password);
		HrLogin record = null;
		List<HrLogin> list=null;
		try{
			list=q.getResultList();
			if(list==null||list.isEmpty())
				record=null;
			else
				record=list.get(0);
		}catch(Exception e){
			System.out.println(e);
		}finally{
			em.close();
			return record;
		}

	}

	// generics  to insert code
	protected <T> void insert(Object T) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(T);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	protected long getNextInterviewTableid()
	{

		EntityManager em1=DBUtil.getEmFactory().createEntityManager();
		TypedQuery<Long> query =em1.createQuery("SELECT max(h.interviewid) FROM HrInterviewtable h",Long.class);

		return (long) query.getSingleResult();
	}

	public void insertNewInterviewTable(long applicantid, String schedule, String status)
	{
		HrInterviewtable hrit =new HrInterviewtable();
		HrApplicant ha = new HrApplicant();
		DBConnect dbc = new DBConnect();

		List<HrInterviewtable> details= dbc.getInterviewList(applicantid).getResultList();
		if(details.isEmpty()){
			//insert new interview row
			
			ha.setApplicantid(applicantid);
			hrit.setHrApplicant(ha);
			hrit.setInterviewid(getNextInterviewTableid()+1);
			hrit.setHrinterviewscheduled(schedule);
			hrit.setHrinterviewresult(status);
			hrit.setCodingtest("");
			hrit.setCodingtestresult("");
			hrit.setGroupinterviewresult("");
			hrit.setGroupinterviewscheduled("");
			hrit.setHminterviewresult("");
			hrit.setHminterviewscheduled("");
			insert(hrit);
		}
		else {
			//update the interview table
			dbc.updateHrInterviewSchedule(applicantid,schedule);
			dbc.updateHrResult(applicantid,status);
		}
	}

}
