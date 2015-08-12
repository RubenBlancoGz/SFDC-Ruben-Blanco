package page.account;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import page.TopMenu;

public class AccountPage extends TopMenu {
	@FindBy(xpath = "//input[@name='new']") 
	WebElement btnNewAccount;
	
	public NewAccountPage clickNewAccountButton() {
		btnNewAccount.click();
		return new NewAccountPage();
	}	
}
