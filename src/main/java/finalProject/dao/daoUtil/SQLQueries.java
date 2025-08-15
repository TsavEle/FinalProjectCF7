package finalProject.dao.daoUtil;

public class SQLQueries {

    public static final String GET_LAWYERS_BY_SKILL =
            "SELECT l.*, s.id AS skill_id, s.name AS skill_name " +
                    "FROM lawyers l " +
                    "JOIN lawyers_skills ls ON l.id = ls.lawyer_id " +
                    "JOIN skills s ON ls.skill_id = s.id " +
                    "WHERE s.name LIKE ?";

    public static final String GET_LAWYER_BY_ID =
            "SELECT * FROM lawyers WHERE id = ?";

    public static final String GET_LAWYER_BY_CITY =
            "SELECT l.* " +
                    "FROM lawyers l " +
                    "JOIN cities c ON l.city_id = c.id " +
                    "WHERE c.name = ?";

    public static final String INSERT_LAWYER =
            "INSERT INTO lawyers " +
                    "(firstname, lastname, phoneNumber, zipcode, streetName, streetNumber, email, vat, city_id, uuid, created_at, updated_at)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";


    public static final String GET_LAWYER_BY_LASTNAME =
            "SELECT * FROM lawyers WHERE lastname = ?";

    public static final String GET_LAWYER_BY_UUID =
            "SELECT * FROM lawyers WHERE uuid = ?";

    public static final String GET_ALL_LAWYERS =
            "SELECT * FROM lawyers";

    public static final String DELETE_LAWYER =
            "DELETE FROM lawyers WHERE id = ?";

    public static final String UPDATE_LAWYER =
            "UPDATE lawyers SET firstname=?, lastname=?, phoneNumber=?, zipcode=?, streetName=?, streetNumber=?, email=?, vat=?, city_id=?, updated_at=?";

    public static final String  ADD_SKILLS_TO_LAWYERS =
            "INSERT INTO lawyers_skills (lawyer_id, skill_id) VALUES (?, ?)";

    public static final String DELETE_SKILLS_FROM_LAWYER =
            "DELETE FROM lawyers_skills" +
                    "WHERE lawyer_id = ?";



}

