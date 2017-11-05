package com.ReservationBooking;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class test {
	private WebDriver driver;
	@Parameters({"browser"})
	@BeforeTest
	public void openBrowser(String browser){
		if (browser.equalsIgnoreCase("chrome")) {


			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			System.setProperty("webdriver.chrome.driver","D:/driver/chromedriver.exe");
			driver = new ChromeDriver(options);

		}

		if (browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "");
			driver = new FirefoxDriver();

		}

		if (browser.equalsIgnoreCase("IE")) {

			System.setProperty("webdriver.ie.driver","E:/SeleniumDriver/IEDriverServer.exe");

			driver = new InternetExplorerDriver();

		}
		
		
		
	}

	
	@Test
	
	public void test1() throws InterruptedException, AWTException{
		
		/*//	ChromeOptions options = new ChromeOptions();
			//options.addArguments("incognito");
			
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			
			
	    System.setProperty("webdriver.chrome.driver","D:/driver/chromedriver.exe");
	   // options.addArguments("--disable-extensions");
	    //options.addArguments("start-maximized");
	    WebDriver driver = new ChromeDriver(options);*/
	    //navigate to url//
	    
		driver.get("https://ngenres.cargoflash.com/Index.cshtml");
	   // for (int i=1;i<=50;i++){
	    	
		  driver.findElement(By.xpath("//input[@id='email']")).sendKeys("ajit");
		  driver.findElement(By.xpath("//input[@id='password']")).sendKeys("cargo");
		  driver.findElement(By.xpath("//input[@id='LogInBtn']")).click();
		
		try{ 
		 Alert  alert=driver.switchTo().alert();
		 alert.accept();
		}catch(Exception e){
			
		}
		  driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		 WebElement element=driver.findElement(By.linkText("Reservation"));
		 Actions act=new Actions (driver);
		act.moveToElement(element).perform();
		Thread.sleep(3000);
		 WebElement menu=driver.findElement(By.linkText("Reservation Booking"));
		 act.click(menu).perform();
		
		 for (int i=1;i<=50;i++){
		 driver.switchTo().frame("iMasterFrame");
		 
		 
		 Thread.sleep(3000);
		 
		 driver.findElement(By.xpath("//button[text()='New Booking']")).click();
		 Thread.sleep(3000);
		 JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("window.scrollBy(0,250)","");
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//input[@id='Text_AWBDestination']")).sendKeys("sin");
	
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//span[contains(text(),'SIN-SINGAPORE')]")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//input[@id='Text_AWBAgent']")).sendKeys(("JAKARTA UAT AGENT").toString().toLowerCase());
		 
		 WebDriverWait wait= new WebDriverWait(driver,120);
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[@id='Text_AWBAgent-list']//span[text()='JAKARTA UAT AGENT']")));
		 Thread.sleep(1000);
		 driver.findElement(By.xpath(".//div[@id='Text_AWBAgent-list']//span[text()='JAKARTA UAT AGENT']")).click();
		 
	//	product add
		 driver.findElement(By.xpath("//input[@id='Text_Product']")).sendKeys("gen");
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//span[text()='GENERAL']")).click();
	
		Thread.sleep(5000);
		 driver.findElement(By.xpath("//input[@id='_tempAWBPieces']")).sendKeys("10");
		
		Thread.sleep(5000);
		js.executeScript("document.getElementById('AWBGrossWeight').value= '5';");
		
		
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("//input[@id='_tempAWBCBM']")).sendKeys("0.5");
	driver.switchTo().defaultContent();	
	driver.switchTo().frame("iMasterFrame");
	
	driver.findElement(By.id("AddDimension")).click();
	Thread.sleep(2000);
	//Length 
	driver.findElement(By.id("_temptblDimensionTab_Length_1")).sendKeys("11");
	//width
	Thread.sleep(2000);
	driver.findElement(By.id("_temptblDimensionTab_Width_1")).sendKeys("22");
	//height
	Thread.sleep(2000);
	driver.findElement(By.id("_temptblDimensionTab_Height_1")).sendKeys("11");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[text()='Update All']")).click();
	//back to reservation
	Thread.sleep(3000);
	driver.findElement(By.id("btnBackToReservation")).click();
	Thread.sleep(2000);
	js.executeScript("window.scrollBy(0,1000)","");
	
	driver.findElement(By.xpath(" .//input[@id='Text_Commodity']//following::span[2]")).click();
	driver.switchTo().defaultContent();
	driver.switchTo().frame("iMasterFrame");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//div[@id='Text_Commodity-list']/ul/li/span")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@id='NatureOfGoods']")).sendKeys("Fruits");
	Thread.sleep(2000);
	//shipper accunt 
	driver.findElement(By.id("Text_SHIPPER_AccountNo")).sendKeys("160");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[text()='SHIJKT160-UAT']")).click();
	//shipper 
	Thread.sleep(2000);
	driver.findElement(By.id("Text_CONSIGNEE_AccountNo")).sendKeys("28");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[text()='CONSIN128-SALEH']")).click();
	Robot robot =new Robot ();
	robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	driver.findElement(By.xpath("//input[@id='Text_ItineraryFlightNo']")).sendKeys("6300");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[text()='GA-6300   ']")).click();
	Thread.sleep(2000);
	
	
	
	Thread.sleep(3000);
	driver.findElement(By.xpath(".//input[@id='ItinerarySearch']")).click();
	Thread.sleep(3000);
	
	js.executeScript("window.scrollBy(0,1000)","");
	
	//Select flight//
	Thread.sleep(3000);
	JavascriptExecutor js1=((JavascriptExecutor)driver);
	js1.executeScript("window.scrollBy(500,0)","");
	//click on the flight//
	driver.findElement(By.xpath("//table[@id='tblFlightSearchResult']/tbody/tr[1]/td[15]/button/span[text()='Select']")).click();
	
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@id='btnSave']")).click();
	
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//div[3]/table/tbody/tr[1]/td[25]/input[@title='EXECUTE']")).click();
Thread.sleep(2000);

driver.findElement(By.id("btnExecute")).click();


 driver.switchTo().defaultContent();
	
//	 Thread.sleep(2000);
//	       driver.findElement(By.xpath("//a[@id='logout']/img")).click();
}}
	
}