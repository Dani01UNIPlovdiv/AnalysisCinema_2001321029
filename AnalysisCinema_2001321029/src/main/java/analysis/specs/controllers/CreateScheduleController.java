package analysis.specs.controllers;

import analysis.specs.Database;
import analysis.specs.models.Cinema;
import analysis.specs.models.Movie;
import analysis.specs.models.Schedule;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CreateScheduleController {
    Date startTime;
    public String schedule(String cinema, String movie, String startTime, String hall) {
        Map<String, Cinema> cinemasDB = new Database().getCinemasDB();
        if (!cinemasDB.containsKey(cinema)) {
            return "You've chosen an unexisting cinema!";
        }
        Map<String, Movie> moviesDB = new Database().getMoviesDB();
        if (!moviesDB.containsKey(movie)) {
            return "Non-existing movie!";
        }
        if (isHallBusy(hall, startTime)) {
            return "Hall is full!";
        }
        if(!compareDates(startTime)){
            return "Can't choose previous projection date!";
        }
        return "Projection created successfully!";

    }
    private boolean compareDates (String startTime) {
        SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        try {
            this.startTime = formatter.parse(startTime);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        String now;
        now = formatter.format(Calendar.getInstance().getTime());
        Date localTime;
        try {
            localTime = formatter.parse(now);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        int result = this.startTime.compareTo(localTime);

        return result>0;
    }
    private boolean isHallBusy(String hall, String startTime) {
        SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date parsedDate;
        try {
            parsedDate = formatter.parse(startTime);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Collection<Schedule> schedules = new Database().getSchedulesDB().values();
        for (Schedule schedule:  schedules) {
            Date time;
            try {
                time = formatter.parse(schedule.getStartDateTime());
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            if(time.compareTo(parsedDate)==0 && Objects.equals(schedule.getCinemaHall().getName(), hall)){
                return true;
            }
        }return false;
    }
}
