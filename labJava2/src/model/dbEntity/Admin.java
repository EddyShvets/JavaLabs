package model.dbEntity;

import java.io.Serializable;

public class Admin implements Serializable {
    private int idOfAdmin;
    private int staffId;
    private String login;
    private String password;

    public Admin() {
    }

    public Admin(int idOfAdmin, int staffId, String login, String password) {
        this.idOfAdmin = idOfAdmin;
        this.staffId = staffId;
        this.login = login;
        this.password = password;
    }

    public int getIdOfAdmin() {
        return idOfAdmin;
    }

    public void setIdOfAdmin(int idOfAdmin) {
        this.idOfAdmin = idOfAdmin;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "idOfAdmin=" + idOfAdmin +
                ", staffId=" + staffId +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
