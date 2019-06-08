package model.DAO;

import model.dbEntity.Position;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class PositionDAO extends AbstractDAO<Position, Integer>{
    private static final String SELECT_ALL_POSITIONS = "SELECT * FROM POSITION";

    public PositionDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List getAll() {
        List<Position> listOfPositions = new LinkedList<>();
        PreparedStatement ps = getPrepareStatement(SELECT_ALL_POSITIONS);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Position position = new Position();
                position.setIdOfPosition(rs.getInt(1));
                position.setPosition(rs.getString(2));

                listOfPositions.add(position);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(ps);
        }

        return listOfPositions;
    }

    @Override
    public Position update(Position entity) {
        return null;
    }

    @Override
    public boolean insert(Position entity) throws SQLException {
        return false;
    }

    @Override
    public Position getEntity(Integer id1, Integer id2) throws SQLException {
        return null;
    }
}
