package Assignment2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
/*1) Automate the following scenario
        a) Visit https://money.rediff.com/gainers/bse/daily/groupa?src =gain_lose
        b) Print all the company names and their current price
        c) Write down a private method ‘getRowWithCellText’ that accepts the string input
        parameter of any data and returns the row number where the data exists in the Table specified. Note: Please return the first match alone.*/

public class A2Q1 {
    WebDriver driver;

    @BeforeClass
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://money.rediff.com/gainers/bse/daily/groupa?src =gain_lose");
        Thread.sleep(5000);
    }

    @Test
    public void testTableXpath() throws InterruptedException {
        List<WebElement> company = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
        //List<WebElement> company = driver.findElements(By.xpath("//th[text()='Company']"));


        List<WebElement> currentPrice = driver.findElements(By.xpath("//table/tbody/tr/td[4]"));
//get(i)
        //for (int i = 1; i < company.size(); i++) {
            for (int i = 1; i < 20; i++) {
            System.out.println("Company Name is  " + company.get(i).getText() + ".  Its Current Price is" + currentPrice.get(i).getText());
            }
        // passing the parameter(string cell value to compare) here, instead of creating new class and sending from there
        //through method

            //as the method returns its corresponding row number assign the value return to int variable
        int result =  getRowWithCellText("Bajaj");
        System.out.println( "\n Element is found at the Row:  " + result);

    }

        private int getRowWithCellText(String cellDataToFind){
            int rowWithTextCell =0;

           int rows= driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr")).size();
            System.out.println("\n\n Entire row Size = " +rows);
            //i is the row number we are iterating
            for(int i=1;i<= rows;i++) {
                //to get cell value for each row
                List<WebElement> rowCells = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr["+i+"]/td"));
                //to get each cell value of particular row
                if (rowCells.get(0).getText().trim().equalsIgnoreCase(cellDataToFind)) {
                    rowWithTextCell = i;
                    //   System.out.println(cellDataToFind).;
                    break;

                }

            }

            return(rowWithTextCell);
        }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
