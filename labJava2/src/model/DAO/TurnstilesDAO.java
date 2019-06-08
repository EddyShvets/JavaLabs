package model.DAO;

import model.dbEntity.Turnstile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class TurnstilesDAO extends AbstractDAO<Turnstile, Integer>{
    private static final String SELECT_ALL_TURNSTILES = "SELECT * FROM TURNSTILES";

    public TurnstilesDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List getAll() {
        List<Turnstile> listOfTurnstiles = new LinkedList<>();
        PreparedStatement ps = getPrepareStatement(SELECT_ALL_TURNSTILES);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Turnstile turnstiles = new Turnstile();
                turnstiles.setTurnstileId(rs.getInt(1));
                turnstiles.setIdOfStation(rs.getInt(2));
                turnstiles.setStaffId(rs.getInt(3));

                listOfTurnstiles.add(turnstiles);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(ps);
        }

        return listOfTurnstiles;
    }

    @Override
    public Turnstile update(Turnstile entity) {
        return null;
    }

    @Override
    public boolean insert(Turnstile entity) throws SQLException {
        return false;
    }

    @Override
    public Turnstile getEntity(Integer id1, Integer id2) throws SQLException {
        return null;
    }

}
