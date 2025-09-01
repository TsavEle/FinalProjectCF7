package finalProject.dao;

import finalProject.Util.DBUtil;
import finalProject.dao.daoUtil.SQLQueries;
import finalProject.exceptions.LawyerDAOException;
import finalProject.model.Lawyer;
import finalProject.model.Skill;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;

public class LawyerDAOImpl implements ILawyerDAO {

    @Override
    public Lawyer insert(Lawyer lawyer, List<Integer> selectedSkillIds) throws LawyerDAOException {
        Lawyer insertedLawyer = null;

        try (Connection connection = DBUtil.getConnection()) {

            try (PreparedStatement ps = connection.prepareStatement(SQLQueries.INSERT_LAWYER, Statement.RETURN_GENERATED_KEYS)){
                ps.setString(1, lawyer.getFirstname());
                ps.setString(2, lawyer.getLastname());
                ps.setString(3, lawyer.getPhoneNumber());
                ps.setString(4, lawyer.getZipcode());
                ps.setString(5, lawyer.getStreetName());
                ps.setString(6, lawyer.getStreetNumber());
                ps.setString(7, lawyer.getEmail());
                ps.setString(8, lawyer.getVat());
                 ps.setInt(9, lawyer.getCityId());
                ps.setString(10, UUID.randomUUID().toString());
                ps.setTimestamp(11, Timestamp.valueOf(LocalDateTime.now()));
                ps.setTimestamp(12, Timestamp.valueOf(LocalDateTime.now()));

                int rowsAffected = ps.executeUpdate();
                System.out.println("Rows inserted: " + rowsAffected);

                ResultSet rsGeneratedKeys = ps.getGeneratedKeys();
                if (rsGeneratedKeys.next()) {
                    int generatedId = rsGeneratedKeys.getInt(1);
                    insertedLawyer = getById(generatedId);
                } else {
                    throw new LawyerDAOException("Failed to get generated lawyer Id.");
                }

            }

            try (PreparedStatement ps = connection.prepareStatement(SQLQueries.ADD_SKILLS_TO_LAWYERS)){
                for (Integer skillId : selectedSkillIds) {
                    ps.setInt(1, insertedLawyer.getId());
                    ps.setInt(2, skillId);
                    ps.executeUpdate();
                }
            }
            return insertedLawyer;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new LawyerDAOException("SQL error in insert.");
        }
    }

    @Override
    public Lawyer update(Lawyer lawyer, List<Integer> selectedSkillsIds) throws LawyerDAOException {
        Lawyer updatedLawyer = null;

        try (Connection connection = DBUtil.getConnection()){

            try (PreparedStatement ps = connection.prepareStatement(SQLQueries.UPDATE_LAWYER)) {
                ps.setString(1, lawyer.getFirstname());
                ps.setString(2, lawyer.getLastname());
                ps.setString(3, lawyer.getPhoneNumber());
                ps.setString(4, lawyer.getZipcode());
                ps.setString(5, lawyer.getStreetName());
                ps.setString(6, lawyer.getStreetNumber());
                ps.setString(7, lawyer.getEmail());
                ps.setString(8, lawyer.getVat());
                ps.setInt(9, lawyer.getCityId());
                ps.setTimestamp(10, Timestamp.valueOf(LocalDateTime.now())); // updated_at
                ps.setInt(11, lawyer.getId()); // WHERE id=?

                ps.executeUpdate();
            }

            try (PreparedStatement ps = connection.prepareStatement(SQLQueries.DELETE_SKILLS_FROM_LAWYER)){
                ps.setInt(1, lawyer.getId());
                ps.executeUpdate();

            }

            try (PreparedStatement ps = connection.prepareStatement(SQLQueries.ADD_SKILLS_TO_LAWYERS)){
                for (Integer skillId : selectedSkillsIds) {
                    ps.setInt(1, lawyer.getId());
                    ps.setInt(2, skillId);
                    ps.executeUpdate();
                }
            }
            updatedLawyer = getById(lawyer.getId());

        } catch (SQLException e) {
            e.printStackTrace();
            throw new LawyerDAOException("SQL error in update");
        }
        return updatedLawyer;
    }

    @Override
    public void delete(Integer id) throws LawyerDAOException {
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQLQueries.DELETE_LAWYER)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new LawyerDAOException("SQL error in deleting lawyer with id: " + id);
        }
    }

    @Override
    public Lawyer getById(Integer id) throws LawyerDAOException {
        Lawyer lawyer = null;

        try(Connection connection = DBUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQLQueries.GET_LAWYER_BY_ID)) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    lawyer = new Lawyer(
                            rs.getInt("id"),
                            rs.getString("firstname"),
                            rs.getString("lastname"),
                            rs.getString("phoneNumber"),
                            rs.getString("zipcode"),
                            rs.getString("streetName"),
                            rs.getString("streetNumber"),
                            rs.getString("email"),
                            rs.getString("vat"),
                            rs.getInt("cityId"),
                            rs.getString("uuid"),
                            rs.getTimestamp("createdAt").toLocalDateTime(),
                            rs.getTimestamp("updatedAt").toLocalDateTime(),
                            getSkillsByLawyerId(rs.getInt("id"))
                    );
                }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new LawyerDAOException("SQL error in getById for lawyer with id: " + id);
        }
        return lawyer;
    }

    @Override
    public List<Lawyer> getAll() throws LawyerDAOException {
        Lawyer lawyer;
        List<Lawyer> lawyers = new ArrayList<>();
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQLQueries.GET_ALL_LAWYERS)){
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                lawyer = new Lawyer(rs.getInt("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("phoneNumber"),
                        rs.getString("zipcode"),
                        rs.getString("streetName"),
                        rs.getString("streetNumber"),
                        rs.getString("email"),
                        rs.getString("vat"),
                        rs.getInt("cityId"),
                        rs.getString("uuid"),
                        rs.getTimestamp("createdAt").toLocalDateTime(),
                        rs.getTimestamp("updatedAt").toLocalDateTime(),
                        getSkillsByLawyerId(rs.getInt("id")));
                lawyers.add(lawyer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new LawyerDAOException("SQL error in getAll");
        }
        return lawyers;
    }

    @Override
    public Lawyer getByUUID(String uuid) throws LawyerDAOException {
        Lawyer lawyer = null;

        try(Connection connection = DBUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQLQueries.GET_LAWYER_BY_UUID)) {
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                lawyer = new Lawyer(rs.getInt("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("phoneNumber"),
                        rs.getString("zipcode"),
                        rs.getString("streetName"),
                        rs.getString("streetNumber"),
                        rs.getString("email"),
                        rs.getString("vat"),
                        rs.getInt("cityId"),
                        rs.getString("uuid"),
                        rs.getTimestamp("createdAt").toLocalDateTime(),
                        rs.getTimestamp("updatedAt").toLocalDateTime(),
                        getSkillsByLawyerId(rs.getInt("id")));
            }
            return lawyer;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new LawyerDAOException("SQL error in getUUID");
        }
    }


    @Override
    public Lawyer getByLastname(String lastname) throws LawyerDAOException {
        Lawyer lawyer = null;

        try(Connection connection = DBUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQLQueries.GET_LAWYER_BY_LASTNAME)) {


            ps.setString(1, lastname);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                lawyer = (new Lawyer(rs.getInt("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("phoneNumber"),
                        rs.getString("zipcode"),
                        rs.getString("streetName"),
                        rs.getString("streetNumber"),
                        rs.getString("email"),
                        rs.getString("vat"),
                        rs.getInt("cityId"),
                        rs.getString("uuid"),
                        rs.getTimestamp("createdAt").toLocalDateTime(),
                        rs.getTimestamp("updatedAt").toLocalDateTime(),
                        getSkillsByLawyerId(rs.getInt("id"))));
            }
            return lawyer;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new LawyerDAOException("SQL error getLastname");
        }
    }


    public Map<Integer, Skill> getSkillsByLawyerId(int lawyerId) throws LawyerDAOException {
        Map<Integer,Skill> skills = new HashMap<>();

        try(Connection connection = DBUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQLQueries.GET_SKILLS_BY_LAWYER_ID)) {

            ps.setInt(1, lawyerId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Skill skill = new Skill(
                        rs.getInt("id"),
                        rs.getString("name")
                );
                skills.put(skill.getId(), skill);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new LawyerDAOException("SQL error getSkills");
        }
        return skills;
    }

    @Override
    public Lawyer getByVat(String vat) throws LawyerDAOException {
        Lawyer lawyer = null;

        try(Connection connection = DBUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQLQueries.GET_LAWYER_BY_VAT)) {

            ps.setString(1, vat);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                lawyer = (new Lawyer(rs.getInt("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("phoneNumber"),
                        rs.getString("zipcode"),
                        rs.getString("streetName"),
                        rs.getString("streetNumber"),
                        rs.getString("email"),
                        rs.getString("vat"),
                        rs.getInt("cityId"),
                        rs.getString("uuid"),
                        rs.getTimestamp("createdAt").toLocalDateTime(),
                        rs.getTimestamp("updatedAt").toLocalDateTime(),
                        getSkillsByLawyerId(rs.getInt("id"))));
            }
            return lawyer;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new LawyerDAOException("SQL error getByVat");
        }
    }

    @Override
    public Lawyer getByEmail(String email) throws LawyerDAOException {
        Lawyer lawyer = null;

        try(Connection connection = DBUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQLQueries.GET_LAWYER_BY_EMAIL)) {

            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                lawyer = (new Lawyer(rs.getInt("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("phoneNumber"),
                        rs.getString("zipcode"),
                        rs.getString("streetName"),
                        rs.getString("streetNumber"),
                        rs.getString("email"),
                        rs.getString("vat"),
                        rs.getInt("cityId"),
                        rs.getString("uuid"),
                        rs.getTimestamp("createdAt").toLocalDateTime(),
                        rs.getTimestamp("updatedAt").toLocalDateTime(),
                        getSkillsByLawyerId(rs.getInt("id"))));
            }
            return lawyer;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new LawyerDAOException("SQL error getByEmail");
        }
    }

    @Override
    public List<Lawyer> getLawyersBySkill(Skill skill) throws LawyerDAOException {
        Lawyer lawyer;
        List<Lawyer> lawyers = new ArrayList<>();

        try(Connection connection = DBUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQLQueries.GET_LAWYERS_BY_SKILL)) {

            ps.setString(1, skill.getName());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lawyer = (new Lawyer(rs.getInt("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("phoneNumber"),
                        rs.getString("zipcode"),
                        rs.getString("streetName"),
                        rs.getString("streetNumber"),
                        rs.getString("email"),
                        rs.getString("vat"),
                        rs.getInt("cityId"),
                        rs.getString("uuid"),
                        rs.getTimestamp("createdAt").toLocalDateTime(),
                        rs.getTimestamp("updatedAt").toLocalDateTime(),
                        getSkillsByLawyerId(rs.getInt("id"))));
                lawyers.add(lawyer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lawyers;
    }
}
