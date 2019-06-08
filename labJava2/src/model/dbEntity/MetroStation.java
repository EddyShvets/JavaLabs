package model.dbEntity;

public class MetroStation {
    private int idOfStation;
    private String titleOfStation;
    private int idOfColor;
    private int idOfAdmin;

    public int getIdOfStation() {
        return idOfStation;
    }

    public void setIdOfStation(int idOfStation) {
        this.idOfStation = idOfStation;
    }

    public String getTitleOfStation() {
        return titleOfStation;
    }

    public void setTitleOfStation(String titleOfStation) {
        this.titleOfStation = titleOfStation;
    }

    public int getIdOfColor() {
        return idOfColor;
    }

    public void setIdOfColor(int idOfColor) {
        this.idOfColor = idOfColor;
    }

    public int getIdOfAdmin() {
        return idOfAdmin;
    }

    public void setIdOfAdmin(int idOfAdmin) {
        this.idOfAdmin = idOfAdmin;
    }

    @Override
    public String toString() {
        return "MetroStation{" +
                "idOfStation=" + idOfStation +
                ", titleOfStation='" + titleOfStation + '\'' +
                ", idOfColor=" + idOfColor +
                ", idOfAdmin=" + idOfAdmin +
                '}';
    }
}
