 //Sheldon Gonsalves
package customTools;
import javax.persistence.Persistence;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


import model.HrApplicant;
import model.HrDrugtest;
import model.HrInterviewtable;
import model.HrLogin;
import model.HrRole;

public class DBConnect {

	public DBConnect() {
		
	}
	
	public TypedQuery <HrApplicant> searchUser()
	{
		EntityManager em1=DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em1.getTransaction();
		TypedQuery<HrApplicant> query =em1.createQuery("SELECT h.applicantid ,h.applicantname FROM HrApplicant h",HrApplicant.class);
		return query ;
		
	}
	
	public TypedQuery <HrApplicant> getUserDetails(long applicant_id)
	{
		EntityManager em1=DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em1.getTransaction();
		TypedQuery<HrApplicant> query =em1.createQuery("SELECT h FROM HrApplicant h where h.applicantid=:applicant_id",HrApplicant.class)
				.setParameter("applicantid", applicant_id);
		return query ;
	
	}
	protected long getNextApplicantid()
	{
		
		EntityManager em1=DBUtil.getEmFactory().createEntityManager();
		TypedQuery<Long> query =em1.createQuery("SELECT max(h.applicantid) FROM HrApplicant h",Long.class);
		
		return (long) query.getSingleResult();
	}
	
	public void insertNewApplicant(String name ,String address ,Date bday ,String job_history ,String job_refrernce ,String veteran)
	{
		HrApplicant hra =new HrApplicant();
		hra.setApplicantid(getNextApplicantid()+1);
		hra.setApplicantname(name);
		hra.setAddress(address);
		hra.setBirthdate(bday);
		hra.setJobhistory(job_history);
	    hra.setJobreference(job_refrernce);	
		hra.setVeteranstatus(veteran);
		insert(hra);
	}
	
	//generic code to update
	public static <T> void update(Object T) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(T);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
	public static <T> void insert(Object T) {// generics 
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
}
