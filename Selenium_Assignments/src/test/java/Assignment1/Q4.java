package Assignment1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/*4) UsingSmartcustomisedcssselectorachievethefollowing
        a) Login to http://uitest.automationtester.uk/basic-first-form-demo.html
        b) Write your own custom css selector to click on the All Examples menu on the left hand tree structure.
         Navigate to Input Forms > Simple Form Demo
        PS: Don’t navigate directly to the URL.
        c) Navigate to “Two Input Fields” section
        d) Write a test to validate the addition operation for the given fields.*/
public class Q4 {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        //WebDriverManager.firefoxdriver().setup();
        driver = new SafariDriver();
        driver.get("http://uitest.automationtester.uk/basic-first-form-demo.html");
        //driver.manage().window().maximize();
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void testlink() throws InterruptedException {
        driver.findElement(By.xpath("//a[text()='Input Forms']")).click();
        driver.findElement(By.cssSelector("ul li ul li ul li a[href='./basic-first-form-demo.html']")).click();
        Thread.sleep(5000);

        driver.findElement(By.cssSelector("#sum1")).sendKeys("15");
        driver.findElement(By.cssSelector("#sum2")).sendKeys("20");
        Thread.sleep(5000);
         /*JavascriptExecutor js =(JavascriptExecutor)driver;
         js.executeScript("window.scrollBy(0,1000");*/

        WebElement expval = driver.findElement(By.cssSelector("button[onclick='return total()']"));
        expval.click();
        Thread.sleep(5000);

        System.out.println("Total = " +driver.findElement(By.cssSelector("#displayvalue")).getText());
        Assert.assertEquals(driver.findElement(By.cssSelector("#displayvalue")).getText(),"35");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}