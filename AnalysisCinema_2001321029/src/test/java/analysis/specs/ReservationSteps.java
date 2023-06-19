package analysis.specs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ReservationSteps {
    private ReservationModel reservationModel;

    @Given("Open the reservation screen")
    public void openReservationPage() {
        this.reservationModel = new ReservationModel();
    }

    @When("Input name: {string}")
    public void addUsername(String username) {
        reservationModel.addUsername(username);
    }

    @When("Choose cinema: {string}")
    public void chooseCinema(String cinema) {
        reservationModel.addCinema(cinema);
    }

    @When("Choose movie: {string}")
    public void chooseMovie(String movie) {
        reservationModel.addMovie(movie);
    }

    @When("Choose start of projection: {string}")
    public void chooseStartTime(String startTime) {
        reservationModel.addStartTime(startTime);
    }

    @When("Compare reservation time {string}")
    public void timeNow(String timeOfReservation) {
        reservationModel.addTimeOfReservation(timeOfReservation);
    }

    @When("Choose row: {int}")
    public void chooseRow(int row) {
        reservationModel.addRow(row);
    }

    @When("Choose seat: {int}")
    public void choosePlace(int num) {
        reservationModel.addNum(num);
    }

    @When("Press reservation button")
    public void clickReserveButton() {
        reservationModel.clickButton();
    }

    @Then("Input message: {string}")
    public void checkMessage(String expectedMessage) {
        Assert.assertEquals(expectedMessage, reservationModel.getMessage());
    }


}
