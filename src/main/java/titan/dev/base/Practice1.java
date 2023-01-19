package titan.dev.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import titan.dev.util.Utilities;


import java.util.List;

public class Practice1 {
    public static WebDriver driver;

    public static void Test() {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/inventory.html");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();


        List<WebElement> priceList = driver.findElements(By.className("inventory_item_price"));

        double largest = 0;

        for (WebElement e : priceList) {
            double price = Double.parseDouble(e.getText().replace("$", ""));
            if (largest < price) {
                largest = price;
            }
        }
        System.out.println(largest);

        String xpath_max = "//div[normalize-space()='$" + largest + "']/following-sibling::button[text()='Add to cart']";
        driver.findElement(By.xpath(xpath_max)).click();
        System.out.println("SuccessFully Clicked");


    }


    @Test

        public static void Test123() {

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://semantic-ui.com/modules/dropdown.html");

        //WebElement a= driver.findElement(By.xpath(""));
        Select s= new Select(driver.findElement(By.xpath("//div[@class='ui dropdown selection']//div[@class='default text'][normalize-space()='Gender']")));

        List<WebElement> all= s.getOptions();
        for(WebElement e: all){
        System.out.print(e.getText());}
    }

}




