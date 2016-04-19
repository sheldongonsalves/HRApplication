import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import customTools.DBConnect;
import model.HrApplicant;

public class testIngDb {

	@Test
	public void test() {
		//fail("Not yet implemented");
		DBConnect dbc = new DBConnect();
		List<HrApplicant> appList = null;

		appList = dbc.getApplicantList().getResultList();	
		
		System.out.println("Test if ApplicantList is retrieved") ;
		
	      //assertEquals(appList.get(0).getApplicantid(),1) ;
	      assertEquals(appList.size(), 3) ;


	}

}
