package model.DAO;

import model.dbEntity.MetroStation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class MetroStationsDAO extends AbstractDAO<MetroStation, Integer>{
    private static final String SELECT_ALL_COLOR_METRO_STATIONS = "SELECT * FROM METRO_STATION";

    public MetroStationsDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List getAll() {
        List<MetroStation> listOfMetroStations = new LinkedList<>();
        PreparedStatement ps = getPrepareStatement(SELECT_ALL_COLOR_METRO_STATIONS);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MetroStation metroStations = new MetroStation();
                metroStations.setIdOfStation(rs.getInt(1));
                metroStations.setTitleOfStation(rs.getString(2));
                metroStations.setIdOfColor(rs.getInt(3));
                metroStations.setIdOfAdmin(rs.getInt(4));

                listOfMetroStations.add(metroStations);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(ps);
        }

        return listOfMetroStations;
    }

    @Override
    public MetroStation update(MetroStation entity) {
        return null;
    }

    @Override
    public boolean insert(MetroStation entity) throws SQLException {
        return false;
    }

    @Override
    public MetroStation getEntity(Integer id1, Integer id2) throws SQLException {
        return null;
    }
}
