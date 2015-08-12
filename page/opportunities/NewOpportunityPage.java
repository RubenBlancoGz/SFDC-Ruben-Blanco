package page.opportunities;

import java.util.LinkedList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import page.TopMenu;

public class NewOpportunityPage extends TopMenu{
	@FindBy(xpath = "//label[text()='Opportunity Name']/following::input") 
	@CacheLookup
	WebElement opportunityName;
	
	@FindBy(xpath = "//img[@class='calRight']") 
	@CacheLookup
	WebElement nextMonth;
	
	@FindBy(xpath = "//img[@class='calLeft']") 
	@CacheLookup
	WebElement prevMonth;
	
	@FindBy(xpath = "//label[text()='Close Date']/following::input") 
	@CacheLookup
	WebElement closeDateField;	
	
	@FindBy(xpath = "//input[@name='save']") 
	@CacheLookup
	WebElement saveButton;
	
	public NewOpportunityPage setOpportunityName(String name) {
		opportunityName.sendKeys(name);
		return new NewOpportunityPage();
	}
	
	private void selectMonth(String month){
		new Select(driver.findElement(By.id("calMonthPicker"))).selectByVisibleText(month);
	}
	
	private void selectYear(String year){
		new Select(driver.findElement(By.id("calYearPicker"))).selectByVisibleText(year);
	}
	
	private void selectDay(String day) {
		driver.findElement(By.xpath("//td[text()='"+day+"']"));
	}	
	public void expandCalendar() {
		closeDateField.click();
	}
	
	public NewOpportunityPage setCloseDate(String day, String month, String year) {
		expandCalendar();
		selectMonth(month);
		selectYear(year);
		selectDay(day);
		return new NewOpportunityPage();
	}
	
	public NewOpportunityPage selectStage(String stage) {
		new Select(driver.findElement(By.id("opp11"))).selectByVisibleText(stage);
		return new NewOpportunityPage();
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
	
	public OpportunityInfoPage clickSaveButton() {
		saveButton.click();
		return new OpportunityInfoPage();
	}
	
	
}
