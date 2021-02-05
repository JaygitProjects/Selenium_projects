package Assignment2;
/*
5) Automate the following
        a) Visit http://uitest.automationtester.uk/bootstrap-dual-list-box-demo.html
        b) Enter ‘bootstrap’ into left side search box and choose ‘bootstrap-duallist’ value from the auto suggest
        c) Move the selected value to the right hand side List box and verify the results
*/

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class A2Q5 {
    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://uitest.automationtester.uk/bootstrap-dual-list-box-demo.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void testToMoveList() throws InterruptedException {
        /*driver.findElement(By.xpath("//div[@class='well text-right']/div/div/div/input[@name='SearchDualList']")).sendKeys("bootstrap");
        WebElement element = driver.findElement(By.xpath())*/
        //
        WebElement leftBootStrap = driver.findElement(By.xpath("//li[@class='list-group-item' and text()='bootstrap-duallist ']"));
        leftBootStrap.click();
        System.out.println("Item before moved : "+leftBootStrap.getText());
        String actRes = leftBootStrap.getText();

        Thread.sleep(1000);
        WebElement button1 = driver.findElement(By.xpath("//button[@class='btn btn-default btn-sm move-right']"));
        button1.click();

        WebElement rightBootStrap = driver.findElement(By.xpath("//li[@class='list-group-item active' and text()='bootstrap-duallist ']"));
        System.out.println("Item after moved : "+rightBootStrap.getText());
        String expResult = rightBootStrap.getText();
        Thread.sleep(3000);


        Assert.assertEquals(actRes,expResult);
    }

        @AfterClass
        public void tearDown(){
            driver.quit();
        }
}


//li[contains(text(),'bootstrap-duallist')]   By.cssSelector("div[class='well text-right'] #listhead+.list-group"));