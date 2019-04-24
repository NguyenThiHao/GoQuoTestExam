package specs;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.AvailablePage;
import pages.CmdSearchPage;
import pages.Common;

/**
 * 
 * @author HAO
 *
 */
public class Testcase {
	@BeforeTest
	public void BeforeTest(){
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
		Common.driver.manage().window().maximize();
		Common.driver.get("https://vietnamairlinesvn.com");
	}
	
	@Test
	public static void main(){
		String departCity = "HAN";
		String returnCity = "SGN";
		String checkinMonth = "4";
		String checkinDay = "27";
		String checkoutMonth = "5";
		String checkoutDay = "5";
		String totalAdults = "3";
		String totalChilds = "1";
		
		CmdSearchPage cmdSearch = new CmdSearchPage();
		cmdSearch.clickRoundTrip();
		cmdSearch.selectDepartCity(departCity);
		cmdSearch.selectReturnCity(returnCity);
		cmdSearch.checkin(checkinMonth, checkinDay);
		cmdSearch.checkout(checkoutMonth, checkoutDay);
		cmdSearch.selectAdult(totalAdults);
		cmdSearch.selectChilds(totalChilds);
		cmdSearch.clickSearch();
		
		AvailablePage availablePage = new AvailablePage();
		availablePage.verifyAvailablePageOpens();
		Assert.assertEquals(availablePage.verifyTypeTicket(), true);
		availablePage.verifyTotalPassengers(totalAdults, totalChilds);
		Assert.assertEquals(availablePage.verifyCheckin(checkinMonth, checkinDay), true);
		Assert.assertEquals(availablePage.verifyCheckout(checkoutMonth, checkoutDay), true);
		availablePage.verifyLocation(departCity, returnCity);
		availablePage.verifyCheckinIsSelectDate(checkinMonth, checkinDay);	
	}
	
	@AfterTest
	public void AfterTest(){
		System.out.println("Close browser");
		Common.driver.quit();
	}
}
