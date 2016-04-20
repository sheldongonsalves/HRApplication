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

	
}
