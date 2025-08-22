package finalProject.service;

import finalProject.dao.ICityDAO;
import finalProject.model.City;

import java.sql.SQLException;
import java.util.List;

public class CityServiceImpl implements ICityDAO {
    private final ICityDAO dao;

    public CityServiceImpl(ICityDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<City> getAll() throws SQLException {
        try {
            return dao.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public City getCityById(Integer cityId) throws SQLException {
        return null;
    }
}
