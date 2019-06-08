package model.turnstileSensors;

public class Indicator {
    private int idOfTurnstile;
    private String indicatorString;

    public Indicator(int idOfTurnstile) {
        this.idOfTurnstile = idOfTurnstile;
        this.indicatorString = "STOP";
    }

    public void changeOnSTOP() {
        indicatorString = "STOP";
    }

    public void changeOnPASS() {
        indicatorString = "PASS";
    }

    public void changeOnWARNING() {
        indicatorString = "WARNING";
    }

    public int getIdOfTurnstile() {
        return idOfTurnstile;
    }

    public void setIdOfTurnstile(int idOfTurnstile) {
        this.idOfTurnstile = idOfTurnstile;
    }

    public String getIndicatorString() {
        return indicatorString;
    }

    public void setIndicatorString(String indicatorString) {
        this.indicatorString = indicatorString;
    }
}
