package Qa_wingify_Test_Cases;


import org.testng.annotations.Test;
import org.testng.annotations.Test;

import Qa_wingify_Page_Object.Qa_wingify_Login_Page;
import Qa_wingnify_Util.Qa_wingify_Base_class;


public class Qa_wingify_Login_Testcase_01 extends Qa_wingify_Base_class {

	@Test
	public void VerfyLogin() throws InterruptedException {
		// openUrl
		driver.get(url);

		Qa_wingify_Login_Page pg = new Qa_wingify_Login_Page(driver);
		pg.Loginpassdata(username, password);
		assert username != null : "Username should not be null";
        assert password != null : "Password should not be null";
       
		

	}
	@Test
	public boolean Verifyusername_and_password(String username, String password) {
        assert username != null : "Username should not be null";
        assert password != null : "Password should not be null";

        boolean isUsernameCorrect = username.equals(this.username);
        boolean isPasswordCorrect = password.equals(this.password);

        assert isUsernameCorrect : "The provided username is incorrect";
        assert isPasswordCorrect : "The provided password is incorrect";

        return isUsernameCorrect && isPasswordCorrect;
    }
}
	


