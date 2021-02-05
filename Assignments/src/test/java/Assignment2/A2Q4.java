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

import java.util.List;

/*4) Automate the following scenario using css selector to identify any elements
        a) Navigate to http://the-internet.herokuapp.com/tables
        b) Implement a test to sort the ‘dues’ column in ascending order
        c) Implement a test to sort the ‘email’ column in ascending order*/
public class A2Q4 {
    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/tables");
        driver.manage().window().maximize();
    }
    @Test
    public void testDueSorting() throws InterruptedException {
     List<WebElement> due= driver.findElements(By.xpath("//table/tbody/tr/td[4]"));
        for (WebElement dueElement : due) {
          String actResult=dueElement.getText();
            System.out.println(dueElement.getText());

        }

        Thread.sleep(1000);
    }
    @Test
    public void testEmailSorting() throws InterruptedException {
        List<WebElement> email =driver.findElements(By.xpath("//table/tbody/tr/td[3]"));
        for (WebElement emailElement : email) {
            String expResult = emailElement.getText();
            System.out.println(emailElement.getText());
            Thread.sleep(1000);
        }

     // Actions action = new Actions(driver);

    }
    /*@Test     public void sortTableColumnDues() throws InterruptedException {         Thread.sleep(5000);         WebElement table = driver.findElement(By.xpath("//table[@id='table1']"));         //driver.switchTo().frame(table1);          List<WebElement> rowElements =  driver.findElements(By.xpath("//*[@id=\"table1\"]/tbody/tr/td[4]"));         int rowSize = rowElements.size();         List<WebElement> columnElements =  driver.findElements(By.xpath("//*[@id=\"table1\"]/tbody/tr/td[3]"));         int columnSize = columnElements.size();          for(int i = 1; i<rowSize; i++) {             for (int j = 1; j < columnSize; j++) {                 System.out.println(driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]/td["+j+"]")).getText()+ "  ");             }             System.out.println( );         } 
   *//* @Test
    public void sortTableColumnDues() throws InterruptedException {
       Thread.sleep(5000);   List<WebElement> dues =  driver.findElements(By.xpath("//body[1]/div[2]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[3]/span[1]"));          String[] sort = new String[dues.size()];         int i;         for (i = 0; i < dues.size(); i++) {             sort[i] = dues.get(i).getText();             System.out.println(sort[i]);         }       } 
*/
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
