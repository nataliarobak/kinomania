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
            System.out.println("abcd");
            this.freeSeatsNumber[i] = freeSeats;
            moviesPlayed[i] = null;
        }
    }

    public void addMovie(int dayNumber, Movie m) {
        moviesPlayed[dayNumber] = m;
    }

    public boolean sellTickets(int howManyTickets, Movie whatMovie, int dayNumber) {
        if (whatMovie != moviesPlayed[dayNumber]) {
            return false;
        }
        if (freeSeatsNumber[dayNumber] - howManyTickets < 0) {
            freeSeatsNumber[dayNumber] -= howManyTickets;
            return false;
        }
        statistics(dayNumber );
        return true;
    }

    public void statistics(int dayNumber) {
        if (moviesPlayed[dayNumber] != null) {
            stats[dayNumber] += totalSeatsNumber - freeSeatsNumber[dayNumber];
        }
        else stats[dayNumber] = 0;
    }
}
