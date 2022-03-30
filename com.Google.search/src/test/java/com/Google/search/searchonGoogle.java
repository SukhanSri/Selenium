package com.Google.search;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;



import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class searchonGoogle {
	WebDriver driver;
@BeforeClass
public void setUP() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.get("https://www.google.com/");
}
@Test
public void searchPrdt() throws InterruptedException, AWTException {
	driver.findElement(By.cssSelector("input.gLFyf.gsfi")).sendKeys("Laptop");
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//span[text()='laptop'])[3]")).click();
	JavascriptExecutor js = (JavascriptExecutor)driver;
	WebElement ele = driver.findElement(By.xpath("//a[@aria-label='Page 2']"));
	js.executeScript("arguments[0].scrollIntoView(true)",ele);
	WebDriverWait wait = new WebDriverWait (driver, 15);
	wait.until(ExpectedConditions.elementToBeClickable(ele));
	ele.click();
	WebElement Page3ele = driver.findElement(By.xpath("//a[@aria-label='Page 3']"));
	Actions action = new Actions(driver);
	action.contextClick(Page3ele).build().perform();
	Robot robot = new Robot();
	robot.keyPress(KeyEvent.VK_DOWN);
	robot.keyPress(KeyEvent.VK_ENTER);
	String parentwindow = driver.getWindowHandle();
	System.out.println(parentwindow);
	driver.findElement(By.xpath("(//a[@href='https://slickdeals.net/laptop-deals/'])[1]")).click();
//	Set<String> windowhandles = driver.getWindowHandles();
//	Iterator<String> itr = windowhandles.iterator();
//	while(itr.hasNext()) {
//		Thread.sleep(2000);
//		System.out.println(itr.next());
//		driver.switchTo().window(itr.next());
//		Thread.sleep(2000);
//		while(!parentwindow.equals(itr.next())) {
//		//	driver.findElement(By.xpath("(//a[@href='https://slickdeals.net/laptop-deals/'])[1]")).click();
//			System.out.println("Im here");
//			Thread.sleep(2000);
//		}
//		driver.switchTo().window(parentwindow)	;
	}
}


