package Assignment1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*3) UsingSmartcustomisedXPathachievethefollowing
        a) Login to https://www.zoho.eu/
        b) Write your own custom XPath to click on the Login link on the top right hand corner
        c) Type random email address into the “Email address” field
        d) Using appropriate methods fetch the above typed value of the email address*/
public class Q3 {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.zoho.eu/");
    }
@Test
    public void  testZoho() throws InterruptedException {
        driver.findElement(By.xpath("//a[@class='zh-login']")).click();
        Thread.sleep(2000);
        WebElement email= driver.findElement(By.xpath(" //input[@id='login_id']"));
        email.sendKeys("jayanthirsundar@gmail.com");
        Thread.sleep(2000);
        System.out.println("Email Address : " +email.getAttribute("value"));

}
    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
