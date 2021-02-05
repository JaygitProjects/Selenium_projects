package HandlingBrowsers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LaunchBrowserDynamically {
    WebDriver driver;
    String browserType;
    String appUrl;
    @Test
    public void testDynamicBrowser() throws InterruptedException{
         System.out.println(System.getProperty("user.dir")+ "/src/test/resources/input.properties"); // will print /Users/chenni/Documents/JavaSeleniumProjects/SeleniumMavenProject
        String path = System.getProperty("user.dir") + "/src/test/resources/input.properties";//combining above 2 lines

        //to get until /Users/chenni/Documents/JavaSeleniumProjects/SeleniumMavenProject/src/test/TestResources/input.properties

        //String path = System.getProperty("Users/chenni/Documents/JavaSeleniumProjects/SeleniumMavenProject/src/test/TestResources/input.properties");
        Properties prop = new Properties();
       try {
           FileInputStream fis = new FileInputStream(path);
           prop.load(fis);
            browserType = prop.getProperty("browser");
            appUrl = prop.getProperty("applicationUrl");
        }
       catch (FileNotFoundException e) {
            e.printStackTrace();
        }
       catch (IOException e) {
            e.printStackTrace();
        }


        if (browserType.equalsIgnoreCase("Chrome")) {

            System.setProperty("webdriver.chrome.driver","/Applications/Software/chromedriver");
            driver = new ChromeDriver();

        }
        else if (browserType.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        }
        driver.get(appUrl);
        Thread.sleep(5000);
        driver.getTitle();
        /*Thread.sleep(5000);
        driver.findElement(By.id("page-site-index")).click();

        driver.findElement(By.id("username")).sendKeys("jayanthirsundar@gmail.com");
        Thread.sleep(5000);
        driver.findElement(By.id("password")).sendKeys("$TJu9320");
        Thread.sleep(5000);
        driver.findElement(By.id("loginbtn")).click();



        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.navigate().to("https://www.google.com/?client=safari");
        System.out.println("Website Title : " + driver.getTitle());


            Thread.sleep(5000);

         */
        driver.getTitle();
            driver.quit();




        }


    }

