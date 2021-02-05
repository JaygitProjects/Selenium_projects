package ParameterSetting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
//check more setting details on pom.xml file
public class ParameterSetting {
    @Test
    public void testproperties() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver cd = new ChromeDriver();
        cd.get("http://studentcloud.axone-tech.uk");
        Thread.sleep(5000);
        System.out.println(cd.getTitle());
        cd.quit();
    }
    @Test(priority = 2) //Test will fail because no firefox driver : to overcome this ,need to use headless browser
            public void testproperties2(){
        WebDriverManager.firefoxdriver().setup();
        WebDriver ffd = new FirefoxDriver();
        ffd.get("http://studentcloud.axone-tech.uk");
        System.out.println(ffd.getTitle());
        ffd.quit();
    }
}
