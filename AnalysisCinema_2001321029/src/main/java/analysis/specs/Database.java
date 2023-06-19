package analysis.specs;

import analysis.specs.models.*;

import java.util.HashMap;
import java.util.Map;

public class Database {
    private Map<Integer, ReservedSeats> reservedSeats = new HashMap<>();
    private Map<String, Cinema> cinemas = new HashMap<>();
    private Map<String, Movie> movies = new HashMap<>();
    private Map<String, CinemaHall> halls = new HashMap<>();
    private Map<String, Schedule> schedules = new HashMap<>();
    public Database() {
        ReservedSeats reservedSeat1 = new ReservedSeats();
        reservedSeat1.setRow(1);
        reservedSeat1.setNum(1);
        reservedSeats.put(1, reservedSeat1);

        ReservedSeats reservedSeat2 = new ReservedSeats();
        reservedSeat2.setRow(1);
        reservedSeat2.setNum(2);
        reservedSeats.put(2, reservedSeat2);

        Cinema cinema1 = new Cinema();
        cinema1.setName("Arena Max");
        cinemas.put("Arena Max", cinema1);

        Movie movie1 = new Movie();
        movie1.setTitle("Arena Max");
        movies.put("Venom", movie1);

        CinemaHall cinemaHall =new CinemaHall();
        cinemaHall.setName("4K 3D");
        halls.put("4K 3D", cinemaHall);

        Schedule schedule1 = new Schedule();
        schedule1.setCinemaHall(cinemaHall);
        schedule1.setStartDateTime("12-01-2024 15:00:00");
        schedules.put("1",schedule1);
        //create other objects

    }

    public Map<Integer, ReservedSeats> getReservedSeatsDB() {
        return reservedSeats;
    }
    public Map<String, Cinema> getCinemasDB() {
        return cinemas;
    }
    public Map<String, Movie> getMoviesDB() {
        return movies;
    }
    public Map<String, Schedule> getSchedulesDB() {
        return schedules;
    }
}
