package model.DAO;

import model.dbEntity.ServiceStaff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ServiceStaffDAO extends AbstractDAO<ServiceStaff, Integer>{
    private static final String SELECT_ALL_SERVICE_STAFFES = "SELECT * FROM SERVICE_STAFF";

    public ServiceStaffDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List getAll() {
        List<ServiceStaff> listOfServiceStaffes = new LinkedList<>();
        PreparedStatement ps = getPrepareStatement(SELECT_ALL_SERVICE_STAFFES);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ServiceStaff serviceStaff = new ServiceStaff();
                serviceStaff.setStaffId(rs.getInt(1));
                serviceStaff.setIdOfPosition(rs.getInt(2));
                serviceStaff.setName(rs.getString(3));
                serviceStaff.setSurname(rs.getString(4));

                listOfServiceStaffes.add(serviceStaff);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(ps);
        }

        return listOfServiceStaffes;
    }

    @Override
    public ServiceStaff update(ServiceStaff entity) {
        return null;
    }

    @Override
    public boolean insert(ServiceStaff entity) throws SQLException {
        return false;
    }

    @Override
    public ServiceStaff getEntity(Integer id1, Integer id2) throws SQLException {
        return null;
    }
}
