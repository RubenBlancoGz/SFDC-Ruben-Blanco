package page;

import java.util.LinkedList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import page.opportunities.NewOpportunityPage;

public class LookupPage {
	private WebDriver driver;
	public LookupPage(WebDriver driver) {
		this.driver = driver;        
	}
	public NewOpportunityPage selectAccount(String name) {
		String windowID = driver.getWindowHandle();
        Set<String> setWindows = driver.getWindowHandles();
        LinkedList<String> windowsList = new LinkedList<>(setWindows);
        driver.switchTo().window(windowsList.getLast());
        driver.switchTo().frame(driver.findElement(By.id("searchFrame")));
        driver.findElement(By.id("lksrch")).sendKeys(name);
        driver.findElement(By.name("go")).click();
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.id("resultsFrame")));
        driver.findElement(By.linkText(name)).click();
        driver.switchTo().window(windowID);
        return new NewOpportunityPage();
	}	
}
