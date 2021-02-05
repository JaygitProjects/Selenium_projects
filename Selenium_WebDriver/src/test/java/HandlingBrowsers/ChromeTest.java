package HandlingBrowsers;

import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeTest {
    @Test
    public void launchChrome() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver","/Applications/Software/chromedriver");
        ChromeDriver cd = new ChromeDriver(); //to open browser after setting the property
        cd.get("http://uitest.automationtester.uk");//to open url
        System.out.println(cd.getTitle());

        cd.quit();

    }
}

