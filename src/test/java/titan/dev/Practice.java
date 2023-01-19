package titan.dev;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import titan.dev.base.Practice1;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;


public class Practice extends Practice1 {

    @Test(enabled=false)
    public void MaxProductPriceTest()  {
        Test();
    }

    @Test(enabled=true)
    public void GoogleSearchTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();

        driver.findElement(By.name("q")).sendKeys("Testing");

        Thread.sleep(2000);
        List<WebElement> lst = driver.findElements(By.xpath("//ul[@role='listbox']//li"));
        System.out.println(lst.size());

        for (int i=0;i<lst.size();i++) {
            if(lst.get(i).getText().equalsIgnoreCase("Testing")){
                    lst.get(i).click();
                    System.out.println("clicked");
                    break;
        }
            else {
                System.out.println("Not found");
            }
    }}

    @Test(enabled = true, description = "Broken Links")
    public void checkBrokenLinks() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver=new ChromeDriver(options);
        driver.get("https://www.justdial.com/");
        driver.manage().window().maximize();

        int responseCode;
        int brokenLinkCount = 0;

        List<WebElement> lst=driver.findElements(By.tagName("a"));
        System.out.println(lst.size());

        for(WebElement ele:lst){
            String url= ele.getAttribute("href");


            try {
                URL u= new URL(url);
                HttpURLConnection hc= (HttpURLConnection) u.openConnection();
                Thread.sleep(2000);
                hc.connect();

                responseCode=hc.getResponseCode();

                if(responseCode>=400){
                    System.out.println("broken link:  " +url);
                    brokenLinkCount++;
                }
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);

            } catch (ProtocolException e) {
                throw new RuntimeException(e);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }System.out.println(" Broken link count" +brokenLinkCount);


    }

    //Code to highlight elements
    //JavascriptExectuor
    //jse.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red')", searchBox);
}
