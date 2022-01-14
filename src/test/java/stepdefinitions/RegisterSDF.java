package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import poms.LoginPOM;
import poms.RegisterPOM;

public class RegisterSDF {

    RegisterPOM registerPOM;
    LoginPOM loginPOM;

    @Given("a user is on the register page")
    public void a_user_is_on_the_register_page() throws InterruptedException {
        DriverSingleton.getInstance().get("http://localhost:4200/create");
        Thread.sleep(1000);
        this.registerPOM = new RegisterPOM(DriverSingleton.getInstance());
        Assertions.assertEquals("http://localhost:4200/create", this.registerPOM.getCurrentUrl());
    }
    @When("a user inputs their information and clicks submit")
    public void a_user_inputs_their_information_and_clicks_submit() {
        this.registerPOM.enterEmail("kev@email.com");
        this.registerPOM.enterUsername("KChilds1234");
        this.registerPOM.enterPassword("1234");
        this.registerPOM.enterConfirmPassword("1234");
        this.registerPOM.enterFirstname("Kevin");
        this.registerPOM.enterLastname("Childs");
        this.registerPOM.clickSubmitBtn();
    }
    @Then("a user is redirected to the login page")
    public void a_user_is_redirected_to_the_login_page() {
        Assertions.assertEquals("http://localhost:4200/", this.registerPOM.getCurrentUrl());
    }


    @Given("A user is now on the login page")
    public void a_user_is_on_the_login_page() throws InterruptedException {
        DriverSingleton.getInstance().get("http://localhost:4200/");
        Thread.sleep(2000);
        this.loginPOM = new LoginPOM(DriverSingleton.getInstance());
        Assertions.assertEquals("http://localhost:4200/", this.loginPOM.getCurrentUrl());

    }

    @When("A user inputs new credentials on the login form")
    public void a_user_inputs_new_credentials_on_the_login_form() {
        this.loginPOM.enterUsername("KChilds1234");
        this.loginPOM.enterPassword("1234");
        this.loginPOM.submitLogin();
    }

    @Then("the user will now be redirect to the main feed")
    public void the_user_will_be_redirect_to_the_main_feed() {
        this.loginPOM.waitForSuccessfulLogin();
        Assertions.assertEquals("http://localhost:4200/main", this.loginPOM.getCurrentUrl());
    }


}
