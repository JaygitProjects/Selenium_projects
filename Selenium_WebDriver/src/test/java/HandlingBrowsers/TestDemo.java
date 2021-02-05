package HandlingBrowsers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestDemo {
    @Test
    public void  testWebElement() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Applications/Software/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://amazon.co.uk");
        Thread.sleep(5000);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("bag");
        Thread.sleep(5000);

        driver.findElement(By.id("nav-search-submit-button")).click();
        Thread.sleep(5000);
        driver.manage().window().maximize();

        driver.navigate().to("http://amazon.in");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("bag");
        driver.findElement(By.id("nav-search-submit-button")).click();
        Thread.sleep(5000);
        driver.navigate().back();
        Thread.sleep(5000);
        driver.quit();


    }
}
