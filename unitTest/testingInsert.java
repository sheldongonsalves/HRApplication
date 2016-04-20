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
			
			System.out.println("Test if insert is working") ;
			
			dbl.insertNewInterviewTable(1, "No", "");
			record = dbc.getInterviewList(1).getResultList();

System.out.println("test after getInterviewList");
							
			assertTrue(record.size()>0);
			
			
	 }
	


}
