package Synchronization;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class Wait {


    WebDriver driver;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://uitest.automationtester.uk/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //declaring implicit wait for are elements that using.findelements in the whole test
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }
    @Test
public void testImplicitWait(){
        driver.findElement(By.id(""));



}
@Test
public void testExplicitWait(){


}
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
