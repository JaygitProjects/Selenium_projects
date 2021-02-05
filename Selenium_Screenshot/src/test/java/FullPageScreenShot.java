
package ScreenshotAndSync;

import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import ru.yandex.qatools.ashot.shooting.ShootingStrategy;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class FullPageScreenShot {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new SafariDriver();
        driver.get("https://www.bbc.co.uk/");
    }

    @Test
    public void testFullPageDScreenshot() throws IOException {
      //1.Taking the screenshot page
        Screenshot screenshot = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(driver);
        //2.Save to desired Location
       // ImageIO.write(screenshot.getImage(),"PNG",new File(SystemUtils.getUserDir()+"/target/Screenshots/bbcFullPage.png"));

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}


