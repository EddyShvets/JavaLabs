package model.dbEntity;

public class ServiceStaff {
    private int staffId;
    private int idOfPosition;
    private String name;
    private String surname;

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public int getIdOfPosition() {
        return idOfPosition;
    }

    public void setIdOfPosition(int idOfPosition) {
        this.idOfPosition = idOfPosition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "ServiceStaff{" +
                "staffId=" + staffId +
                ", idOfPosition=" + idOfPosition +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
