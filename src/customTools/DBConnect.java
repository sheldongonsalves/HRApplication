//Sheldon Gonsalves
package customTools;
import javax.persistence.Persistence;

import java.util.Date;
import java.util.List;

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

	public TypedQuery <HrApplicant> getApplicantList()
	{
		EntityManager em1=DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em1.getTransaction();
		TypedQuery<HrApplicant> query =em1.createQuery("SELECT h.applicantid ,h.applicantname FROM HrApplicant h",HrApplicant.class);
		return query ;

	}

	public TypedQuery <HrApplicant> getApplicantDetails(long applicant_id)
	{
		EntityManager em1=DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em1.getTransaction();
		TypedQuery<HrApplicant> query =em1.createQuery("SELECT h FROM HrApplicant h where h.applicantid=:applicant_id",HrApplicant.class)
				.setParameter("applicantid", applicant_id);
		return query ;

	}
	protected TypedQuery <HrDrugtest> getApplicantDrugDetails(long applicant_id)
	{
		EntityManager em1=DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em1.getTransaction();
		TypedQuery<HrDrugtest> query =em1.createQuery("SELECT h FROM HrDrugtest h where h.hrApplicant.applicantid=:applicant_id",HrDrugtest.class)
				.setParameter("applicantid", applicant_id);
		return query ;

	}
	protected long getNextApplicantid()
	{

		EntityManager em1=DBUtil.getEmFactory().createEntityManager();
		TypedQuery<Long> query =em1.createQuery("SELECT max(h.applicantid) FROM HrApplicant h",Long.class);

		return (long) query.getSingleResult();
	}
	protected long getNextDrugTestid()
	{

		EntityManager em1=DBUtil.getEmFactory().createEntityManager();
		TypedQuery<Long> query =em1.createQuery("SELECT max(h.drugtestid) FROM HrDrugtest h",Long.class);

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
	public void insertDrugTest(long applicantid  ,String alcoholtest ,String dottest,String standardpaneltest)
	{
		HrDrugtest hrd = new HrDrugtest();
		HrApplicant hra =new HrApplicant();
		hra.setApplicantid(applicantid);
		hrd.setDrugtestid(getNextDrugTestid()+1);
		hrd.setHrApplicant(hra);
		hrd.setAlcoholtest(alcoholtest);
		hrd.setDottest(dottest);
		hrd.setStandardpaneltest(standardpaneltest);

		insert(hrd);
	}


	// generics  to insert code
	public <T> void insert(Object T) {
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

	public void updateEducation(long applicantid ,String education)
	{
		EntityManager em1 = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em1.getTransaction();
		TypedQuery query =em1.createQuery(
				"Update HrApplicant hr set hr.education =:education where hr.applicantid = :applicantid",HrApplicant.class)

				.setParameter("education",education)
				.setParameter("applicantid",applicantid);
		trans.begin();

		try
		{

			query.executeUpdate();
			trans.commit();

		}
		catch (Exception e)
		{
			trans.rollback();

		}
		finally
		{
			em1.close();
		}

	}

	public void updateCitizenship(long applicantid ,String citizenship)
	{
		EntityManager em1 = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em1.getTransaction();
		TypedQuery query =em1.createQuery(
				"Update HrApplicant hr set hr.citizenstatus =:citizenship where hr.applicantid = :applicantid",HrApplicant.class)

				.setParameter("citizenstatus",citizenship)
				.setParameter("applicantid",applicantid);
		trans.begin();

		try
		{

			query.executeUpdate();
			trans.commit();

		}
		catch (Exception e)
		{
			trans.rollback();

		}
		finally
		{
			em1.close();
		}

	}


	public void updateDrugTest(long applicantid )
	{
		EntityManager em1 = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em1.getTransaction();
		TypedQuery query=null;
		List <HrDrugtest> drugTest =getApplicantDrugDetails(applicantid).getResultList();
		if(drugTest.get(0).getDottest().equalsIgnoreCase("Fail")||drugTest.get(0).getAlcoholtest().equalsIgnoreCase("Fail")||drugTest.get(0).getStandardpaneltest().equalsIgnoreCase("Fail"))
		{
			String result="Fail";
			query =em1.createQuery(
					"Update HrApplicant hr set hr.drugtestresult =:result where hr.applicantid = :applicantid",HrApplicant.class)

					.setParameter("drugtestresult",result)
					.setParameter("applicantid",applicantid);
		}
		else
		{
			String result="Pass";
			query =em1.createQuery(
					"Update HrApplicant hr set hr.drugtestresult =:result where hr.applicantid = :applicantid",HrApplicant.class)

					.setParameter("drugtestresult",result)
					.setParameter("applicantid",applicantid);
		}
		trans.begin();

		try
		{

			query.executeUpdate();
			trans.commit();

		}
		catch (Exception e)
		{
			trans.rollback();

		}
		finally
		{
			em1.close();
		}

	}
}



