package Qa_wingify_Page_Object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Qa_wingify_Login_Page {
	WebDriver ldriver;

	public Qa_wingify_Login_Page(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	// 2.identify WebElement

	@FindBy(id = "username")
	WebElement username1;
	@FindBy(id = "password")
	WebElement password1;
	@FindBy(id="log-in")
	WebElement login;

	// 3.identify action on webElement

	public void Loginpassdata(String username, String password) throws InterruptedException {
		username1.sendKeys(username);
		password1.sendKeys(password);
		login.click();
		
		Thread.sleep(4000);

	}

}


