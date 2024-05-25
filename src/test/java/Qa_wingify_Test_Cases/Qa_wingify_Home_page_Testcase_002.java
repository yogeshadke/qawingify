package Qa_wingify_Test_Cases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Qa_wingify_Page_Object.Qa_wingify_Home_Page;
import Qa_wingify_Page_Object.Qa_wingify_Login_Page;
import Qa_wingnify_Util.Qa_wingify_Base_class;

public class Qa_wingify_Home_page_Testcase_002 extends Qa_wingify_Base_class {

    @Test
    public void VerfyLogin() throws InterruptedException {
        // Open URL
        driver.get(url);

        // Initialize Login Page and perform login
        Qa_wingify_Login_Page loginPage = new Qa_wingify_Login_Page(driver);
        loginPage.Loginpassdata(username, password);

        // Wait for the login process to complete
        Thread.sleep(4000);

        // Initialize Home Page
        Qa_wingify_Home_Page homepage = new Qa_wingify_Home_Page(driver);
        homepage.Home_page();

        // Click the sort button
        homepage.clickSortButton();

        // Wait for the sort operation to complete (if necessary)
        Thread.sleep(2000);

        // Get the sorted items from the home page
        List<String> sortedTexts = homepage.getSortedItems().stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        // Create a sorted copy of the list to compare against
        List<String> expectedSortedTexts = sortedTexts.stream()
                .sorted()
                .collect(Collectors.toList());

        // Verify the list is sorted
        AssertJUnit.assertEquals(sortedTexts, expectedSortedTexts);
    }
}
