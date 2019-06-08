package model.dbEntity;

public class MetroLine {
    private int idOfColor;
    private String color;

    public int getIdOfColor() {
        return idOfColor;
    }

    public void setIdOfColor(int idOfColor) {
        this.idOfColor = idOfColor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "MetroLine{" +
                "idOfColor=" + idOfColor +
                ", color='" + color + '\'' +
                '}';
    }
}
