import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

class TestBase {
    public static WebDriver driver;

    @BeforeSuite
    public void initializeWebDriver() throws IOException {
        System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
        driver = new ChromeDriver();

        // To maximize browser
        driver.manage().window().maximize();

        // Implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // To open Aumni site
        driver.get("https://www.aumni.fund/");
    }

    @AfterSuite
    public void quitDriver() {
        driver.quit();
    }
}
