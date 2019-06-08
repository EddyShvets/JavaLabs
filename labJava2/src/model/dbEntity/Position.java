package model.dbEntity;

public class Position {
    private int idOfPosition;
    private String position;

    public int getIdOfPosition() {
        return idOfPosition;
    }

    public void setIdOfPosition(int idOfPosition) {
        this.idOfPosition = idOfPosition;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Position{" +
                "idOfPosition=" + idOfPosition +
                ", position='" + position + '\'' +
                '}';
    }
}
