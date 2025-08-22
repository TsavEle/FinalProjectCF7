package finalProject.dao;

import finalProject.model.City;

import java.sql.SQLException;
import java.util.List;

public interface ICityDAO {
    List<City> getAll()
            throws SQLException;
    City getCityById(Integer cityId)
            throws SQLException;
}
