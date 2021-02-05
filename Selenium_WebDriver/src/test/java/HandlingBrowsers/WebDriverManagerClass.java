package HandlingBrowsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class WebDriverManagerClass {
    @Test
    public void TestChromeWDM() {
        io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://uitest.automationtester.uk");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        driver.quit();
    }
    @Test
    public void TestFirefocWDM(){
        io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://uitest.automationtester.uk");//
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        driver.quit();

    }

}
