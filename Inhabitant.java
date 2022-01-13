package kinomania;
import java.util.Random;

abstract class Inhabitant {
    public int ticketsBought;
    //public String name;
    //private City whatCity;
    static protected Random rndm = new Random();


    public void goToCinema(int howMany, Cinema whatCinema, Movie whatMovie) {
        ticketsBought += howMany;
    }
}
