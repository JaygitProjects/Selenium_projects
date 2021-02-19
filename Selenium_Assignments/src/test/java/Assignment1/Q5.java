package Assignment1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

/*5) Using Smart customised XPath select or achieve the following
        a) Login to http://uitest.automationtester.uk/basic-first-form-demo.html
        b) Write your own custom css selector to click on the All Examples menu on the left hand tree structure. Navigate to Input Forms > Checkbox Demo page
        PS: Don’t navigate directly to the URL.
        c) Navigate to “Multiple Checkbox demo” section
        d) Write a test to fetch all the values of the checkboxes and print them. Also print whether they are checked or not
        e) Write another test to try “Check All” and “Uncheck All” operations and verify the results.*/
public class Q5 {
    WebDriver driver;

    @BeforeClass
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://uitest.automationtester.uk/basic-first-form-demo.html");
        Thread.sleep(5000);
    }
    @Test
    public void testXpath() throws InterruptedException {
        //b)Navigate to Input Forms > Checkbox Demo page
        //        PS: Don’t navigate directly to the URL.
        WebElement input = driver.findElement(By.xpath("//a[text()='Input Forms']"));
        input.click();
        Thread.sleep(5000);
        //c) Navigate to “Multiple Checkbox demo” section
        WebElement checkBox = driver.findElement(By.xpath("//ul/li/ul/li/ul/li/a[@href='./basic-checkbox-demo.html']"));
        checkBox.click();
        //d)d) Write a test to fetch all the values of the checkboxes and print them. Also print whether they are checked or not
        List<WebElement> list = driver.findElements(By.xpath("//div[@id='easycont']/div/div[2]/div[2]/div[2]/div"));
        for (WebElement option : list) {
            System.out.println(option.getText()+"  "+option.isSelected());
        }
        Thread.sleep(6000);
        //e)e) Write another test to try “Check All” and “Uncheck All” operations and verify the results.*/
        WebElement checkAll =driver.findElement(By.xpath("//input[@id='check1'and @value ='Check All']"));
        checkAll.click();
        Thread.sleep(2000);
        if(checkAll.getAttribute("value").equalsIgnoreCase("Uncheck All")){
            System.out.println("All checkboxes are clicked");
        }
        driver.findElement(By.xpath("//input[@id='check1'and @value ='Uncheck All']")).click();


    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
