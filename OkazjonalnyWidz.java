package kinomania;

public class OkazjonalnyWidz extends Inhabitant{

    public boolean isGoingToCinemaToday() {
        if (rndm.nextInt(100) + 1 > 95) {
            return true;
        }
        return false;
    }

}

