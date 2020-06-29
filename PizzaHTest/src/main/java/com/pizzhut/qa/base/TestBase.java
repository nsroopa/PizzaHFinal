package com.pizzhut.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.pizzhut.qa.util.TestUtil;
import com.pizzhut.qa.util.WebEventListener;

public class TestBase {

public static WebDriver driver;
public static Properties prop;
public  static EventFiringWebDriver e_driver;


public static WebEventListener eventListener;
//public static WebEventListener eventListener;

public TestBase(){
	try {
		prop = new Properties();
<<<<<<< HEAD
		FileInputStream ip = new FileInputStream( "C:\\Users\\virad\\git\\PizzaHFinal\\1\\PizzaHTest\\src\\main\\java\\com\\pizzahut\\qa\\configuration\\config.properties");
=======
		FileInputStream ip = new FileInputStream( "C:\\Users\\moizr\\git\\PizzaHFinal\\PizzaHTest\\src\\main\\java\\com\\pizzahut\\qa\\configuration\\config.properties");


>>>>>>> branch 'master' of https://github.com/Rohela15/PizzaHFinal.git
		prop.load(ip);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
}


public static void initialization(){
	String browserName = prop.getProperty("browser");
	
	if(browserName.equals("chrome")){
<<<<<<< HEAD
		System.setProperty("webdriver.chrome.driver", "C:\\QA\\drivers\\chromedriver.exe");	
		driver = new ChromeDriver();; 
=======

		System.setProperty("webdriver.chrome.driver", "C:\\driver2\\chromedriver.exe");	

		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");	

		driver = new ChromeDriver(); 
>>>>>>> branch 'master' of https://github.com/Rohela15/PizzaHFinal.git
	}
	else if(browserName.equals("FF")){
		System.setProperty("webdriver.gecko.driver", "C:\\QA\\drivers\\geckodriver.exe");	
		driver = new FirefoxDriver(); 
	}
	
	e_driver = new EventFiringWebDriver(driver);
	// Now create object of EventListerHandler to register it with EventFiringWebDriver
	eventListener = new WebEventListener();
	e_driver.register(eventListener);
	driver = e_driver;
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PLT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.IMP_wait , TimeUnit.SECONDS);
	
	driver.get(prop.getProperty("url"));
	
}









}