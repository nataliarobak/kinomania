package kinomania;
import java.util.Random;

public class City {
    public String cityName;
    private Inhabitant[] inhabitants;
    public Cinema[] cinemas;
    public Movie[] movies;
    private Random randomizer = new Random();

//void init data, wprowadzenie przykladow do symulacji

    public void initData(int howManyDays) {
        inhabitants = new Inhabitant[21];
        inhabitants[0] = new Kinoman();
        inhabitants[1] = new Koneser();
        inhabitants[2] = new Kinoman();
        inhabitants[3] = new OkazjonalnyWidz();
        inhabitants[4] = new Koneser();
        inhabitants[5] = new Koneser();
        inhabitants[6] = new Kinoman();
        inhabitants[7] = new OkazjonalnyWidz();
        inhabitants[8] = new Other();
        inhabitants[9] = new Koneser();
        inhabitants[10] = new Kinoman();
        inhabitants[11] = new Kinoman();
        inhabitants[12] = new Kinoman();
        inhabitants[13] = new Koneser();
        inhabitants[14] = new Kinoman();
        inhabitants[15] = new OkazjonalnyWidz();
        inhabitants[16] = new Kinoman();
        inhabitants[17] = new Koneser();
        inhabitants[18] = new Kinoman();
        inhabitants[19] = new OkazjonalnyWidz();
        inhabitants[20] = new Other();

        movies = new Movie[5];
        String[] moviesTitles = {"Bolt", "The Godfather 1", "Star Trek: The Next Generation", "Notting Hill", "Chocolate"};
        int[] grades = {6, 8, 8, 7, 2};

        for (int i = 0; i < 5; i++) {
            movies[i] = new Movie();
            movies[i].title = moviesTitles[i];
            movies[i].grade = grades[i];
        }

        cinemas = new Cinema[4];
        String[] names = {"Multi 1", "Little 1", "Little 2", "Multi 2"};
        String[] addresses = {"abc", "def", "ghi", "jkl"};
        int[] hallsNumbers = {4, 1, 1, 2};
        int[][] seatsArr = {{20, 15, 30, 10}, {30}, {40}, {10, 20, 30}};
        for (int j = 0; j < 4; j++) {
            cinemas[j] = new Cinema(names[j], addresses[j], hallsNumbers[j], seatsArr[j], howManyDays);
            System.out.println("a");
        }
    }

    public void runSimulation(int howManyDays) {
        for (int day = 0; day < howManyDays; day++) {
            System.out.println("run for day: " + day);
            for (int i = 0; i < inhabitants.length; i++) {
                System.out.println("run inhabitant: " +inhabitants[i] + " day "+ day);
                if (inhabitants[i].getClass() == Koneser.class) {
                    System.out.println("run for koneser");
                    Movie m = ((Koneser)inhabitants[i]).chooseMovie(movies);
                    if (m != null) {
                        boolean success = false;
                        int c = 0;
                        while (c < cinemas.length && !success) {
                            success = cinemas[c].sellTickets(1, day, m);
                            //System.out.println("pierwsze wywołanie sell tickets w koneserze");
                            if (success) {
                                //System.out.println("drugie wywołanie sell tickets w koneserze");
                                inhabitants[i].goToCinema(1, cinemas[c], m);
                            }
                        }
                    }
                }
                else if (inhabitants[i].getClass() == Kinoman.class) {
                    System.out.println("run for kinoman");
                    //kwestia dnia rozpoczecia chodzenia do kina
                    if (day % 3 == ((Kinoman)inhabitants[i]).startDay) {
                        int randomForCinema = randomizer.nextInt(cinemas.length);
                        int randomForGuests = randomizer.nextInt(8) + 1;
                        int randomForMovies = randomizer.nextInt(movies.length);
                        if (cinemas[randomForCinema].sellTickets(randomForGuests, day, movies[randomForMovies])) {
                            System.out.println("wywołanie sell tickets w kinomanie");
                            inhabitants[i].goToCinema(randomForGuests, cinemas[randomForCinema], movies[randomForMovies]);
                        }
                    }
                }
                else if (inhabitants[i].getClass() == OkazjonalnyWidz.class) {
                    System.out.println("run for okazjonalny");
                    if (((OkazjonalnyWidz)inhabitants[i]).isGoingToCinemaToday()) {
                        System.out.println("wywołanie sell tickets w okazjonalnym");
                        int randomForCinema2 = randomizer.nextInt(cinemas.length);
                        int randomForMovie2 = randomizer.nextInt(movies.length);
                        if (cinemas[randomForCinema2].sellTickets(1, day, movies[randomForMovie2])) {
                            inhabitants[i].goToCinema(1, cinemas[randomForCinema2], movies[randomForMovie2]);
                        }
                    }
                }
                else if (inhabitants[i].getClass() == Other.class) {
                    inhabitants[i].goToCinema(0,null,null);
                }
            }
        }

    }
}
