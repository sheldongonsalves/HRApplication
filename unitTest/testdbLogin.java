import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import customTools.DBLogin;
import model.HrLogin;

public class testdbLogin {

	@Test
public void testLogin() {
		
		HrLogin record = null;

		record = DBLogin.getLogin("Dawn", "password1");
			
				System.out.println("Test if login is retrieved") ;
						
			      assertEquals(record.getHrRole().getRoleid(),2) ;
		 }

}
