package model.DAO;

import model.dbEntity.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class AdminsDAO extends AbstractDAO<Admin, String> {
    private static final String SELECT_ALL_ADMINS = "SELECT * FROM ADMINS";
    private static final String SELECT_ADMIN = "SELECT * FROM ADMINS WHERE login = ? AND password = ?";

    public AdminsDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List<Admin> getAll() {
        List<Admin> listOfAdmins = new LinkedList<>();
        PreparedStatement ps = getPrepareStatement(SELECT_ALL_ADMINS);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Admin admin = new Admin();
                admin.setIdOfAdmin(rs.getInt(1));
                admin.setStaffId(rs.getInt(2));
                admin.setLogin(rs.getString(3));
                admin.setPassword(rs.getString(4));

                listOfAdmins.add(admin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(ps);
        }

        return listOfAdmins;
    }

    @Override
    public Admin update(Admin entity) {
        return null;
    }

    @Override
    public boolean insert(Admin entity) throws SQLException {
        return false;
    }

    @Override
    public Admin getEntity(String strLogin, String strPassword) throws SQLException {
        PreparedStatement ps = getPrepareStatement(SELECT_ADMIN);
        ps.setString(1, strLogin);
        ps.setString(2, strPassword);

        Admin admin = new Admin();
        try {
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                admin.setIdOfAdmin(rs.getInt(1));
                admin.setStaffId(rs.getInt(2));
                admin.setLogin(rs.getString(3));
                admin.setPassword(rs.getString(4));
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(ps);
        }
        return admin;
    }
}