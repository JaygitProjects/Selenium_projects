package HandlingBrowsers;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.Test;

public class HeadlessBrowser {

    @Test
    public void TestHeadlessBrowser() {
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://seleniumpractice.axone-tech.uk/index.php");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        driver.close();
    }

    @Test(priority = 2)//
    public void TestHtmlUnitDriverChromeVersion() {
        WebDriver driver = new HtmlUnitDriver(BrowserVersion.CHROME);
        driver.get("http://seleniumpractice.axone-tech.uk/index.php");
        System.out.println("*** HTMLUNIT in  Chrome version ***");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        driver.close();
    }

    @Test(priority = 3)
    public void TestHtmlUnitDriverFirefoxversion() {
        WebDriver driver = new HtmlUnitDriver(BrowserVersion.FIREFOX);
        driver.get("http://seleniumpractice.axone-tech.uk/index.php");
        System.out.println("*** HTMLUNIT in  Firefox version *** ");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        driver.close();
    }

    //Chrome headless browser using options
    // For use with ChromeDriver:ChromeDriver driver = new ChromeDriver(options) and pass argument"headless".
    @Test(priority = 4)
    public void TestChromeHeadless() {
        System.setProperty("webdriver.chrome.driver", "/Applications/Software/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        WebDriver driver = new ChromeDriver(options);
        driver.get("http://seleniumpractice.axone-tech.uk/index.php");
        System.out.println("*** Chrome Headless Browser  ***");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        driver.close();

    }
  //Find why this  is failing
    //Firefox headless browser using options
    // For use with FirefoxDriver:FirefoxDriver driver = new FirefoxDriver(options) and pass argument"headless".
    @Test(priority = 5)
    public void TestFirefoxHeadless() {
        System.setProperty("webdriver.gecko.driver", "/Applications/Software/geckodriver");
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("headless");
        WebDriver driver = new FirefoxDriver(options);
        driver.get("http://seleniumpractice.axone-tech.uk/index.php");
        System.out.println("*** Firefox Headless Browser  ***");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        driver.close();

    }
}
/*
package HandlingWindows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HandleWindows {
    public class A2Q2 {
        WebDriver driver;

        @BeforeClass
        public void setup() {
            driver = new SafariDriver();
            driver.get("http://mail.axone-tech.uk/useful-links");
        }

        @Test
        public void testHrefLink() throws InterruptedException {
            driver.findElement(By.xpath("  //h3[contains(text(),'How to use Xpath Functions')]")).click();

            //1.Collection of Windows
            Set<String> windows = driver.getWindowHandles();

            //2.get the size of the window
            System.out.println("Size of the Windows :" +windows.size());

            //3.
            Iterator<String> itr= windows.iterator();
            //itr.next();
            // returns next element in the window

            String mainwindow = itr.next();
            String popupwindow = itr.next();
            driver.switchTo().window(popupwindow);

            System.out.println(driver.getTitle());

            driver.close();

            driver.switchTo().window(mainwindow);
            System.out.println(driver.getTitle());
            Thread.sleep(4000);

        }
        @AfterClass
        public void tearDown() {
            driver.quit();
        }
    }
}

*/
