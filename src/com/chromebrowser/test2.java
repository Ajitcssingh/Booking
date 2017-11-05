package com.chromebrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class test2 {

	@Test
	public void testt(){
		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito");
		   System.setProperty("webdriver.chrome.driver","D:/driver/chromedriver.exe");
		   options.addArguments("--disable-extensions");
		   options.addArguments("start-maximized");
		   WebDriver driver = new ChromeDriver(options);
		   driver.get("https://ngenres.cargoflash.com/Index.cshtml");
	}
	
}
