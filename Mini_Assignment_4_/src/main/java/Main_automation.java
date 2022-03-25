import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleToLongFunction;

public class Main_automation{
    void automate(List<String> userDetail){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\adityakumar72\\IdeaProjects\\Mini_Assignment_3\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "https://www.saucedemo.com/";
        driver.get(url);
        driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(userDetail[0]);
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(userDetail[1]);
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

        List<WebElement> all_price = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        List<Double> allconvertprice = new ArrayList<>();
        for(int i = 0 ; i < all_price.size();i++){
            String element_price = all_price.get(i).getText();
            String price_without_dollar = element_price.substring(1);
            Double element_convert_price = Double.parseDouble(price_without_dollar);
            allconvertprice.add(element_convert_price);
        }
        double max = Double.MAX_VALUE;
        for (double elem: allconvertprice) {
            max = Math.max(max,elem);
        }
        System.out.println(max);
        double hundred = 100.00;
        if(max<hundred){
            System.out.println("The item is less than $100");
        }
        else System.out.println("The item is more than $100");
    }
}
