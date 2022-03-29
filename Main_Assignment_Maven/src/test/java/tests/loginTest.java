package tests;

import Pages.loginPages;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class loginTest extends loginPages{

    @Test(priority = 8)
    public static void Withdrawn() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[3]/button[3]")).click();
        String leftAmount = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/strong[2]")).getText();
        System.out.println(leftAmount);
        String amountTobewithdrawn = "1000";
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input")).sendKeys(amountTobewithdrawn);
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/button")).click();
        String finalAmount = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/strong[2]")).getText();
        System.out.println(finalAmount);
        if(Integer.parseInt(amountTobewithdrawn) - Integer.parseInt(leftAmount) == Integer.parseInt(finalAmount)){
            System.out.println("Withdraw Verified");
        }
        else System.out.println("Withdraw Not Verified");
    }

    @Test(priority = 7)
    public static void deposit(){
        String availableAmount = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/strong[2]")).getText();
        System.out.println(availableAmount);
        String amountTobeDeposited = "1000";
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[3]/button[2]")).click();
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input")).sendKeys(amountTobeDeposited);
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/button")).click();
        String finalAmount = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/strong[2]")).getText();
        System.out.println(finalAmount);
        if(Integer.parseInt(finalAmount) - Integer.parseInt(availableAmount) == Integer.parseInt(amountTobeDeposited)){
            System.out.println("Verified");
        }
        else System.out.println("Not Verified");


    }

    @Test(priority = 6)
    public static void customerLogin(){
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/div[1]/button")).click();
        Select name= new Select(driver.findElement(By.xpath("//*[@id='userSelect']")));
        name.selectByVisibleText("priyank verma");
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/form/button")).click();
    }

    @Test(priority = 5)
    public static void Homepage(){
        driver.findElement(By.xpath("/html/body/div/div/div[1]/button[1]")).click();
    }

    @Test(priority = 4)
    public static void nameFind(){
        Select name= new Select(driver.findElement(By.xpath("//*[@id='userSelect']")));
        name.selectByVisibleText("priyank verma");
        Select currency= new Select(driver.findElement(By.xpath("//*[@id='currency']")));
        currency.selectByVisibleText("Rupee");
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button")).click();
        driver.switchTo().alert().accept();
    }

    @Test(priority = 3)
    public static void openAccount(){
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[2]")).click();
        driver.findElement(By.xpath("//*[@id='userSelect']")).click();
    }

    @Test(priority = 2)
    public static void addCustomer() throws NoSuchWindowException {
        try {
            //driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/div[2]/button")).click();

            driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[1]")).click();

            driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[1]/input")).sendKeys("priyank");

            driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[2]/input")).sendKeys("verma");

            driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[3]/input")).sendKeys("123456");

            driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button")).click();

            driver.switchTo().alert().accept();
        } catch (Exception e) {
            System.out.println("No window found");
        }
    }
    @Test(priority = 1)
    public static void managerLogin() throws NoSuchWindowException{
        try {
            WebElement m = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/div[2]/button"));
            m.click();
        }
        catch (Exception e){
            System.out.println("Element not found");
        }
    }
}
