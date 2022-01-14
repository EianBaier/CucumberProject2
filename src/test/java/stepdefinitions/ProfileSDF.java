package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import poms.MainPOM;
import poms.ProfilePOM;

public class ProfileSDF {

    ProfilePOM profilePOM;

    @Given("A user is on their profile page")
    public void a_user_is_on_their_profile_page() {
        DriverSingleton.getInstance().get("http://localhost:4200/profile");

        this.profilePOM = new ProfilePOM(DriverSingleton.getInstance());
        Assertions.assertEquals("http://localhost:4200/profile", this.profilePOM.getCurrentUrl());
    }
    @When("A user clicks on the update button and updates their profile")
    public void a_user_clicks_on_the_update_button_and_updates_their_profile() {
        this.profilePOM.clickUpdateBtn();
        this.profilePOM.isModalOpen();
        this.profilePOM.enterUpdatedFirstname();
        this.profilePOM.enterUpdatedLastName();
        this.profilePOM.clickSaveUpdate();

    }
    @Then("The updated information displays on their profile")
    public void the_updated_information_displays_on_their_profile() {
        Assertions.assertEquals("http://localhost:4200/profile", this.profilePOM.getCurrentUrl());
    }
}
