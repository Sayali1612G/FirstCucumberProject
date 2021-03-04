import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.sun.tools.javac.code.Attribute.Array;

public class Cartcheck {

	public static void main(String[] args) throws InterruptedException  {
		// TODO Auto-generated method stub
		
		String URLName;
		String browsername = "CH"; //CH for chrome , FF--for firefox
		WebDriver driver = null;
		
		if (browsername.equals("CH")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
				}
		else if (browsername.equals("FF")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
				}
		
		WebDriverWait w =new WebDriverWait(driver,5);
		
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //Implicit wait
		int j=0;
		String[] itemsNeeded={"Cucumber", "Brocolli", "Beetroot"}; //array
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");  //go to given link
		driver.manage().window().maximize(); //maximize page
		Thread.sleep(5000);
		List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));
		for(int i=0;i<products.size();i++)
		{
			String[] name=products.get(i).getText().split("-");
		    String formattedName =  name[0].trim();
			//trim the text			
			//convert array into array list
			List itemsNeededList= Arrays.asList(itemsNeeded);
			
			if(itemsNeededList.contains(formattedName)) 
			//add to cart
			{
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(j==3)
				{
					break;
					}
				}
			}

		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		//Thread.sleep(3000);
		//apply explicit wait
		//define
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
 	    System.out.print(driver.findElement(By.cssSelector("span.promoInfo")).getText());
 	    
 	    driver.quit();
			}
		}
