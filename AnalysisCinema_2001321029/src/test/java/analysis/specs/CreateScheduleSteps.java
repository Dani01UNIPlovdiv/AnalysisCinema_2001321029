package analysis.specs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CreateScheduleSteps {
    private CreateScheduleModel scheduleModel;
    @Given("Adding new projection screen is opened")
    public void openSchedulePage() {
this.scheduleModel = new CreateScheduleModel();
    }
    @When("Choose cinema from list: {string}")
    public void chooseCinema(String cinema) {
        scheduleModel.addCinema(cinema);
    }
    @When("Choose movie from list: {string}")
    public void chooseMovie(String movie) {
scheduleModel.addMovie(movie);
    }
    @When("Choose start time of projection: {string}")
    public void chooseStart(String startTime) {
scheduleModel.addStartTime(startTime);
    }
    @When("Choose hall: {string}")
    public void chooseHall(String hall) {
        scheduleModel.addHall(hall);

    }
    @When("Press button for new projection")
    public void clickCreateButton() {
        scheduleModel.clickButton();
    }
    @Then("Displayed message: {string}")
    public void checkExpectedMessage(String expectedMessage) {
        Assert.assertEquals(expectedMessage, scheduleModel.getMessage());
    }

}
