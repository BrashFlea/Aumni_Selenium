import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HeaderPage;
import pages.LoginPage;

import java.util.List;

public class AumniTest extends TestBase {

    @Test
    public void LoginValidationTest() throws Exception {
        HeaderPage header_page = new HeaderPage(driver);
        LoginPage login_page = header_page.clickLoginLink();
        login_page.clickLoginDialogButton().submitEmptyLogin();
        List<String> errors = login_page.getLoginErrors();

        System.out.println("Login Errors: " + errors);
        Assert.assertEquals(errors.size(), 2);

    }

    @Test
    public void PasswordResetTest() throws Exception {
        HeaderPage header_page = new HeaderPage(driver);
        LoginPage login_page = header_page.clickLoginLink();

        login_page.clickLoginDialogButton().clickPasswordResetLink();
        login_page.enterPasswordResetEmail("Test@Test.com").submitPasswordResetEmail();
        String password_reset_message = login_page.getPasswordResetMessage();

        Assert.assertEquals(password_reset_message, "WE'VE JUST SENT YOU AN EMAIL TO RESET YOUR PASSWORD.");

        System.out.println("Password reset message: " + password_reset_message);

    }

    @Test
    public void HeaderInfoNavigationTest() throws Exception {
        HeaderPage header_page = new HeaderPage(driver);
        String before_dropdown_url = driver.getCurrentUrl();
        header_page.clickInfoDropdown();
        header_page.clickInfoOption("The Basics");
        String after_dropdown_url = driver.getCurrentUrl();

        System.out.println("Url before dropdown navigation: " + before_dropdown_url);
        System.out.println("Url after dropdown navigation: " + after_dropdown_url);
        Assert.assertNotEquals(before_dropdown_url, after_dropdown_url);

    }

    @Test
    public void HeaderUseCasesNavigationTest() throws Exception {
        HeaderPage header_page = new HeaderPage(driver);
        String before_dropdown_url = driver.getCurrentUrl();
        header_page.clickUseCasesDropdown();
        header_page.clickUseCasesOption("Automate partner meeting prep");
        String after_dropdown_url = driver.getCurrentUrl();

        System.out.println("Url before dropdown navigation: " + before_dropdown_url);
        System.out.println("Url after dropdown navigation: " + after_dropdown_url);
        Assert.assertNotEquals(before_dropdown_url, after_dropdown_url);

    }

    @Test
    public void HeaderResourcesNavigationTest() throws Exception {
        HeaderPage header_page = new HeaderPage(driver);
        String before_dropdown_url = driver.getCurrentUrl();
        header_page.clickResourcesDropdown();
        header_page.clickResourcesOption("Blog");
        String after_dropdown_url = driver.getCurrentUrl();

        System.out.println("Url before dropdown navigation: " + before_dropdown_url);
        System.out.println("Url after dropdown navigation: " + after_dropdown_url);
        Assert.assertNotEquals(before_dropdown_url, after_dropdown_url);

    }

    @Test
    public void HeaderAboutNavigationTest() throws Exception {
        HeaderPage header_page = new HeaderPage(driver);
        String before_dropdown_url = driver.getCurrentUrl();
        header_page.clickAboutDropdown();
        header_page.clickAboutOption("Careers");
        String after_dropdown_url = driver.getCurrentUrl();

        System.out.println("Url before dropdown navigation: " + before_dropdown_url);
        System.out.println("Url after dropdown navigation: " + after_dropdown_url);
        Assert.assertNotEquals(before_dropdown_url, after_dropdown_url);

    }
}
