package customTools;

import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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

}
