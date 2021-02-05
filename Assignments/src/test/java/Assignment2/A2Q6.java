package Assignment2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/*6) Automate the following
        a) Visit http://uitest.automationtester.uk/bootstrap-download-progress-demo.html
        b) Implement a suitable synchronization technique
        to check the download progress percentage and verify until 100% is shown.*/
public class A2Q6 {
    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://uitest.automationtester.uk/bootstrap-download-progress-demo.html");
        driver.manage().window().maximize();

    }
    @Test
    public void testSync() throws InterruptedException {

        WebElement download = driver.findElement(By.xpath("//button[@id='cricle-btn']"));
        Thread.sleep(2000);
        download.click();

        //waiting until 100% is shown
        WebDriverWait wait = new WebDriverWait(driver,40);
        WebElement percent = driver.findElement(By.xpath("//div[contains(text(),'0%')]"));

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'100%')]")));

    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
 