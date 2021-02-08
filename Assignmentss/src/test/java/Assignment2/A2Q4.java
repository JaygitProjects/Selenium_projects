package Assignment2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
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

        //get the row heading and click to sort
    driver.findElement(By.xpath("//table[@id='table1']/thead/tr/th[4]")).click();
    //values under dues
    List<WebElement> dues = driver.findElements(By.xpath("//table/tbody/tr/td[4]"));

    //converting to arraylist to use sort method in collection
        ArrayList<String> duevalue =new ArrayList<>();

        for (WebElement dueElement : dues) {
          String actResult=dueElement.getText();
            System.out.println(duevalue.add(dueElement.getText()));
        }
        Thread.sleep(1000);
    }
    @Test
    public void testEmailSorting() throws InterruptedException {
      driver.findElement(By.xpath("//table[@id='table1']/thead/tr/th[3]")).click();
      List<WebElement> emails = driver.findElements(By.xpath("//table/tbody/tr/td[3]"));
        ArrayList<String> emailList = new ArrayList<>();
        for (WebElement emailElement : emails) {

            System.out.println(emailElement.getText());
            emailList.add(emailElement.getText());
            ArrayList<String> emailListCopy = new ArrayList<>(emailList);
            Collections.sort(emailListCopy);

            Thread.sleep(1000);
           // Assert.assertEquals(emailList,emailListCopy);
        }
    }


    // Mahas answer***********************************************************************
  /* @Test
   public void testSortingDuesColumn()
           throws InterruptedException {

       // sort dues column in ascending order
       driver.findElement(By.cssSelector("#table1 thead tr th:nth-of-type(4)")).click();

       // get values from dues column
       List<WebElement> dues = driver.findElements(By.cssSelector("#table1 tbody tr td:nth-of-type(4)"));
       List<Double> dueValues = new ArrayList<Double>();
       for (WebElement element : dues) {
           //converting the string due value to double
           dueValues.add(Double.parseDouble(element.getText().replace("$", "")));
       }
       boolean isDuesListAsc = true;
       for (int i = 0; i < dueValues.size() -1; i++) {
           if (dueValues.get(i+1) < dueValues.get(i)) {
               isDuesListAsc = false;
               break;
           }

       }

       //print them
       System.out.println(dueValues);

       Assert.assertTrue(isDuesListAsc);
   }

    @Test
    public void testEmailSorting() {
        // sort email column in ascending order
        driver.findElement(By.cssSelector("#table1 thead tr th:nth-of-type(3)")).click();

        // get values from email column
        List<WebElement> emails = driver.findElements(By.cssSelector("#table1 tbody tr td:nth-of-type(3)"));

        ArrayList<String> emailText = new ArrayList<>();
        for (WebElement element : emails) {
            emailText.add(element.getText());
        }

        List<String> emailTextCopy = new ArrayList<>(emailText);

        Collections.sort(emailTextCopy);

//        System.out.println(emailText);
//        System.out.println(emailTextCopy);
        Assert.assertEquals(emailText, emailTextCopy);
    }
*/

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
