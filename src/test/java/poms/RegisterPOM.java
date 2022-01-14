package poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPOM {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(name = "email")
    WebElement emailInput;

    @FindBy(id = "exampleInputUsername")
    WebElement usernameInput;

    @FindBy(id = "password-input")
    WebElement passwordInput;

    @FindBy(id = "confirm-password-input")
    WebElement confirmInput;

    @FindBy(id = "first-name-input")
    WebElement firstNameInput;

    @FindBy(id = "last-name-input")
    WebElement lastNameInput;

    @FindBy(className= "btn-primary")
    WebElement submitBtn;




    public RegisterPOM(WebDriver driver) {
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

    public void enterEmail(String email){
        this.emailInput.sendKeys(email);
    }

    public void enterConfirmPassword(String confirmPassword){
        this.confirmInput.sendKeys(confirmPassword);
    }

    public void enterFirstname(String firstname){
        this.firstNameInput.sendKeys(firstname);
    }

    public void enterLastname(String lastname){
        this.lastNameInput.sendKeys(lastname);
    }

    public void clickSubmitBtn() {
        this.submitBtn.click();
    }

    public void waitForSuccessfulLogin(){
        this.wait.until(ExpectedConditions.urlToBe("http://localhost:4200/main"));
    }

    public String getCurrentUrl(){
        return this.driver.getCurrentUrl();
    }
}
