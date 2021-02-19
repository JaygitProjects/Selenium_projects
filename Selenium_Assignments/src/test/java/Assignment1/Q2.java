package Assignment1;



 import org.openqa.selenium.By;
 import org.openqa.selenium.WebDriver;
 import org.openqa.selenium.WebElement;
 import org.openqa.selenium.safari.SafariDriver;
 import org.testng.annotations.AfterClass;
 import org.testng.annotations.BeforeClass;
 import org.testng.annotations.Test;
 import java.util.List;


 /*2) Fetch all the HREFs for the link texts and then print them
         a) Navigate to https://www.bbc.co.uk/
         b) Using CSS Selector locator strategy fetch the link texts available in the home page top Menu.*/

    public class Q2 {
        WebDriver driver;

        @BeforeClass
        public void setup() {
            driver = new SafariDriver();
            driver.get("https://www.bbc.co.uk/");
        }

        @Test
        public void testHrefLink() {
            // findElementas to get more than one element and store it in list , then use for each loop to extract each element
            List<WebElement> menuLink = driver.findElements(By.cssSelector("a[class*='NavigationLink eki2hvo6']"));
            for (WebElement element : menuLink) {
                System.out.println(element.getText()+" :  "+element.getAttribute("href"));
            }
        }

        @AfterClass
        public void tearDown() {
            driver.quit();
        }
    }

