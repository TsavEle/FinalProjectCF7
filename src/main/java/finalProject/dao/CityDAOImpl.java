package finalProject.dao;

import finalProject.Util.DBUtil;
import finalProject.dao.daoUtil.SQLQueries;
import finalProject.model.City;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDAOImpl implements ICityDAO{

    @Override
    public List<City> getAll() throws SQLException {

        List<City> cities = new ArrayList<>();

        try(Connection connection = DBUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQLQueries.GET_ALL_CITIES)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");

                City city = new City(id, name);
                cities.add(city);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return cities;
    }

    @Override
    public City getCityById(Integer cityId) throws SQLException {
        City city = null;
        try(Connection connection = DBUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQLQueries.GET_CITY_BY_ID)) {
            ps.setInt(1, cityId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                city = new City(rs.getInt("id"),
                        rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error in SQL. Could not get city");
        }
        return city;
    }
}
