import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Screenshot {
    WebDriver driver;
    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new SafariDriver();
        driver.get("https://www.bbc.co.uk/");
        driver.manage().window().maximize();
    }
    @Test
    public void testScreenshot() throws IOException {
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile,new File(SystemUtils.getUserDir()+"/target/screeshots/bbcFullPage.png"));


    }
    @AfterClass
    public void tearDown() {

        driver.quit();
    }

}
