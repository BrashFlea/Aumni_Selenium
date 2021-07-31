package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HeaderPage {
    WebDriver driver;

    @FindBy(css = "div[class='nav-logo'] a")
    WebElement navLogo;

    @FindBy(css = "dd-nav-wrap")
    WebElement dropdownWrapper;

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

    @FindBy(css = "nav[id='w-dropdown-list-2'] a")
    List<WebElement> resourcesLinks;

    @FindBy(css = "div[id='w-dropdown-toggle-3']")
    WebElement aboutDropdown;

    @FindBy(css = "nav[id='w-dropdown-list-3'] a")
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
        Actions action = new Actions(driver);
        action.moveToElement(aumniInfoDropdown).click().build().perform();

        return this;
    }

    public boolean clickInfoOption(String option) {
        return this.clickDropdownOption(option, aumniInfoLinks);
    }

    public HeaderPage clickUseCasesDropdown() {
        Actions action = new Actions(driver);
        action.moveToElement(useCasesDropdown).click().build().perform();

        return this;
    }

    public boolean clickUseCasesOption(String option) {
        return this.clickDropdownOption(option, useCasesLinks);
    }

    public HeaderPage clickResourcesDropdown() {
        Actions action = new Actions(driver);
        action.moveToElement(resourcesDropdown).click().build().perform();

        return this;
    }

    public boolean clickResourcesOption(String option) {
        return this.clickDropdownOption(option, resourcesLinks);
    }

    public HeaderPage clickAboutDropdown() {
        Actions action = new Actions(driver);
        action.moveToElement(aboutDropdown).click().build().perform();

        return this;
    }

    public boolean clickAboutOption(String option) {
        return this.clickDropdownOption(option, aboutLinks);
    }

    private boolean clickDropdownOption(String clickOption, List<WebElement> dropdownLinks) {
        // Generalized logic for clicking header dropdown options
        String oldUrl = driver.getCurrentUrl();

        for (WebElement element : dropdownLinks) {
            String elementText = element.getText();
            if (elementText.equals(clickOption)) {
                element.click();
                WebDriverWait wait = new WebDriverWait(this.driver, 5);
                wait.until(ExpectedConditions.not((ExpectedConditions.urlToBe(oldUrl))));
                return true; // Ideally return page object of navigated page
            }
        }

        return false;
    }

    public LoginPage clickLoginLink() {
        loginLink.click();

        return new LoginPage(driver);
    }
}
