package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.sql.Driver;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	// write your code here
        System.setProperty("webdriver.chrome.driver","C:\\Users\\adityakumar72\\IdeaProjects\\Mini_Assignment_3\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        WebElement frames = driver.findElement(By.xpath("/html/body/div[2]/div/ul/li[22]/a"));
        frames.click();
        Thread.sleep(2000);
        WebElement nestedFrames = driver.findElement(By.xpath("/html/body/div[2]/div/div/ul/li[1]/a"));
        nestedFrames.click();

        driver.switchTo().frame("frame-top");
        System.out.println("Frame top found");
        //driver.switchTo().frame("frameset-middle");
        driver.switchTo().frame("frame-left");
        System.out.println("Frame left found");
        String leftFrameData = (driver.findElement(By.xpath("/html/body")).getText());
        System.out.println(leftFrameData);

        driver.get("https://jqueryui.com/droppable");
        Thread.sleep(5000);
        Actions act = new Actions(driver);
        //driver.switchTo().frame("//*[@id='content']/iframe");

        WebElement src = (WebElement) driver.findElements(By.xpath("//div[@id=\'draggable\']"));
        WebElement des = (WebElement) driver.findElements(By.xpath("//div[@id=\'droppable\']"));
        act.clickAndHold(src).moveToElement(des).release().build().perform();



        Thread.sleep(2000);
        driver.quit();
    }
}
