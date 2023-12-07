package com.test.selenium.testCases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLogin {

	public static WebDriver driver=null;
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		System.out.println("start of main method ... ");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\amuly\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.navigate().to("https://demo.guru99.com/test/login.html#");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		
		System.out.println("before heading");
		
		WebElement headingElement = driver.findElement(By.xpath("//h3[normalize-space()='Already registered?']"));
        String headingText = headingElement.getText();
//        System.out.println("Heading Text: " + headingText);
		
        if(headingText.equalsIgnoreCase("Already registered?")){
        	System.out.println("Title matched");
        }
        else {
        	System.out.println("Not logged in");
        }
		
		System.out.println("after heading");	
		
		
		WebElement usernameInput= driver.findElement(By.id("email"));
		WebElement passwordInput= driver.findElement(By.id("passwd"));
		WebElement loginBtn= driver.findElement(By.className("submit"));
		
		System.out.println("buttons fetched !");
		
		usernameInput.sendKeys("amulya.kumar@bonamisoftware.com");
		passwordInput.sendKeys("idk@123");		
		System.out.println("cred sent!");
		
		loginBtn.click();
		
		System.out.println("logged in successfully.");
		
		try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();
        
        System.out.println("closed the driver.");

	}

}
