package kinomania;

import java.util.Random;

public class Cinema {
    private Hall[] halls;
    public String name;
    public String address;
    private int hallsNumber;
    public int[] stats;
    private Random randomizer = new Random();

    public Cinema(String name, String address, int hallsNumber, int[] seatsForEachHall, int daysAmount) {
        this.name = name;
        this.address = address;
        this.hallsNumber = hallsNumber;

        halls = new Hall[hallsNumber]; //tu bylo hallsNr-1

        for (int i = 0; i < hallsNumber; i++) {
            halls[i] = new Hall(i+1, seatsForEachHall[i], daysAmount);
        }
    }

    public boolean isMultiplex() {
        if (hallsNumber > 1) {
            return true;
        }
        return false;
    }

    public void addRepertoire(int hallNumber, Movie movie, int day) {
        halls[hallNumber].addMovie(day, movie);
       // System.out.println("Dodałem film " + movie.title);
    }

    public Movie drawMovie(int day) {
        if (!isMultiplex()) {
            return halls[0].moviesPlayed[day];
        } else {
            //Random randomizer;
            int randHall = randomizer.nextInt(halls.length);
            return halls[randHall].moviesPlayed[day];
        }
    }

    public Movie bestMovieToday(int day) {
        int max = 0;
        Movie tempBest = null;
        if (!isMultiplex()) {
            System.out.println("Little, Am I here?" + halls[0].moviesPlayed[day]);
            return halls[0].moviesPlayed[day];
        }
        else {
            for (int m = 0; m < halls.length; m++) {
                if (halls[m].moviesPlayed[day].grade > max) {
                    System.out.println("Am I here?" + halls[m].moviesPlayed[day].title);
                    tempBest = halls[m].moviesPlayed[day];
                    max = halls[m].moviesPlayed[day].grade;
                    System.out.println("Am I here? " + tempBest);

                }
            }
            return tempBest;
        }
    }

    public boolean sellTickets(int howManyTickets, int dayNumber, Movie whatMovie) {
        for (int i = 0; i < hallsNumber; i++) {
            //System.out.println("abc " + i + " hallsNr " + hallsNumber);
            if (halls[i].sellTickets(howManyTickets, whatMovie, dayNumber)) {
                System.out.println("sold tickets: " + howManyTickets);
                return true;
            }
        }
        return false;
    }

    public void writeStats(int daysAmount) {
        //System.out.println("Cinema: " + name);
        for (int day = 0; day < daysAmount; day++) {
            //System.out.println("Statistics for day number " + day);
            for (int hall = 0; hall < halls.length; hall++) {
                //System.out.println("Hall number " + hall + ", " + halls[hall].statistics(day) + " tickets sold.");
            }
        }
    }
}
