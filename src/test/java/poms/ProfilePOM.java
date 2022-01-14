package poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePOM {


    WebDriver driver;
    WebDriverWait wait;


    @FindBy(id = "update-info-button")
    WebElement updateBtn;

    @FindBy(id = "updateInfoModal")
    WebElement updateModal;

    @FindBy(name = "firstName")
    WebElement firstnameInput;

    @FindBy(name = "updatedLastName")
    WebElement lastnameInput;

    @FindBy(id = "save-update-btn")
    WebElement saveUpdateBtn;

    public ProfilePOM(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));

        PageFactory.initElements(this.driver, this);
    }


    public Boolean isModalOpen(){
        WebElement modal = this.driver.findElement(By.id("updateInfoModal"));
        // this.wait.until(ExpectedConditions.attributeContains(modal, "style", "display: block"));
        this.wait.until(ExpectedConditions.attributeContains(modal, "style", "display: block;"));
        return true;
    }

    public void clickUpdateBtn() {
        this.updateBtn.click();
    }

    public String getCurrentUrl(){
        return this.driver.getCurrentUrl();
    }

    public void enterUpdatedFirstname(){
        this.firstnameInput.clear();
        this.firstnameInput.sendKeys("Cucumber");
    }

    public void enterUpdatedLastName(){
        this.lastnameInput.clear();
        this.lastnameInput.sendKeys("Tester");
    }

    public void clickSaveUpdate(){
        this.saveUpdateBtn.click();
    }


}
