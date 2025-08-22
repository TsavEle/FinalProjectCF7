package finalProject.service;

import finalProject.model.Skill;

import java.sql.SQLException;
import java.util.List;

public interface ISkillService {
    List<Skill> getAllSkills()
        throws SQLException;
}
