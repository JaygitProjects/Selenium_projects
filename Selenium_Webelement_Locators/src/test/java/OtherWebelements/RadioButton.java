package OtherWebelements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class RadioButton {
    WebDriver driver;

    @BeforeMethod
    public void BrowserSetup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("http://uitest.automationtester.uk/basic-radiobutton-demo.html");

    }
    @Test
    public void TestRadioButton() throws InterruptedException {
       List<WebElement> allRadioButtons = driver.findElements(By.name("optradio"));
       allRadioButtons.get(1).click();
       Thread.sleep(5000);



       for (WebElement radio : allRadioButtons) {
           System.out.println(radio.getAttribute("value") + "is selected or not : " + radio.isSelected());
       }

           driver.quit();
       }

    }

