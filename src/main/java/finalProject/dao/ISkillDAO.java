package finalProject.dao;

import finalProject.model.Skill;

import java.sql.SQLException;
import java.util.List;

public interface ISkillDAO {
    List<Skill> getAll()
        throws SQLException;

    Skill getSkillByID(Integer id)
        throws SQLException;

}
