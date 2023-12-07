package com.test.selenium.testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class W3schoolsLogin {

public static WebDriver driver=null;
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		System.out.println("start of main method ... ");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\amuly\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.navigate().to("https://profile.w3schools.com/log-in");
//		driver.manage().window().maximize();
		String title = driver.getTitle();
		
		System.out.println("before heading");
		
		WebElement headingElement = driver.findElement(By.xpath("//h1[normalize-space()='Log in']"));
        String headingText = headingElement.getText();
//        System.out.println("Heading Text: " + headingText);
		
        if(headingText.equalsIgnoreCase("Log in")){
        	System.out.println("Title matched .... correct page opened");
        }
        else {
        	System.out.println("title not matched.");
        }
//		
		System.out.println("after heading");	
		
		
		WebElement usernameInput= driver.findElement(By.id("modalusername"));
		WebElement passwordInput= driver.findElement(By.id("current-password"));
		WebElement loginBtn= driver.findElement(By.className("LoginModal_cta_bottom_box_button_login__5Fbwv"));
		
		// <div class="LoginModal_cta_bottom_box_button_login__5Fbwv"><button class="Button_button__URNp+ Button_primary__d2Jt3 Button_fullwidth__0HLEu" xpath="1" style=""><span>Log in</span></button></div>
		
		System.out.println("buttons fetched !");
		
		usernameInput.sendKeys("amulya.kumar@bonamisoftware.com");
		passwordInput.sendKeys("Idkk@123");		
		System.out.println("cred sent!");
		
		loginBtn.click();
		
		System.out.println("logged in successfully.");
		
		try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		
		
		driver.navigate().to("https://my-learning.w3schools.com/");
		String titleNew = driver.getTitle();
		WebElement headingElementNew = driver.findElement(By.xpath("//div[@class='MainHeader_mainHeaderTitle__14sVT']"));
        String headingTextNew = headingElementNew.getText();
        
        System.out.println("headingTextNew : " + headingTextNew);
		
        if(headingTextNew.equalsIgnoreCase("My learning")){
        	System.out.println("Title matched");
        }
        else {
        	System.out.println("Not logged in");
        }
        
        driver.quit();
        
        System.out.println("closed the driver.");
	}
}
