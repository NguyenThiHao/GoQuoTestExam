package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * funtion of CmdSearch Page
 * @author HAO
 *
 */
public class CmdSearchPage {
	private String roundTrip = "//input[@id='loaive_r']";
	private String departCity = "//input[@id='departCity']";
	private String returnCity = "//input[@id='returnCity']";
	private String checkin = "//input[@id='flights-checkin']/..//img";
	private String checkout = "//input[@id='flights-checkout']/..//img";
	private String adultSelect = "//select[@id='adult']";
	private String childSelect = "//select[@id='child']";
	private String searchButton = "//input[@id='cmdsearch']";
	/**
	 * click round trip
	 */
	public void clickRoundTrip(){
		System.out.println("Search type of ticket: round trip");
		WebElement el = Common.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.roundTrip)));
		System.out.println("Click to round trip");
		el.click();
	}
	
	/**
	 * Select depart city
	 * @param departCity depart city
	 */
	public void selectDepartCity(String departCity){
		WebElement el = Common.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.departCity)));
		System.out.println("Click to depart city searchbox");
		el.click();
		String departCitySelect = "//div[@aria-labelledby='ui-id-1']//a[@code='" + departCity +"']";
		System.out.println("Select depart city: " + departCity);
		Common.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(departCitySelect))).click();
	}
	
	/**
	 * Select return city
	 * @param returnCity return city
	 */
	public void selectReturnCity(String returnCity){
		WebElement el = Common.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.returnCity)));
		System.out.println("Click to depart city searchbox");
		el.click();
		String returnCitySelect = "//div[@aria-labelledby='ui-id-2']//a[@code='" + returnCity +"']";
		System.out.println("Select return city: " + returnCity);
		Common.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(returnCitySelect))).click();
	}
	
	/**
	 * Select a day of month
	 * @param month
	 * @param day
	 */
	public void selectTime(String month, String day){
		String timeSelect = "//span[@class='ui-datepicker-month' and text()='Tháng " + month +"']/ancestor::div[3]//table//span[@class='ui-datepicker-day' and text()='" +day +"']";
		System.out.println(timeSelect);
		WebElement el = Common.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(timeSelect)));
		System.out.println("Select time: " + day + "/" + month);
		el.click();
	}
	
	/**
	 * Select checin time
	 * @param month
	 * @param day
	 */
	public void checkin(String month, String day){
		System.out.println("Click checkin searchbox");
		Common.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.checkin))).click();
		selectTime(month, day);
	}
	
	/**
	 * Select checkout time
	 * @param month
	 * @param day
	 */
	public void checkout(String month, String day){
		System.out.println("Click checkout searchbox");
		Common.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.checkout))).click();
		selectTime(month, day);
	}
	
	/**
	 * 
	 * @param count
	 * @return
	 */
	public WebElement getTotalAdultEl(int count){
		String totalAdults = "//option[@value='" + count + "']";
		return Common.driver.findElement(By.xpath(totalAdults));
	}
	
	/**
	 * 
	 * @param total
	 */
	public void selectAdult(String total){
		System.out.println("Click adults seachbox");
		Common.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.adultSelect))).click();
		String totalAdults = "//select[@id='adult']//option[@value='" + total + "']";
		System.out.println("Select the number of adults: " + total);
		Common.driver.findElement(By.xpath(totalAdults)).click();
	}
	
	/**
	 * 
	 * @param total
	 */
	public void selectChilds(String total){
		System.out.println("Click childs seachbox");
		Common.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.childSelect))).click();
		String totalChilds = "//select[@id='child']//option[@value='" + total + "']";
		System.out.println("Select the number of childs: " + total);
		Common.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(totalChilds))).click();
	}
	
	/**
	 * Click search button
	 */
	public void clickSearch(){
		System.out.println("Click search button");
		Common.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.searchButton))).click();
	}
		
}
