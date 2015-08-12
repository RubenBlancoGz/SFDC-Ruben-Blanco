package myTests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import page.LoginPage;
import page.SalesForceHomePage;
import page.opportunities.NewOpportunityPage;
import page.opportunities.OpportunitiesPage;
import page.opportunities.OpportunityInfoPage;

public class Test001 {
	private String OppName = "Opportunity test 001";
	private String accountName = "testName001";
	private String day = "10";
	private String month = "October";
	private String year = "2015";
	private String stage = "Prospecting";	
	
	@BeforeClass
	public void preContions(){
		String user = "rtokiohotelbg@gmail.com";
		String pass = "Control123"; 		
		LoginPage login = new LoginPage();
		SalesForceHomePage home = login.SignIn(user, pass);
		home
		.clickAccountsLink()
		.clickNewAccountButton()
		.setAccountName(accountName)
		.clickSaveButton();
	}  

	@Test
	public void f() {
		OpportunitiesPage op = new OpportunitiesPage();
		op.clickOpportunitiesLink()
			.clickNew();
		NewOpportunityPage newOpp = new NewOpportunityPage();
		newOpp.setOpportunityName(OppName)
			.setCloseDate(day, month, year)
			.selectStage(stage)
			.selectAccount(accountName)
			.clickSaveButton();		
		String date = day+"/"+month+"/"+year;
		OpportunityInfoPage inf = new OpportunityInfoPage();
		Assert.assertEquals(OppName,inf.getOppName());
		Assert.assertEquals(date,inf.getCloseDate());
		Assert.assertEquals(stage,inf.getStage());
		Assert.assertEquals(accountName,inf.getAccount());
	}
	
}
