package analysis.specs.controllers;

import analysis.specs.Database;
import analysis.specs.models.ReservedSeats;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

public class ReservationController {
    Date startTime;
    Date timeOfReservation;

    public String reservation(String username,
                              String cinema,
                              String movie,
                              String startTime,
                              String timeOfReservation,
                              int row,
                              int num) {

        if (StringUtils.isBlank(cinema)) {
            return "You haven't chosen the cinema!";
        }
        if (StringUtils.isBlank(movie)) {
            return "You haven't chosen the movie!";
        }
        if (isPlaceReservedMethod(row, num)) {
            return "The spot is taken!";
        }
        if (!checkDates(startTime, timeOfReservation)) {
            return "Reservation has to be at least 60 minutes before the projection!";
        }
        return "Reservation successful!";
    }

    private boolean isPlaceReservedMethod(int row, int num) {
        Collection<ReservedSeats> seats = new Database().getReservedSeatsDB().values();
        for (ReservedSeats seat : seats) {
            if (seat.getRow() == row && seat.getNum() == num) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDates(String startTime, String timeOfReservation) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        try {
            this.startTime = formatter.parse(startTime);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        try {
            this.timeOfReservation = formatter.parse(timeOfReservation);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        long difference_In_Minutes
                = ((this.startTime.getTime() - this.timeOfReservation.getTime())
                / (1000 * 60));
        return difference_In_Minutes > 60;
    }
}
