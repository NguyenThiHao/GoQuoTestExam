package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
/**
 * Function of Available Page
 * @author HAO
 *
 */
public class AvailablePage {	
	private String typeTicket = "//span[contains(text(), 'Loại vé')]//b";
	private String totalPassengers = "//span[contains(text(), 'Số hành khách')]//b";
	private String checkin = "//span[contains(text(), 'Ngày xuất phát')]";
	private String checkout = "//span[contains(text(), 'Ngày về')]";
	private String expectedTitle = "Tìm vé trực tuyến | Công Ty TNHH PN Việt Nam";
	private String departCity = "//p[@id='deplocation']//span[1]";
	private String returnCity = "//p[@id='deplocation']//span[2]";
	
	/**
	 * Verify Available page opens or not
	 */
	public void verifyAvailablePageOpens(){
		System.out.println("Get title of webpage");
		String title = Common.driver.getTitle();
		System.out.println("Compare title of webpage with expected: 'Tìm vé trực tuyến | Công Ty TNHH PN Việt Nam'");
		Assert.assertEquals(title,this.expectedTitle);
	}
	
	/**
	 * Verify Type of ticket is Khứ hồi
	 */
	public boolean verifyTypeTicket(){
		System.out.println("Verify typw ticket: Khứ hồi");
		String text = Common.driver.findElement(By.xpath(this.typeTicket)).getText();
		return text.equals("Khứ hồi");
	}
	
	public String getTextTotalPassegers(){
		System.out.println("Get text total passengers");
		String text = Common.driver.findElement(By.xpath(this.totalPassengers)).getText();
		return text;
	}
	
	public boolean verifyAdults(String adults){
		String stringCompareAdults = adults + " Người lớn" ;
		return getTextTotalPassegers().contains(stringCompareAdults);
	}
	
	public boolean verifyChilds(String childs){
		String stringCompareAdults = childs + " Trẻ em" ;
		return getTextTotalPassegers().contains(stringCompareAdults);
	}
	
	public void verifyTotalPassengers(String adults, String childs){
		Assert.assertEquals(verifyAdults(adults), true);
		Assert.assertEquals(verifyChilds(childs), true);
	}

	public String getCheckin(){
		System.out.println("Get text checkin");
		String checkin = Common.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.checkin))).getText();
		return checkin;
	}
	
	public String getCheckout(){
		System.out.println("Get text checkout");
		String checkin = Common.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.checkout))).getText();
		return checkin;
	}
	
	/**
	 * 
	 * @param month
	 * @param day
	 * @return
	 */
	public String stringDate(String month, String day){
		String stringConvert = null;
		if(Integer.parseInt(month) <10 ){
			month = "0" + month;
		}
		if(Integer.parseInt(day) <10){
			day = "0" + day;
		}
		stringConvert = day +"-" + month;
		return stringConvert;
	}
	
	/**
	 * Verify checkin displayed correct or not
	 * @param month
	 * @param day
	 * @return boolean
	 */
	public boolean verifyCheckin(String month, String day){
		String stringConvert = stringDate(month, day);
		System.out.println(stringConvert);
		System.out.println("Verify checkin displayed correct or not");
		System.out.println(getCheckin());
		return getCheckin().contains(stringConvert);
	}
	
	/**
	 * Verify Checkout displayed correct or not
	 * @param month
	 * @param day
	 * @return boolean
	 */
	public boolean verifyCheckout(String month, String day){
		String stringConvert = stringDate(month, day);
		System.out.println("Verify checkout displayed correct or not");
		return getCheckout().contains(stringConvert);
	}
	
	/**
	 * Verify checkin is selected
	 * @param month: month checkin
	 * @param day day checkin
	 */
	public void verifyCheckinIsSelectDate(String month, String day){
		String stringDate = stringDate(month, day).replace("-", "/");
		String strXpath = "//li[contains(@day, '" + stringDate + "')]";
		System.out.println("Verify Checkin is selectdate or not");
		String attribute = Common.driver.findElement(By.xpath(strXpath)).getAttribute("class");
		Assert.assertEquals(attribute, "selectdate");
	}
	
	/**
	 * Verify Depart City
	 * @param departCity
	 */
	public boolean verifyDepartCity(String departCity){
		String departCityFullText = Common.driver.findElement(By.xpath(this.departCity)).getText();
		return departCityFullText.contains(departCity);
	}
	
	/**
	 * Verify Return City
	 * @param returnCity
	 */
	public boolean verifyReturnCity(String returnCity){
		String returnCityFullText = Common.driver.findElement(By.xpath(this.returnCity)).getText();
		return returnCityFullText.contains(returnCity);
	}
	
	/**
	 * Verify location displayed correct or not
	 * @param departCity
	 * @param returnCity
	 */
	public void verifyLocation(String departCity, String returnCity){
		Assert.assertEquals(verifyDepartCity(departCity), true);
		Assert.assertEquals(verifyReturnCity(returnCity), true);
	}
}
