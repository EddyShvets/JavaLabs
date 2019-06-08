package model.dbEntity;

public class Turnstile {
    private int turnstileId;
    private int idOfStation;
    private int staffId;

    public int getTurnstileId() {
        return turnstileId;
    }

    public void setTurnstileId(int turnstileId) {
        this.turnstileId = turnstileId;
    }

    public int getIdOfStation() {
        return idOfStation;
    }

    public void setIdOfStation(int idOfStation) {
        this.idOfStation = idOfStation;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    @Override
    public String toString() {
        return "Turnstile{" +
                "turnstileId=" + turnstileId +
                ", idOfStation=" + idOfStation +
                ", staffId=" + staffId +
                '}';
    }
}
