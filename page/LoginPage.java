package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import commons.SeleniumDriverManager;

/**
 * This class provide methods to login into the system
 * @author Exam
 *
 */
public class LoginPage {

	@FindBy(xpath = "//input[@id='username']") 
	WebElement txtUserName;
	
	@FindBy(xpath = "//input[@id='password']") 
	WebElement txtPass;
	
	@FindBy(xpath = "//button[@id='Login']")
	WebElement btnLogin;
	
	@FindBy(xpath = "//input[@title='Continue']")
	WebElement btnContinue;

	protected WebDriver driver;	
	protected WebDriverWait wait;

	/**
	 * This constructor initialize the driver and waits
	 */
	public LoginPage() {		
		driver = SeleniumDriverManager.getManager().getDriver();
		wait = SeleniumDriverManager.getManager().getWait();
		PageFactory.initElements(driver, this);
	}
	
	public void setUserName(String userName) {
		txtUserName.clear();
		txtUserName.sendKeys(userName);
	}
	
	public void setPass(String pass) {
		txtPass.clear();
		txtPass.sendKeys(pass);
	}
	
	public void clickSigInButton() {
		btnLogin.click();
	}
	
	public SalesForceHomePage SignIn(String user, String pass) {
		setUserName(user);
		setPass(pass);
		clickSigInButton();
		/*if (btnContinue.isDisplayed()) {
			btnContinue.click();
		}	*/	
		return new SalesForceHomePage();
	}

}