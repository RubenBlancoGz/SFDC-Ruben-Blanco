package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
/*
import framework.pages.admin.conferencerooms.RoomsPage;
import framework.pages.admin.resources.ResourcesPage;
import framework.selenium.SeleniumDriverManager;*/




import page.account.AccountPage;
import page.leads.LeadsPage;
import page.opportunities.OpportunitiesPage;
import commons.SeleniumDriverManager;

/**
 * This class contains the main menu
 * @author Ruben Blanco
 *
 */
public abstract class TopMenu {
	protected WebDriver driver;	
	protected WebDriverWait wait;

	@FindBy(linkText = "Accounts") 
	WebElement accountsLink;

	@FindBy(linkText = "Leads") 
	WebElement leadsLink;

	@FindBy(linkText = "Opportunities") 
	WebElement opportunitiesLink;
	
	public TopMenu() {
		driver = SeleniumDriverManager.getManager().getDriver();
		wait = SeleniumDriverManager.getManager().getWait();
		PageFactory.initElements(driver, this);
	}

	public AccountPage clickAccountsLink() {
		accountsLink.click();
		return new AccountPage();
	}
	
	public LeadsPage clickLeadsLink() {
		leadsLink.click();
		return new LeadsPage();
	}
	
	public OpportunitiesPage clickOpportunitiesLink() {
		opportunitiesLink.click();
		return new OpportunitiesPage();
	}


}
