package Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;

public class CSSIdentification {
    WebDriver driver;
    @BeforeClass
    public void testSetup() throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("http://uitest.automationtester.uk/registration-form.html");
        Thread.sleep(1000);
    }
   @Test
    public void testCss(){
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("#FirstName"));//using id
        driver.findElement(By.cssSelector(".form-group "));//using class
        driver.findElement(By.cssSelector("input[id='FirstName']"));//any locator id or name
        driver.findElement(By.cssSelector("input[id*='Name']")); //if any id attribute that contains Name
        driver.findElement(By.cssSelector("input[id^='First"));// id attribute begin with First
        driver.findElement(By.cssSelector("input[id$='Name']"));//id attribute begins with
        driver.findElement(By.cssSelector(".form-group #FirstName"));//and operator
        driver.findElement(By.cssSelector(".form-group,#FirstName"));//or operator
        driver.findElement(By.cssSelector(".tree-branch ul li:first-of-type"));
        //driver.findElement(By.cssSelector("html body div div header div:n-th child(3) div div div a img"));//absolute path didnt work
        driver.manage().window().maximize();
    }
    @Test
    public void testDemo() throws InterruptedException {
        driver = new SafariDriver();
        driver.get("http://seleniumpractice.axone-tech.uk/index.php");

        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("a.login")).click();
        Thread.sleep(2000);

        WebElement email = driver.findElement(By.cssSelector("#email_create"));
        email.click();
        email.sendKeys("jayanthirsundar@gmail.com");
        Thread.sleep(4000);
      driver.findElement(By.cssSelector("#SubmitCreate")).click();
      Thread.sleep(3000);

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
