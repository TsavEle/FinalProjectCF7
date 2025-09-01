package finalProject.dao;

import finalProject.Util.DBUtil;
import finalProject.dao.daoUtil.SQLQueries;
import finalProject.model.Skill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SkillDAOImpl implements ISkillDAO{

    @Override
    public List<Skill> getAll() throws SQLException {
        List<Skill> skills = new ArrayList<>();

        try(Connection connection = DBUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQLQueries.GET_ALL_SKILLS);
            ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("skill_id");
                String name = rs.getString("skill_name");

                Skill skill = new Skill(id, name);
                skills.add(skill);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return skills;
    }

    @Override
    public Skill getSkillByID(Integer id) throws SQLException {
        return null;
    }

    @Override
    public Skill getSkillByName(String skillName) throws SQLException {
        Skill skill = null;
        try(Connection connection = DBUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQLQueries.GET_SKILL_BY_SKILL_NAME)) {

            ps.setString(1, skillName);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("skill_id");
                String name = rs.getString("skill_name");

                skill = new Skill(id, name);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return skill;
    }
}
