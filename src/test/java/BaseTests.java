import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class BaseTests {

    protected static WebDriver driver;
    protected static Eyes eyes;
    protected static SearchPage page;


    @BeforeClass
    public static void  setUp(){
        Properties props = System.getProperties();
        try {
            props.load(new FileInputStream(new File("resources/test.properties")));
        } catch(Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }

        driver = new ChromeDriver();
        initiateEyes();
        driver.get(System.getProperty("site.url"));
        page = new SearchPage(driver);
    }

    @AfterClass
    public static void tearDown(){driver.quit();}


//Initiate Eyes and send API Key
    private static void initiateEyes(){
        eyes= new Eyes();
        eyes.setApiKey(System.getProperty("applitools.api.key"));
    }

    public void validateWindow(){
        eyes.open(driver, "Automation Bookstore",
                Thread.currentThread().getStackTrace()[2].getMethodName());
        eyes.checkWindow();
        eyes.close();
    }
}
