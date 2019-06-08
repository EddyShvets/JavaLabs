package model.card;

import java.util.Calendar;

public class Card {
    private int     id;
    private Calendar expirationDate;
    private int     numberOfTrips;

    public Card(int id, Calendar expirationDate, int numberOfTrips) {
        if(numberOfTrips < 0) {
            throw new IllegalArgumentException("ERROR: Invalid number of trips!");
        }
        this.id = id;
        this.expirationDate = expirationDate;
        this.numberOfTrips = numberOfTrips;
    }

    public Calendar getExpirationDate() { return expirationDate; }

    public void setExpirationDate(Calendar expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getNumberOfTrips() {
        return numberOfTrips;
    }

    public void setNumberOfTrips(int numberOfTrips) {
        this.numberOfTrips = numberOfTrips;
    }

    public int getId() {
        return id;
    }
}