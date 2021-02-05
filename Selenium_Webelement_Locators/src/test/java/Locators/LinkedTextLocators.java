package Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinkedTextLocators {
    WebDriver driver;

    @BeforeMethod
    public void BrowserSetup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://www.bbc.co.uk/");

    }
    @Test
    public void testLinkText() throws InterruptedException {
     // driver.findElement(By.linkText("Weather")).click();

      driver.findElement(By.partialLinkText("virus")).click();
      Thread.sleep(5000);
      driver.quit();
    }
}
