package finalProject.dao.daoUtil;

public class SQLQueries {

    public static final String GET_LAWYERS_BY_SKILL =
            "SELECT l.*, s.skill_id AS skill_id, s.skill_name AS skill_name " +
                    "FROM lawyers l " +
                    "JOIN lawyer_skills ls ON l.id = ls.lawyer_id " +
                    "JOIN skills s ON ls.skill_id = s.skill_id " +
                    "WHERE s.skill_name LIKE ?";

    public static final String GET_LAWYER_BY_ID =
            "SELECT * FROM lawyers WHERE id = ?";

    public static final String GET_LAWYER_BY_CITY =
            "SELECT l.* " +
                    "FROM lawyers l " +
                    "JOIN cities c ON l.city_id = c.id " +
                    "WHERE c.name = ?";

    public static final String INSERT_LAWYER =
            "INSERT INTO lawyers " +
                    "(firstname, lastname, phoneNumber, zipcode, streetName, streetNumber, email, vat, cityId, uuid, createdAt, updatedAt)" +
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
            "UPDATE lawyers SET firstname=?, lastname=?, phoneNumber=?, zipcode=?, streetName=?, " +
                    "streetNumber=?, email=?, vat=?, cityId=?, `updatedAt`=? " +  // note the space at the end
                    "WHERE id=?";

    public static final String  ADD_SKILLS_TO_LAWYERS =
            "INSERT INTO lawyer_skills (lawyer_id, skill_id) VALUES (?, ?)";

    public static final String DELETE_SKILLS_FROM_LAWYER =
            "DELETE FROM lawyer_skills WHERE lawyer_id = ?";


    public static final String GET_SKILLS_BY_LAWYER_ID =
            "SELECT s.skill_id AS id, s.skill_name AS name " +
                    "FROM skills s " +
                    "JOIN lawyer_skills ls ON ls.skill_id = s.skill_id " +
                    "WHERE ls.lawyer_id = ?";


    public static final String GET_ALL_CITIES =
            "SELECT * FROM cities order by name asc";

    public static final String GET_CITY_BY_ID =
            "SELECT * FROM cities WHERE id = ?";

    public static final String GET_ALL_SKILLS =
            "SELECT * FROM skills order by skill_name asc";

    public static final String GET_SKILL_BY_ID =
            "SELECT * FROM skills WHERE skill_id = ?";

    public static final String GET_LAWYER_BY_VAT =
            "SELECT * FROM lawyers WHERE vat = ?";

    public static final String GET_LAWYER_BY_EMAIL =
            "SELECT * FROM lawyers WHERE email = ?";

    public static final String GET_SKILL_BY_SKILL_NAME =
            "SELECT * FROM skills WHERE skill_name = ?";
}

