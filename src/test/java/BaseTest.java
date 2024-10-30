import org.example.pages.FooterPage;
import org.example.pages.MainPage;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BaseTest {

    protected WebDriver driver;

    @Before
    public void init() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new FirefoxDriver(options);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.close();
        }
    }
}
