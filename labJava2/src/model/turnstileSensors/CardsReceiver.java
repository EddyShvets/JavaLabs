package model.turnstileSensors;

import model.card.Card;

import java.util.Calendar;

public class CardsReceiver {
    private int idOfTurnstile;
    private Calendar currentDate;
    private int idOfCard;

    public CardsReceiver(int idOfTurnstile) {
        currentDate = Calendar.getInstance();
        this.idOfTurnstile = idOfTurnstile;
    }

    public boolean processCard(Card card) {
        if (card == null || !checkExpirationDateOfCard(card) || !checkNumberOfTrips(card)) {
            return false;
        }
        decrementTrip(card);
        return true;
    }

    private void decrementTrip(Card inCard) {
        inCard.setNumberOfTrips(inCard.getNumberOfTrips() - 1);
    }

    private boolean checkExpirationDateOfCard(Card inCard) {
        return inCard.getExpirationDate().after(currentDate);
    }

    private boolean checkNumberOfTrips(Card inCard) {
        return inCard.getNumberOfTrips() > 0;
    }

    public int getIdOfCard() {
        return idOfCard;
    }

    public void setIdOfCard(int idOfCard) {
        this.idOfCard = idOfCard;
    }

    public Calendar getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Calendar currentDate) {
        this.currentDate = currentDate;
    }

}
