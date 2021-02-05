package HandlingBrowsers;

import org.testng.annotations.Test;

public class TestCheck {
    @Test
    public void testCheck(){
        //System.out.println(System.getProperty("/Users/chenni/Documents/JavaSeleniumProjects/SeleniumMavenProject/src/test/TestResources/test.properties"));
        System.out.println(System.getProperty("user.dir")+"/src/test/TestResources/test.properties");
    }
}
