package poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPOM {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "click-me")
    WebElement createPostBtn;

    @FindBy(id = "createPostModal")
    WebElement createPostModal;

    @FindBy(name = "postMessage")
    WebElement createPostText;

    @FindBy(id = "create-post-in-modal")
    WebElement createPostBtnInModal;

    @FindBy(className = "navbar-toggler-icon")
    WebElement navbarToggle;

    @FindBy(id = "profile-button")
    WebElement profileBtn;

    public MainPOM(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));

        PageFactory.initElements(this.driver, this);
    }

    public void clickCreatePostBtn() {
        /*WebElement post = this.driver.findElement(By.id("picdiv"));
        this.wait.until(ExpectedConditions.visibilityOf(post));*/
        this.createPostBtn.click();
    }

    public Boolean isModalOpen(){
        WebElement modal = this.driver.findElement(By.id("createPostModal"));
       // this.wait.until(ExpectedConditions.attributeContains(modal, "style", "display: block"));
        this.wait.until(ExpectedConditions.attributeContains(modal, "style", "display: block;"));
        return true;
    }

    public void enterPostMessage(String postMessage){
        this.createPostText.sendKeys(postMessage);

    }

    public void clickCreatePostInModal(){
        this.createPostBtnInModal.click();
    }

    public String getCurrentUrl(){
        return this.driver.getCurrentUrl();
    }

    public void clickNavToggle(){
        this.navbarToggle.click();

    }

    public void clickProfile(){
        this.wait.until(ExpectedConditions.visibilityOf(this.profileBtn));
        this.profileBtn.click();
    }

}
