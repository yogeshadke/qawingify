package Qa_wingify_Page_Object;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Qa_wingify_Home_Page {
    WebDriver driver;

    public Qa_wingify_Home_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Identify WebElement for the sort button
    @FindBy(xpath = "//div[@class='table-responsive']//th[@id='amount']")
    WebElement sortButton;

    // Identify WebElements for the sortable items
    @FindBy(xpath = "//div[@class='table-responsive']") // Adjust the XPath as needed
    List<WebElement> sortableItems;

    // Method to click the sort button
    public void rclickSortButton() {
        sortButton.click();
    }

    // Method to get the sorted items
    public List<WebElement> getSortedItems() {
        return sortableItems;
    }

    // Placeholder for any additional actions to navigate to the home page
    public void Home_page() {
        // Add code to navigate to the home page if necessary
    }

	public void clickSortButton() {
		// TODO Auto-generated method stub
		sortButton.click();
	}
}
