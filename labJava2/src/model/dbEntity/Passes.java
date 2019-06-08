package model.dbEntity;

import java.time.LocalDateTime;

public class Passes {
    private int id;
    private int turnstileId;
    private int numOfPasses;
    private LocalDateTime currentDay;

    public Passes() {
    }

    public Passes(int turnstileId, int numOfPasses, LocalDateTime currentDay) {
        this.turnstileId = turnstileId;
        this.numOfPasses = numOfPasses;
        this.currentDay = currentDay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTurnstileId() {
        return turnstileId;
    }

    public void setTurnstileId(int turnstileId) {
        this.turnstileId = turnstileId;
    }

    public int getNumOfPasses() {
        return numOfPasses;
    }

    public void setNumOfPasses(int numOfPasses) {
        this.numOfPasses = numOfPasses;
    }

    public LocalDateTime getCurrentDay() {
        return currentDay;
    }

    public void setCurrentDay(LocalDateTime currentDay) {
        this.currentDay = currentDay;
    }

    @Override
    public String toString() {
        return "Passes{" +
                "id=" + id +
                ", turnstileId=" + turnstileId +
                ", numOfPasses=" + numOfPasses +
                '}';
    }
}
