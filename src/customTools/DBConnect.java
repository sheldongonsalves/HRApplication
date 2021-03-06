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
		TypedQuery<HrApplicant> query =em1.createQuery("SELECT h FROM HrApplicant h",HrApplicant.class);
		return query ;

	}

	public TypedQuery <HrApplicant> getApplicantDetails(long applicant_id)
	{
		EntityManager em1=DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em1.getTransaction();
		TypedQuery<HrApplicant> query =em1.createQuery("SELECT h FROM HrApplicant h where h.applicantid=:applicant_id",HrApplicant.class)
				.setParameter("applicant_id", applicant_id);
		return query ;

	}
	public TypedQuery <HrDrugtest> getApplicantDrugDetails(long applicant_id)
	{
		EntityManager em1=DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em1.getTransaction();
		TypedQuery<HrDrugtest> query =em1.createQuery("SELECT h FROM HrDrugtest h where h.hrApplicant.applicantid=:applicant_id",HrDrugtest.class)
				.setParameter("applicant_id", applicant_id);
		return query ;

	}

	public TypedQuery <HrInterviewtable> getApplicantInterviewDetails(long applicant_id)
	{
		EntityManager em1=DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em1.getTransaction();
		TypedQuery<HrInterviewtable> query =em1.createQuery("SELECT h FROM HrInterviewtable h where h.hrApplicant.applicantid=:applicant_id",HrInterviewtable.class)
				.setParameter("applicant_id", applicant_id);
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

	public void insertNewApplicant(String name ,String address ,Date birthdate ,String education, String job_history ,String job_refrernce ,String veteran)
	{
		HrApplicant hra =new HrApplicant();
		hra.setApplicantid(getNextApplicantid()+1);
		hra.setApplicantname(name);
		hra.setAddress(address);
		hra.setBirthdate(birthdate);
		hra.setEducation(education);
		hra.setJobhistory(job_history);
		hra.setJobreference(job_refrernce);	
		hra.setVeteranstatus(veteran);
		insert(hra);
	}
	public void insertDrugTest(long applicantid  ,String alcoholtest ,String dottest,String standardpaneltest)
	{
		HrDrugtest hrd = new HrDrugtest();
		HrApplicant hra =new HrApplicant();
		List <HrDrugtest> existingApplicant =getApplicantDrugDetails(applicantid).getResultList();
		hra.setApplicantid(applicantid);
		hrd.setDrugtestid(getNextDrugTestid()+1);
		hrd.setHrApplicant(hra);
		hrd.setAlcoholtest(alcoholtest);
		hrd.setDottest(dottest);
		hrd.setStandardpaneltest(standardpaneltest);
		if(existingApplicant.isEmpty())
		{
			insert(hrd);
			updateDrugTest(applicantid);
		}
		else
		{
			updateDrugTestForExistingUser(standardpaneltest ,dottest ,alcoholtest ,applicantid);
			updateDrugTest(applicantid);	

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

				.setParameter("citizenship",citizenship)
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
	public void updateDrugTestForExistingUser(String standardpanelTest ,String dotTest , String alcoholTest ,long applicantid)
	{
		EntityManager em1 = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em1.getTransaction();
		TypedQuery query =em1.createQuery(
				"Update HrDrugtest hr set hr.standardpaneltest =:standardpanelTest ,hr.dottest=:dotTest ,hr.alcoholtest=:alcoholTest where hr.hrApplicant.applicantid = :applicantid",HrDrugtest.class)

				.setParameter("standardpanelTest",standardpanelTest)
				.setParameter("dotTest", dotTest)
				.setParameter("alcoholTest", alcoholTest)
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
		System.out.println(drugTest.get(0).getDottest());
		if(drugTest.get(0).getDottest().equalsIgnoreCase("Fail")||drugTest.get(0).getAlcoholtest().equalsIgnoreCase("Fail")||drugTest.get(0).getStandardpaneltest().equalsIgnoreCase("Fail"))
		{   
			String result="Fail";
			query =em1.createQuery(
					"Update HrApplicant hr set hr.drugtestresult =:result where hr.applicantid = :applicantid",HrApplicant.class)

					.setParameter("result",result)
					.setParameter("applicantid",applicantid);
		}
		else
		{
			String result="Pass";
			query =em1.createQuery(
					"Update HrApplicant hr set hr.drugtestresult =:result where hr.applicantid = :applicantid",HrApplicant.class)

					.setParameter("result",result)
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
	public void updateHrInterviewSchedule(long applicantid ,String hrinterviewresultstatus)//Hr manager hits a schedule then update the hrinterviewtable
	{
		EntityManager em1 = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em1.getTransaction();
		TypedQuery query =em1.createQuery(
				"Update HrInterviewtable hr set hr.hrinterviewscheduled =:hrinterviewstatus where hr.hrApplicant.applicantid = :applicantid",HrInterviewtable.class)

				.setParameter("hrinterviewstatus",hrinterviewresultstatus)
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
	public void updateHrResult(long applicantid ,String hrinterviewresult)//Hr manager hits a schedule then update the hrinterviewtable
	{
		EntityManager em1 = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em1.getTransaction();
		TypedQuery query =em1.createQuery(
				"Update HrInterviewtable hr set hr.hrinterviewresult =:hrinterviewresult where hr.hrApplicant.applicantid = :applicantid",HrInterviewtable.class)

				.setParameter("hrinterviewresult",hrinterviewresult)
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
	public void updateScheduleHiringManagerInterview(long applicantid)//Hm manager interview scheduled
	{
		EntityManager em1 = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em1.getTransaction();
		TypedQuery query ;
		List<HrInterviewtable> details=(List<HrInterviewtable>) getInterviewList(applicantid).getResultList();
		
			if(details.get(0).getHrinterviewresult().equalsIgnoreCase("Pass"))
			{
				String hminterview="Yes";
				query =em1.createQuery(
						"Update HrInterviewtable hr set hr.hminterviewscheduled =:hminterviewstatus where hr.hrApplicant.applicantid = :applicantid",HrInterviewtable.class)

						.setParameter("hminterviewstatus",hminterview)
						.setParameter("applicantid",applicantid);
			}
			else
			{
				String hminterview="No";
				query =em1.createQuery(
						"Update HrInterviewtable hr set hr.hminterviewscheduled =:hminterviewstatus where hr.hrApplicant.applicantid = :applicantid",HrInterviewtable.class)

						.setParameter("hminterviewstatus",hminterview)
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
	public void updateHMInterviewResult(long applicantid ,String hminterviewresultstatus)//HM manager hits a pass or fail then update the hminterview column
	{
		EntityManager em1 = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em1.getTransaction();
		TypedQuery query =em1.createQuery(
				"Update HrInterviewtable hr set hr.hminterviewresult =:hminterviewstatus where hr.hrApplicant.applicantid = :applicantid",HrInterviewtable.class)

				.setParameter("hminterviewstatus",hminterviewresultstatus)
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
	public void updateScheduleGroupInterview(long applicantid)//group interview scheduled
	{
		EntityManager em1 = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em1.getTransaction();
		TypedQuery query ;
		List<HrInterviewtable> details=(List<HrInterviewtable>) getInterviewList(applicantid).getResultList();
		if(details.get(0).getHrinterviewresult().equalsIgnoreCase("Pass"))
		{
			String groupinterview="Yes";
			query =em1.createQuery(
					"Update HrInterviewtable hr set hr.groupinterviewscheduled =:groupinterviewstatus where hr.hrApplicant.applicantid = :applicantid",HrInterviewtable.class)

					.setParameter("groupinterviewstatus",groupinterview)
					.setParameter("applicantid",applicantid);
		}
		else
		{
			String groupinterview="No";
			query =em1.createQuery(
					"Update HrInterviewtable hr set hr.groupinterviewscheduled =:groupinterviewschedulestatus where hr.hrApplicant.applicantid = :applicantid",HrInterviewtable.class)

					.setParameter("groupinterviewschedulestatus",groupinterview)
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

	public void updateGroupInterviewResult(long applicantid ,String groupinterviewresultstatus)//Group Interview hits a pass or fail then update the group interview column
	{
		EntityManager em1 = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em1.getTransaction();
		TypedQuery query =em1.createQuery(
				"Update HrInterviewtable hr set hr.groupinterviewresult =:groupinterviewresultstatus where hr.hrApplicant.applicantid = :applicantid",HrInterviewtable.class)

				.setParameter("groupinterviewresultstatus",groupinterviewresultstatus)
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

	public TypedQuery <HrInterviewtable> getInterviewList(long applicantid)//gets a selected row from the interview table
	{
		EntityManager em1=DBUtil.getEmFactory().createEntityManager();

		TypedQuery<HrInterviewtable> query =em1.createQuery("SELECT h FROM HrInterviewtable h where h.hrApplicant.applicantid = :applicantid",HrInterviewtable.class)

				.setParameter("applicantid", applicantid);
		
		return query;
	}

	public void updateCodingTestTaken(long applicantid ,String codingTestTaken)//Group interview taken or not taken
	{
		EntityManager em1 = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em1.getTransaction();
		TypedQuery query =em1.createQuery(
				"Update HrInterviewtable hr set hr.codingtest =:codingTestTaken where hr.hrApplicant.applicantid = :applicantid",HrInterviewtable.class)

				.setParameter("codingTestTaken",codingTestTaken)
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
	public void updateCodingTestResult(long applicantid ,String codingTestResult)//Coding test result updated in the table
	{
		EntityManager em1 = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em1.getTransaction();
		TypedQuery query =em1.createQuery(
				"Update HrInterviewtable hr set hr.codingtestresult =:codingTestResult where hr.hrApplicant.applicantid = :applicantid",HrInterviewtable.class)

				.setParameter("codingTestResult",codingTestResult)
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
	public void UpdateApplicant(String name ,String address , String jobhistory ,String jobreference ,String veteranstatus ,long applicantid)
	{
		EntityManager em1 = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em1.getTransaction();
		TypedQuery query =em1.createQuery(
				"Update HrApplicant hr set hr.applicantname=:name ,hr.address=:address ,hr.jobhistory=:jobhistory ,hr.jobreference=:jobreference ,hr.veteranstatus=:veteranstatus where hr.applicantid = :applicantid",HrApplicant.class)

				.setParameter("name",name)
				.setParameter("address", address)
				.setParameter("jobhistory",jobhistory)
				.setParameter("jobreference",jobreference)
				.setParameter("veteranstatus",veteranstatus)
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


}



