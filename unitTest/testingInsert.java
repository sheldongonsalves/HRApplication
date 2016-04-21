import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import customTools.DBConnect;
import customTools.DBLogin;
import model.HrInterviewtable;

public class testingInsert {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testinsert() {
			
		List<HrInterviewtable>  record = null;
			DBLogin dbl= new DBLogin();
			DBConnect dbc= new DBConnect();
			long id=4;
			
			System.out.println("Test if insert is working") ;
			
			dbl.insertNewInterviewTable(id, "No", "");
			
			record = dbc.getInterviewList(id).getResultList();
			
			for(HrInterviewtable hri:record)
			{
				System.out.println("This interview row is :"+ hri.getHrApplicant().getApplicantid());
			}
			
			System.out.println("test after getInterviewList");

			assertEquals(record.get(0).getHrApplicant().getApplicantid(), 4);
					
			//assertTrue(record.size()>0);
//		      assertEquals(appList.size(), 3) ;

			
	 }
	


}
