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

import java.util.List;

/*2) Automate the following scenario
        a) Navigate to http://uitest.automationtester.uk/drag-and-drop-demo.html
        b) Implement a test to handle the ‘Items to Drag’ to ‘Drop here’ section and verify the results.*/
public class A2Q2 {
    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://uitest.automationtester.uk/drag-and-drop-demo.html");
        driver.manage().window().maximize();
    }
    @Test
    public void testHandleActions() throws InterruptedException {
        List<WebElement> itemsToDrag = driver.findElements(By.xpath("//span[@draggable='true']"));
        Thread.sleep(5000);

        Actions action = new Actions(driver);
        WebElement dragplace = driver.findElement(By.xpath("//div[@class='w50 moveleft'] "));
            dragplace.click();
Thread.sleep(1000);
           for (WebElement dragItem : itemsToDrag) {
               action.click(dragItem);
               Thread.sleep(2000);
               action.dragAndDrop(dragItem,dragplace).perform();
               Thread.sleep(3000);
               System.out.println(dragItem.getText());

            }
        Thread.sleep(3000);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
//div[@class='w50 moveleft']    //span[@draggable='true']   //div[@id='mydropzone']