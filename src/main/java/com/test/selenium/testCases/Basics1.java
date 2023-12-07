package com.test.selenium.testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Basics1 {

public static WebDriver driver=null;
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		System.out.println("start of main method ... ");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\amuly\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.navigate().to("https://start.spring.io/");
		driver.manage().window().maximize();
		String title = driver.getTitle();

		
		System.out.println("before heading");
		
		WebElement headingElement = driver.findElement(By.xpath("//label[normalize-space()='Project']"));
        String headingText = headingElement.getText();
        System.out.println("Heading Text: " + headingText);
		
        if(title.equalsIgnoreCase(headingText)){
        	System.out.println("Title matched");
        }
		
		System.out.println("after heading");	
		
		
	}

}