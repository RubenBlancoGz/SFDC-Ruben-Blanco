package page.opportunities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import page.TopMenu;

public class OpportunitiesPage extends TopMenu{


	@FindBy(xpath = "//input[@title='New']") 
	WebElement createNew;

	public NewOpportunityPage clickNew() {
		createNew.click();
		return new NewOpportunityPage();
	}
	
}
