import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import pages.HeaderPage;
import pages.LoginPage;

public class Main {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        driver.get("https://www.aumni.fund/");

        HeaderPage header_page = new HeaderPage(driver);
        LoginPage login_page = new LoginPage(driver);

        header_page.clickLoginLink();
        login_page.clickLoginDialogButton().submitEmptyLogin();
        List<String> errors = login_page.getLoginErrors();
        System.out.println(errors);


        driver.close();

    }

}
