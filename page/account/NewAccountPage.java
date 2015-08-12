package page.account;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import page.TopMenu;

public class NewAccountPage extends TopMenu{
	@FindBy(xpath = "//label[contains(.,'Name')]/following::input") 
	WebElement accountName;
	
	@FindBy(xpath = "//input[@name='save']") 
	WebElement saveButton;
	
	public NewAccountPage setAccountName(String name) {
		accountName.clear();
		accountName.sendKeys(name);
		return new NewAccountPage();
	}
	
	public AccountContentPage clickSaveButton() {
		saveButton.click();
		return new AccountContentPage();
	}
	
}
