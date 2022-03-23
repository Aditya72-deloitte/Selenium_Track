package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\adityakumar72\\Documents\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        launch(driver);
        String parentWindow = driver.getWindowHandle();
        String homeTitle = driver.getTitle();
        
        checktitle_home(driver,homeTitle);
        WebElement login = driver.findElement(By.xpath("/html/body/header/div/nav/a[4]"));
        login.click();
        String loginTitle = driver.getTitle();

        driver.navigate().to("https://phptravels.org/login");

        checktitle_login(driver,loginTitle);


        driver.switchTo().window(parentWindow);
        driver.navigate().to("https://phptravels.com/demo");

        System.out.println(driver.getCurrentUrl());

        WebElement pricing = driver.findElement(By.xpath("/html/body/header/div/nav/a[2]"));
        pricing.click();
        Thread.sleep(3000);

        driver.navigate().back();

        Thread.sleep(10000);

        driver.navigate().refresh();

        driver.quit();
    }

    static void checktitle_login(WebDriver driver, String loginTitle) {
        String expectedTitle = "PHPTRAVELS";
        if(expectedTitle.contains(loginTitle)){
            System.out.println("Pass");
        }
        else System.out.println("Fail");

    }

    static void launch(WebDriver driver) {
        driver.get("https://phptravels.com/demo");
        driver.manage().window().maximize();
    }
    static void checktitle_home(WebDriver driver, String homeTitle) {
        String expectedTitle = "PHPTRAVELS";
        if(homeTitle.contains(expectedTitle)){
            System.out.println("Pass");
        }
        else System.out.println("Fail");
    }

}
