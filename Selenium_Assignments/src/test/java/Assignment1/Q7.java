package Assignment1;
 /*7) Using Smart customised css selector achieve the following
 a) Login to http://uitest.automationtester.uk/basic-first-form-demo.html
 b) Write your own custom css selector to click on the All Examples menu on the left hand tree structure.
  Navigate to Input Forms > Select Dropdown List
 PS: Don’t navigate directly to the URL.
 c) Navigate to “Multi Select List Demo” section
 d) Write a test to validate the following:
 - it’s a multi select box
 - to multi-select: California, Pennsylvania values e) Write another test to verify first selected logic
 f) Write another test to verify get all selected logic.*/

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Q7 {

    WebDriver driver;

    @BeforeClass
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://uitest.automationtester.uk/basic-first-form-demo.html");
        Thread.sleep(5000);
    }

    @Test
    public void testCssSelector() throws InterruptedException {
        //b)Navigate to Input Forms > Select Dropdown List
        WebElement input = driver.findElement(By.xpath("//a[text()='Input Forms']"));
        input.click();
        Thread.sleep(5000);
        //c)  Navigate to “Multi Select List Demo” section
        //.tree-branch>ul>li:nth-of-type(1) :nth-child(4)
        //List<WebElement> dropDownList = driver.findElements(By.cssSelector("ul li ul li ul li a[href='./basic-select-dropdown-demo.html']"));
        /* List<WebElement> dropDownList = driver.findElements(By.cssSelector("select[name='States']"));
         for (WebElement ddl : dropDownList) {
             System.out.println(ddl.getText());
             if (ddl.getText().equalsIgnoreCase("Select Dropdown List")){
                  ddl.click();
                  break;
             }*/


        Thread.sleep(3000);
        //d)to validate the following:
        //- it’s a multi select box
        //- to multi-select: California, Pennsylvania values
        WebElement multiSelect = driver.findElement(By.cssSelector("#multi-select"));
        Select states = new Select(multiSelect);
        System.out.println("is it a multi select box:" + states.isMultiple());

        // e) Write another test to verify first selected logic

        //f) Write another test to verify get all selected logic.
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
