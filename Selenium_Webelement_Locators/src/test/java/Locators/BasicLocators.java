package Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BasicLocators {
    WebDriver driver;
    @BeforeMethod
    public void BrowserSetup() {
        WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
       driver = new SafariDriver();
        driver.get("http://seleniumpractice.axone-tech.uk/index.php");

    }

    @Test(priority = 1)
    public void TestSafariLocators() throws InterruptedException {

    System.out.println(driver.getTitle());
        WebElement searchbox = driver.findElement(By.id("search_query_top"));
        searchbox.sendKeys("T-Shirts");
        Thread.sleep(1000);
        searchbox.clear();
        searchbox.sendKeys("Dress");
        Thread.sleep(1000);
        System.out.println(searchbox.getAttribute("value"));
        driver.quit();

    }
    @Test
    public void TestChromeLocators() throws InterruptedException {


        System.out.println(driver.getTitle());
        WebElement searchbox = driver.findElement(By.id("search_query_top"));
        searchbox.sendKeys("T-Shirts");
        Thread.sleep(1000);
        searchbox.clear();
        searchbox.sendKeys("Dress");
        Thread.sleep(1000);
        System.out.println(searchbox.getAttribute("value"));
        driver.quit();

    }
}