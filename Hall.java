package kinomania;

public class Hall {
    public int number;
    public int totalSeatsNumber;
    public int[] freeSeatsNumber;
    public Movie[] moviesPlayed;
    public int[] stats;

    public Hall(int hallNumber, int freeSeats, int daysAmount) {
        this.number = hallNumber;
        this.totalSeatsNumber = freeSeats;

        freeSeatsNumber = new int[daysAmount]; //tu wszwdzie bylo daysamount-1
        moviesPlayed = new Movie[daysAmount];
        stats = new int[daysAmount];

        for (int i = 0; i < daysAmount; i++) {
            this.freeSeatsNumber[i] = freeSeats;
            moviesPlayed[i] = null;
        }
    }

    public void addMovie(int dayNumber, Movie m) {
        moviesPlayed[dayNumber] = m;
        //System.out.println("Wpisuje film " + m.title + " do " + moviesPlayed[dayNumber].title + " dnia " + dayNumber); //dobrze
    }

    public boolean sellTickets(int howManyTickets, Movie whatMovie, int dayNumber) {
        if (moviesPlayed[dayNumber] == null) return false;
        if (whatMovie != moviesPlayed[dayNumber]) {
            System.out.println("fałszz" + whatMovie.title + " day " + dayNumber); //+ moviesPlayed[dayNumber].title); - tu jest null :o
            return false;
        }
        if (freeSeatsNumber[dayNumber] - howManyTickets < 0) {
            System.out.println("fałsz nr 2");
            freeSeatsNumber[dayNumber] -= howManyTickets;
            return false;
        }
        //statistics(dayNumber);
        System.out.println("true");
        return true;
    }

    public int statistics(int dayNumber) {
        if (moviesPlayed[dayNumber] != null) {
            System.out.println(totalSeatsNumber - freeSeatsNumber[dayNumber]);
            return totalSeatsNumber - freeSeatsNumber[dayNumber];
        } else {
        System.out.println("zero" + 0);
        return 0; }
    }

/*
    public void statistics(int dayNumber) {
        if (moviesPlayed[dayNumber] != null) {
            stats[dayNumber] += totalSeatsNumber - freeSeatsNumber[dayNumber];
            System.out.println(totalSeatsNumber - freeSeatsNumber[dayNumber]);
            System.out.println(stats[dayNumber]);
        }
        else {
            System.out.println(0);
            stats[dayNumber] = 0; }
    }
 */
}
