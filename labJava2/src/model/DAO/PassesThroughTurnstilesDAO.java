package model.DAO;

import Converter.Converter;
import model.dbEntity.Passes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class PassesThroughTurnstilesDAO extends AbstractDAO<Passes, Integer> {
    private static final String SELECT_ALL_PASSES = "SELECT * FROM PASSES_STATISTIC";
    private static final String INSERT_INTO_TABLE = "INSERT INTO PASSES_STATISTIC(turnstile_id, num_of_passes, date)\n" +
            "VALUES (?, ?, ?);\n";

    public PassesThroughTurnstilesDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List getAll() {
        List<Passes> listOfPasses = new LinkedList<>();
        PreparedStatement ps = getPrepareStatement(SELECT_ALL_PASSES);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Passes passes = new Passes();
                passes.setId(rs.getInt(1));
                passes.setTurnstileId(rs.getInt(2));
                passes.setNumOfPasses(rs.getInt(3));
                passes.setCurrentDay(Converter.toLocalDateTime(rs.getTimestamp(4)));

                listOfPasses.add(passes);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(ps);
        }

        return listOfPasses;
    }

    @Override
    public Passes update(Passes entity) {
        return null;
    }

    @Override
    public boolean insert(Passes entity) throws SQLException {
        PreparedStatement ps = getPrepareStatement(INSERT_INTO_TABLE);

        ps.setInt(1, entity.getTurnstileId());
        ps.setInt(2, entity.getNumOfPasses());
        ps.setTimestamp(3, Converter.toTimestamp(entity.getCurrentDay()));
        ps.executeUpdate();

        return true;
    }

    @Override
    public Passes getEntity(Integer id1, Integer id2) throws SQLException {
        return null;
    }

}
