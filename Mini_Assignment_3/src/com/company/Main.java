package com.company;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {
	// write your code here
        System.setProperty("webdriver.chrome.driver","C:\\Users\\adityakumar72\\IdeaProjects\\Mini_Assignment_3\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://the-internet.herokuapp.com/");
        String hikoruApp_url = driver.getCurrentUrl();
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='content']/iframe")));
        Actions act = new Actions(driver);
        int size = driver.findElements(By.tagName("iframe")).size();

        //new WebDriverWait(driver, 20).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("demo-frame")));
        driver.switchTo().frame(0);
        System.out.println(size);
        WebElement src = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement des = driver.findElement(By.xpath("//div[@id='droppable']"));
        act.clickAndHold(src).moveToElement(des).release().build().perform();

        driver.navigate().to(hikoruApp_url);
        js.executeScript("window.scrollBy(0,350)", "");
        WebElement javaScriptAlerts = driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[29]/a"));
        javaScriptAlerts.click();
        WebElement jsPromptButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button"));
        jsPromptButton.click();

        String expected = "Ex-Test";
        driver.switchTo().alert().sendKeys("Ex-Test");
        driver.switchTo().alert().accept();
        String actual = driver.findElement(By.xpath("//*[@id=\"result\"]")).getText();
        System.out.println(actual);
        if(actual.contains(expected)){
            System.out.println("Pass");
        }else System.out.println("Fail");

        driver.get("https://www.goibibo.com/");
        WebElement roundTrip = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/ul/li[2]"));
        roundTrip.click();
        WebElement from1 = driver.findElement(By.xpath("//p[@class='sc-iJKOTD iipKRx fswWidgetPlaceholder']"));
        act.moveToElement(from1).doubleClick().perform();
        WebElement fromTxt = driver.findElement(By.xpath("//input[@type='text']"));
        fromTxt.sendKeys("New York");
        driver.findElement(By.xpath("//*[@id=\"autoSuggest-list\"]/li[1]/div")).click();

//      For Destination
        WebElement des1 = driver.findElement(By.xpath("//p[@class='sc-iJKOTD iipKRx fswWidgetPlaceholder']"));
        act.moveToElement(des1).doubleClick().perform();
        WebElement desTxt = driver.findElement(By.xpath("//input[@type='text']"));
        desTxt.sendKeys("Seattle");
        driver.findElement(By.xpath("//div[@Class='sc-iAKWXU iyyKqe']")).click();

//      For Dates
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div[3]/div[2]/div[2]/div/div/div[1]/span[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div[3]/div[2]/div[2]/div/div/div[1]/span[2]")).click();
//        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div[3]/div[2]/div[2]/div/div/div[1]/span[2]")).click();
////        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div[3]/div[2]/div[2]/div/div/div[1]/span[2]")).click();
            driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div[3]/div[2]/div[2]/div/div/div[2]/div[2]/div[3]/div[4]/div[6]")).click();
//        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div[3]/div[2]/div[2]/div/div/div[1]/span[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div[3]/div[2]/div[1]/div[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div[3]/div[2]/div[2]/div/div/div[1]/span[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div[3]/div[2]/div[2]/div/div/div[2]/div[2]/div[3]/div[2]/div[6]")).click();

        js.executeScript("window.scrollBy(0,250)", "");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div[3]/div[2]/div[3]/span[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div[5]/div[2]/div[3]/a[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[3]/span")).click();

        TakesScreenshot ts = (TakesScreenshot) driver;
        File src1 = ts.getScreenshotAs(OutputType.FILE);
        File des2 = new File(System.getProperty("user.dir")+"/FailedScreenShots/"+"sample.jpg");
        FileHandler.copy(src1,des2);


        Thread.sleep(2000);
        driver.quit();
    }
}
