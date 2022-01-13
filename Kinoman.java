package kinomania;

public class Kinoman extends Inhabitant {
    public int startDay; //when does Kinoman start going to the cinema - day 0, 1 or 2

    public Kinoman() {
        startDay = rndm.nextInt(3);
    }
}
