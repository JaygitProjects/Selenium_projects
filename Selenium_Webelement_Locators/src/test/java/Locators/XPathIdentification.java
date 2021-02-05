package Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;

public class XPathIdentification {
    WebDriver driver;
    @BeforeTest
    public void setBrowser() throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
       driver = new SafariDriver();
        driver.get("http://seleniumpractice.axone-tech.uk/index.php");
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }
    @Test
    public void TestXPath(){
        //using absolute
        System.out.println("From Absolute Path : "+driver.findElement(By.xpath("html/body/div/div/header/div[3]/div/div/div/a/img")).getAttribute("src"));
        //Using relativePAth
        System.out.println("From Relative Path : "+ driver.findElement(By.xpath("//img[@class='logo img-responsive']")).getAttribute("src"));

    }
    @Test
    public void testDemo() throws InterruptedException {

        driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[1]/a/img"));//absolute xpath
        driver.findElement(By.xpath("//*[@id=\"header_logo\"]/a/img"));//relative xpath
      // WebElement searchbox = driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys("dress");
        driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys("dress");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@name='submit_search']")).click();

        //driver.findElement(By.xpath("//input[@name='search_query'or @id='search_query_top']")).sendKeys("TShirt");//using or operator
        //driver.findElement(By.xpath("//input[@name='search_query'and @id='search_query_top']")).sendKeys("TShirt");//using and operator
       // driver.findElement(By.xpath("//input[//button[@name='submit_search']']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[contains(@id,'query')]")).sendKeys("shirt");//contains function
        driver.findElement(By.xpath("//button[starts-with(@name,'submit_')]")).click();//start-swith function
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text()='Women']")).click();//text() function
        Thread.sleep(2000);
        driver.findElement(By.xpath("//form[@id='searchbox']//input[4]")).sendKeys("men");//chained xpath using index or
        driver.findElement(By.xpath("//form[@id='searchbox']//button[@name='submit_search']")).click();//chained xpath using attribute
        Thread.sleep(5000);

    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
