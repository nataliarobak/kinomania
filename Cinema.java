package kinomania;

public class Cinema {
    private Hall[] halls;
    public String name;
    public String address;
    private int hallsNumber;

    //konstruktor wypelnia halls[] salami o konkretnym numerze, ilosci foteli, dniami symulacji
    public Cinema(String name, String address, int hallsNumber, int[] seatsForEachHall, int daysAmount) {
        this.name = name;
        this.address = address;
        this.hallsNumber = hallsNumber;

        halls = new Hall[hallsNumber]; //tu bylo hallsNr-1

        for (int i = 0; i < hallsNumber; i++) {
            halls[i] = new Hall(i+1, seatsForEachHall[i], daysAmount);
            System.out.println("ab");
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
    }

    public boolean sellTickets(int howManyTickets, int dayNumber, Movie whatMovie) {
        for (int i = 0; i < hallsNumber; i++) {
            System.out.println("abc " + i + " hallsNr " + hallsNumber);
            if (halls[i].sellTickets(howManyTickets, whatMovie, dayNumber)) {
                System.out.println("w ifie");
                return true;
            }
        }
        return false;
    }

    public void writeStats(int daysAmount) {
        System.out.println("Cinema:" + name);
        for (int day = 0; day < daysAmount; day++) {
            System.out.println("Statistics for day number " + day+1);
            for (int hall = 0; hall < halls.length; hall++) {
                System.out.println("Hall number " + hall + ", " + halls[day].stats[day] + " tickets sold");
            }
        }
    }
}
