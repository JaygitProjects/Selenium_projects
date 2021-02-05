package OtherWebelements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DropdownList {
    WebDriver driver;

    @BeforeTest
    public void browserSetup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("http://uitest.automationtester.uk/basic-radiobutton-demo.html");

    }
    @Test
    public void testDDl(){
        driver.findElement(By.id("select-demo")).sendKeys("Monday");

    }
    @Test(priority = 2)
    public void testDdlOption2() throws InterruptedException {
       WebElement ddlList =  driver.findElement(By.id("select-demo"));
       Select dayList = new Select(ddlList);
       dayList.selectByValue("Tuesday");
       Thread.sleep(2000);

    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
