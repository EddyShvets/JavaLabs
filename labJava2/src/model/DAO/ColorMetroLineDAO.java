package model.DAO;

import model.dbEntity.MetroLine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ColorMetroLineDAO extends AbstractDAO<MetroLine, Integer>{
    private static final String SELECT_ALL_COLOR_METRO_LINE = "SELECT * FROM COLOR_METRO_LINE";

    public ColorMetroLineDAO(Connection connection) {
        super(connection);
    }

    @Override
    public List getAll() {
        List<MetroLine> listOfMetroLines = new LinkedList<>();
        PreparedStatement ps = getPrepareStatement(SELECT_ALL_COLOR_METRO_LINE);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MetroLine metroLine = new MetroLine();
                metroLine.setIdOfColor(rs.getInt(1));
                metroLine.setColor(rs.getString(2));

                listOfMetroLines.add(metroLine);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(ps);
        }

        return listOfMetroLines;
    }

    @Override
    public MetroLine update(MetroLine entity) {
        return null;
    }

    @Override
    public boolean insert(MetroLine entity) throws SQLException {
        return false;
    }

    @Override
    public MetroLine getEntity(Integer id1, Integer id2) throws SQLException {
        return null;
    }
}
