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
        driver.findElement(By.xpath("//div[@class='well text-right']/div/div/div/input[@name='SearchDualList']")).sendKeys("bootstrap");
        WebElement element = driver.findElement(By.xpath("//div[@class='well text-right']//ul[@class='list-group']"));
        element.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[@class='glyphicon glyphicon-chevron-right']")).click();
        //verify right hand side list box contains boootstrap text
        List<WebElement> listBox = driver.findElements(By.xpath("//div[@class='well']//ul[@class='list-group']/li"));
        Thread.sleep(3000);
        System.out.println("Size of element on the right :"+listBox.size());
        boolean isBootStrapPresent = false;
        for (WebElement box : listBox) {
            if(box.getText().equalsIgnoreCase("bootstrap-duallist"));
            System.out.println("Bootstrap is present");
            isBootStrapPresent= true;


        }

        Assert.assertTrue(isBootStrapPresent);
    }

        @AfterClass
        public void tearDown(){
            driver.quit();
        }
}


//li[contains(text(),'bootstrap-duallist')]   By.cssSelector("div[class='well text-right'] #listhead+.list-group"));