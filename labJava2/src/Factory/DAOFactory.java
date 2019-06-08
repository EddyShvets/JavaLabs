package Factory;

import model.DAO.*;
import model.db.Database;

import java.util.HashMap;
import java.util.Map;

public class DAOFactory {
    private static DAOFactory instance;
    private Database database;
    private Map<String, AbstractDAO> mapOfDAOs;


    public static DAOFactory getInstance() {
        if (instance == null)
            instance = new DAOFactory();
        return instance;
    }

    private DAOFactory() {
        database = new Database();
        mapOfDAOs = new HashMap<>();

        mapOfDAOs.put("AdminsDAO", new AdminsDAO(database.getConn()));
        mapOfDAOs.put("ColorMetroLineDAO", new ColorMetroLineDAO(database.getConn()));
        mapOfDAOs.put("MetroStationsDAO", new MetroStationsDAO(database.getConn()));
        mapOfDAOs.put("PassesThroughTurnstilesDAO", new PassesThroughTurnstilesDAO(database.getConn()));
        mapOfDAOs.put("PositionDAO", new PositionDAO(database.getConn()));
        mapOfDAOs.put("ServiceStaffDAO", new ServiceStaffDAO(database.getConn()));
        mapOfDAOs.put("TurnstilesDAO", new TurnstilesDAO(database.getConn()));
    }

    public AbstractDAO getDAO(String dao) {
        return mapOfDAOs.get(dao);
    }
}

