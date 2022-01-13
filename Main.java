package main;
import kinomania.City;
import kinomania.Movie;

public class Main {
    public static void main(String[] args) {

        City Gorlice = new City();
        Gorlice.cityName = "Gorlice";
        Gorlice.initData(5);
        Gorlice.runSimulation(5);
        //Gorlice.writeStatistics;

    }
}
