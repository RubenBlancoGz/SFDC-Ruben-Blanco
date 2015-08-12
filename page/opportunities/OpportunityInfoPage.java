package page.opportunities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class OpportunityInfoPage {	
	@FindBy(xpath = "//td[text()='Opportunity Name']/following::td/div") 
	@CacheLookup
	WebElement oppName;
	
	@FindBy(xpath = "//td[text()='Close Date']/following::td/div") 
	@CacheLookup
	WebElement oppCloseDate;
	
	@FindBy(xpath = "//td[text()='Stage']/following::td/div") 
	@CacheLookup
	WebElement oppStage;
	
	@FindBy(xpath = "//td[text()='Account Name']/following::td/div") 
	@CacheLookup
	WebElement oppAccount;
	
	public String getOppName() {
		return oppName.getText();
	}
	
	public String getCloseDate() {
		return oppCloseDate.getText();
	}
	
	public String getStage() {
		return oppStage.getText();
	}
	public String getAccount() {
		return oppAccount.getText();
	}
	
}
