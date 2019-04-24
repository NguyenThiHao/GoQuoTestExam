package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Common {
	public static WebDriver driver = new ChromeDriver();
	public static WebDriverWait wait = new WebDriverWait(driver, 20);
}
