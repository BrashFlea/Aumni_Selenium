package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LoginPage {
    WebDriver driver;

    @FindBy(css = "button[class='login-page-dialog-button']")
    WebElement loginDialogButton;

    @FindBy(name = "email")
    WebElement emailInput;

    @FindBy(name = "password")
    WebElement passwordInput;

    @FindBy(css = "a[class='auth0-lock-alternative-link']")
    WebElement passwordResetLink;

    @FindBy(css = "button[aria-label='Log In'][type='submit']")
    WebElement loginSubmitButton;

    @FindBy(css = "div[class*='error-invalid-hint']")
    List<WebElement> loginErrors;

    @FindBy(css = "input[type=\"email\"]")
    WebElement passwordResetInput;

    @FindBy(css = "button[aria-label='Send email'][type='submit']")
    WebElement passwordResetSubmitButton;

    @FindBy(css = "div[class*='auth0-global-message-success'] span")
    WebElement passwordResetConfirmationMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // This is the login button before the login form
    public LoginPage clickLoginDialogButton() {
        loginDialogButton.click();

        return this;
    }

    public LoginPage typeUserEmail(String email){
        emailInput.sendKeys(email);

        return this;
    }

    public LoginPage typePassword(String password){
        passwordInput.sendKeys(password);

        return this;
    }

    public LoginPage clickPasswordResetLink() {
        passwordResetLink.click();

        return this;
    }

    public LoginPage enterPasswordResetEmail(String email) {
        passwordResetInput.sendKeys(email);

        return this;
    }

    public LoginPage submitPasswordResetEmail() {
        passwordResetSubmitButton.click();

        return this;
    }

    // This is the login button on the login form
    public HomePage submitLogin () {
        loginSubmitButton.submit();

        return new HomePage(driver);
    }

    public LoginPage submitEmptyLogin() {
        loginSubmitButton.submit();

        return this;
    }

    public List<String> getLoginErrors() {
        List<String> errors = new ArrayList<>();
        for (WebElement element : loginErrors) {
            errors.add(element.getText());
        }

        return errors;
    }

    public String getPasswordResetMessage() {
        // Try/catch to handle timeout and return an empty string
        WebDriverWait wait = new WebDriverWait(this.driver, 5);
        wait.until(ExpectedConditions.visibilityOf(passwordResetConfirmationMessage));
        return passwordResetConfirmationMessage.getText();
    }

    public HomePage loginAs (String username, String password) {
        typeUserEmail(username);
        typePassword(password);
        return submitLogin();
    }
}

