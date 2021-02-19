package Assignment1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

/*6) UsingSmartcustomisedXPathselectorachievethefollowing
        a) Login to http://uitest.automationtester.uk/basic-first-form-demo.html
        b) Write your own custom css selector to click on the All Examples menu on the left hand tree structure.
         Navigate to Input Forms > Radio Buttons Demo page PS: Don’t navigate directly to the URL.
        c) Navigate to “Group Radio Buttons demo” section
        d) Write a test to fetch all the values of the Age group radio buttons and print them.
         Also print whether they are selected or not
        e) Write another test to validate “Get Values” logic.*/
public class Q6 {
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
        WebElement input = driver.findElement(By.xpath("//a[text()='Input Forms']"));
        input.click();
        Thread.sleep(5000);
        //b) Write your own custom css selector to click on the All Examples menu on the left hand tree structure.
        //         Navigate to Input Forms > Radio Buttons Demo page PS: Don’t navigate directly to the URL.
        WebElement radioButton = driver.findElement(By.xpath("//li[@class='tree-branch']/ul/li/a[contains(text(),'Radio Buttons Demo')]"));
        radioButton.click();
        // c) Navigate to “Group Radio Buttons demo” section
        driver.findElement(By.xpath("//*[@id='easycont']/div/div[2]/div[2]"));
        Thread.sleep(3000);
        //d) Write a test to fetch all the values of the Age group radio buttons and print them.
        //         Also print whether they are selected or not
        List<WebElement> radioButtons = driver.findElements(By.name("ageGroup"));
        radioButtons.get(1).click();
        Thread.sleep(3000);

        for (WebElement element :radioButtons ) {
            System.out.println(element.getAttribute("value")+"  "+element.isSelected());
        }
        //e) Write another test to validate “Get Values” logic.*/

    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}