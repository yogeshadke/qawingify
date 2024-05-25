package Qa_wingnify_Util;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.WebDriverListener;

public class CustomWebDriverListener implements WebDriverListener {
	public void beforeNavigateTo(String url, WebDriver driver) {
        System.out.println("Before navigating to: " + url);
    }
	public void afterNavigateTo(String url, WebDriver driver) {
        System.out.println("Navigated to: " + url);
    }

    // Implement other event methods as needed
}
