package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HeaderPage {
    WebDriver driver;

    @FindBy(css = "div[class='nav-logo'] a")
    WebElement navLogo;

    @FindBy(css = "div[id='w-dropdown-toggle-0']")
    WebElement aumniInfoDropdown;

    @FindBy(css = "nav[id='w-dropdown-list-0'] a")
    List<WebElement> aumniInfoLinks;

    @FindBy(css = "div[id='w-dropdown-toggle-1']")
    WebElement useCasesDropdown;

    @FindBy(css = "nav[id='w-dropdown-list-1'] a")
    List<WebElement> useCasesLinks;

    @FindBy(css = "div[id='w-dropdown-toggle-2']")
    WebElement resourcesDropdown;

    @FindBy(css = "nav[id='w-dropdown-list-1'] a")
    List<WebElement> resourcesLinks;

    @FindBy(css = "div[id='w-dropdown-toggle-3']")
    WebElement aboutDropdown;

    @FindBy(css = "nav[id='w-dropdown-list-1'] a")
    List<WebElement> aboutLinks;

    @FindBy(css = "a[class='navlink login']")
    WebElement loginLink;

    public HeaderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HeaderPage clickLogo() {
        navLogo.click();

        return this;
    }

    public HeaderPage clickInfoDropdown() {
        aumniInfoDropdown.click();

        return this;
    }

    public HeaderPage clickInfoOption(String option) {

        for (WebElement element : aboutLinks) {
            if (element.getText().equals(option)) {
                element.click();
                return this;
            }
        }

        return this;
    }

    public LoginPage clickLoginLink() {
        loginLink.click();

        return new LoginPage(driver);
    }
}
