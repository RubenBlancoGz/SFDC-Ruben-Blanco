package page;


public class SalesForceHomePage extends TopMenu{
	public SalesForceHomePage() {
		if (driver.getTitle() != null) {
			System.out.println("------------------"+driver.getCurrentUrl());
		}
		
	}
}
