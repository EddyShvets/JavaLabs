package model.turnstileSensors;

public class OpticalSensor {
    private int idOfTurnStile;
    private boolean flag = false;

    public OpticalSensor(int idOfTurnstile) {
        this.idOfTurnStile = idOfTurnstile;
    }

    public void changeStateOnTrue() {
        flag = true;
    }

    public void changeStateOnFalse() {
        flag = false;
    }

    private boolean sendSignalToTimer() {
        // TODO
        return false;
    }

    public int getIdOfTurnStile() {
        return idOfTurnStile;
    }

    public void setIdOfTurnStile(int idOfTurnStile) {
        this.idOfTurnStile = idOfTurnStile;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
