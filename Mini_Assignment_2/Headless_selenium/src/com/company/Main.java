package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\adityakumar72\\Documents\\chromedriver.exe");
        WebDriver driver;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("Headless");
        driver = new ChromeDriver(options);

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

        driver.navigate().back();

        driver.navigate().refresh();

        driver.quit();
    }

    //For Verifying Title of Login page
    static void checktitle_login(WebDriver driver, String loginTitle) {
        String expectedTitle = "PHPTRAVELS";
        if(expectedTitle.contains(loginTitle)){
            System.out.println("Pass");
        }
        else System.out.println("Fail");
    }

    //For launching the test
    static void launch(WebDriver driver) {
        driver.get("https://phptravels.com/demo");
        driver.manage().window().maximize();
    }

    //For Verifying Title of homepage
    static void checktitle_home(WebDriver driver, String homeTitle) {
        String expectedTitle = "PHPTRAVELS";
        if(homeTitle.contains(expectedTitle)){
            System.out.println("Pass");
        }
        else System.out.println("Fail");
    }
}
