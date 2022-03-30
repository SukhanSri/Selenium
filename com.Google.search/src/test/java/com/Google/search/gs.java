package com.Google.search;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class gs {
	
	

	WebDriver driver;
	@Test
	public void googlesearch() throws InterruptedException, AWTException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.findElement(By.cssSelector("input.gLFyf.gsfi")).sendKeys("laptop");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='wM6W7d']/span[text()='laptop'])[2]")).click();
		WebElement waitelement = driver.findElement(By.xpath("(//div[@class='TbwUpd NJjxre'])[2]"));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(waitelement ));
		WebElement Nextpageclickele = driver.findElement(By.xpath("//a[@aria-label='Page 2']"));
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",Nextpageclickele);
		Nextpageclickele.click();
		js.executeScript("return document.readyState").equals("complete");
		Thread.sleep(2000);
		WebElement thpageelement = driver.findElement(By.xpath("//a[@aria-label='Page 3']"));
		js.executeScript("arguments[0].scrollIntoView(true)",thpageelement);
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.contextClick(thpageelement).build().perform();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		String parentwindowhandle = driver.getWindowHandle();
		Set<String> windowhandles = driver.getWindowHandles();
		Iterator<String> itr = windowhandles.iterator();
		while(itr.hasNext()){
		String thiswindow = itr.next();
		if(!thiswindow.equals(parentwindowhandle)){
		driver.switchTo().window(thiswindow);
		driver.findElement(By.xpath("(//h3[@class='LC20lb MBeuO DKV0Md'])[2]"));
		driver.switchTo().window(parentwindowhandle);

		}









		}



	}
}
