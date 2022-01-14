package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import poms.MainPOM;

public class MainSDF {

    MainPOM mainPOM;

    @Given("A user is on the main page")
    public void a_user_is_on_the_main_page() {
       DriverSingleton.getInstance().get("http://localhost:4200/main");

       this.mainPOM = new MainPOM(DriverSingleton.getInstance());
       Assertions.assertEquals("http://localhost:4200/main", this.mainPOM.getCurrentUrl());
    }
    @When("A user clicks the create post button")
    public void a_user_clicks_the_create_post_button() throws InterruptedException {
        this.mainPOM.clickCreatePostBtn();

    }
    @Then("A modal pops up")
    public void a_modal_pops_up() {
       Assertions.assertTrue(this.mainPOM.isModalOpen());
    }

    @Given("The create post modal is showing")
    public void the_create_post_modal_is_showing() {
        Assertions.assertTrue(this.mainPOM.isModalOpen());
    }
    @When("A user inputs fields and hits create post button")
    public void a_user_inputs_fields_and_hits_create_post_button() {
        this.mainPOM.enterPostMessage("This is a post made in Cucumber");
        this.mainPOM.clickCreatePostInModal();
    }
    @Then("A new post with the same text entered shows")
    public void a_new_post_with_the_same_text_entered_shows() {
        Assertions.assertEquals("http://localhost:4200/main", this.mainPOM.getCurrentUrl());

    }

    @When("A user clicks on the profile button")
    public void aUserClicksOnTheProfileButton() {
        this.mainPOM.clickNavToggle();
        this.mainPOM.clickProfile();


    }

    @Then("A user is taken to their profile")
    public void aUserIsTakenToTheirProfile() {

        Assertions.assertEquals("http://localhost:4200/profile", this.mainPOM.getCurrentUrl());

    }
}
