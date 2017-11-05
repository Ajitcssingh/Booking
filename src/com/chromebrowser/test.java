package com.chromebrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class test {
@Test
public void test22(){
	
	System.setProperty("webdriver.ie.driver","E:/SeleniumDriver/IEDriverServer.exe");
	
	WebDriver driver = new InternetExplorerDriver();
	driver.get("https://ngenres.cargoflash.com/Account/GarudaLogin.cshtml");
}
}
