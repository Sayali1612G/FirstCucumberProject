import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actionsframes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver ;
		System.setProperty("Webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        Actions a =  new Actions(driver);
        a.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();
        
	}

}
