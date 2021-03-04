import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Browsercheck {

	public static void main(String[] args) throws Exception {
		
		String URLName;
		String browsername = "CH"; //CH for chrome , FF--for firfox
		WebDriver driver = null;
		
		if (browsername.equals("CH")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browsername.equals("FF")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.get("https://www.seleniumeasy.com");  //go to given link
		driver.manage().window().maximize(); //maximize page
		URLName= driver.getCurrentUrl();   
		System.out.println(URLName);    // Print current URL
		driver.findElement(By.name("search_block_form")).sendKeys("Selenium"); //byname
		driver.findElement(By.name("search_block_form")).clear();
		driver.findElement(By.linkText("Demo Website!")).click(); //by link text
		Thread.sleep(2000); 
		driver.navigate().back(); 
		//driver.findElement(By.linkText("/selenium-tutorials")).click();
		Thread.sleep(2000); 
		 Actions actions = new Actions(driver);
		 WebElement menuOption = driver.findElement(By.cssSelector("a.dropdown-toggle.active"));
		 actions.moveToElement(menuOption).perform();
		//driver.findElement(By.cssSelector("a.dropdown-toggle.active")).click();
		driver.findElement(By.linkText("/python")).click();
		//driver.close();
	
	}

}
