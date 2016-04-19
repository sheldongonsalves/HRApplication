import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.TypedQuery;

import org.junit.Test;

import customTools.DBConnect;
import customTools.DBLogin;
import model.HrInterviewtable;
import model.HrLogin;

public class testdbLogin {

	@Test
public void testLogin() {
		
		HrLogin record = new HrLogin();

		record = DBLogin.getLogin("Dawn", "password1");
			
				System.out.println("Test if login is retrieved") ;
						
			      assertEquals(record.getHrRole().getRoleid(),2) ;
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
