package poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPOM {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "username-input")
    WebElement usernameInput;

    @FindBy(id = "password-input")
    WebElement passwordInput;

    @FindBy(id = "forgot-password-button")
    WebElement forgotPassword;

    @FindBy(id = "register-button")
    WebElement registerBtn;

    @FindBy(id = "submit-button")
    WebElement submitBtn;

    @FindBy(className = "err-message")
    WebElement errMessage;

    public LoginPOM(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));

        PageFactory.initElements(this.driver, this);
    }

    public void enterUsername(String username){
        this.usernameInput.sendKeys(username);
    }

    public void enterPassword(String password){
        this.passwordInput.sendKeys(password);
    }

    public void submitLogin(){
        this.submitBtn.click();
    }

    public void clickForgotPassword() {
        this.forgotPassword.click();
    }

    public void clickRegister() {
        this.registerBtn.click();
    }

    public void waitForSuccessfulLogin(){
        this.wait.until(ExpectedConditions.urlToBe("http://localhost:4200/main"));
    }

    public String getCurrentUrl(){
        return this.driver.getCurrentUrl();
    }


    public Boolean isErrMessageVisible(){
        this.wait.until(ExpectedConditions.visibilityOf(errMessage));
        return true;
    }



}
