package Assignment2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/*3) Automate the following scenario
        a) Visit http://the-internet.herokuapp.com/horizontal_slider
        b) Implement a test to handle dragging the slider to a value say ‘4’ and verify the results.*/
public class A2Q3 {
    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/horizontal_slider");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void dragSlider() throws InterruptedException {
        WebElement elementToSlide = driver.findElement(By.xpath(" //div[@class='sliderContainer']//input"));

        dragAndDropElement(elementToSlide,30);
        Thread.sleep(2000);

    }
    public void dragAndDropElement(WebElement elementToSlide, int xOffSetToSlide) throws InterruptedException {
        Thread.sleep(2000);
        Actions action = new Actions(driver);
        action.dragAndDropBy(elementToSlide,xOffSetToSlide,0).click().build().perform();

        //Assert.assertEquals(driver.findElement(By.xpath("//span[@id='range']")).getText(),"4");
        Thread.sleep(2000);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
//span[@id='range']  [text()='4']