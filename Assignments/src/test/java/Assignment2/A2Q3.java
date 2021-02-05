package Assignment2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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
    }
   /*@Test
    public void dragSlider() throws InterruptedException {

       // WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));
        Thread.sleep(2000);
        WebElement sliderValue = driver.findElement(By.xpath("//span[@id='range']"));
        System.out.println(sliderValue.getText());

        *//*for(int i=0; i<=4 ; i++){
         int currentSlider = Integer.parseInt(sliderValue.getText());
            currentSlider++;
        }*//*
        Actions action = new Actions(driver);
        action.sendKeys("4").click().perform();
        Thread.sleep(3000);

    }*/
    @Test
    public void horizontalSlideBar() throws InterruptedException {
        WebElement slider = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[1]/input[1]"));
        WebElement slidePosition = driver.findElement(By.xpath("//span[@id='range']"));
        slider.sendKeys("3");
        Actions act = new Actions(driver);
        int sPosition;
        act.dragAndDrop(slider, slidePosition).perform();
        Thread.sleep(5000);
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
//span[@id='range']  [text()='4']