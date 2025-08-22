package finalProject.service;

import finalProject.model.City;

import java.sql.SQLException;
import java.util.List;

public interface ICityService {
    List<City> getAllCities()
        throws SQLException;
}
