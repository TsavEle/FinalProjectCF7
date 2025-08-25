package finalProject.service;

import finalProject.dao.ISkillDAO;
import finalProject.model.Skill;

import java.sql.SQLException;
import java.util.List;

public class SkillServiceImpl implements ISkillService {
    private final ISkillDAO dao;

    public SkillServiceImpl(ISkillDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<Skill> getAllSkills() throws SQLException {
        try {
            return dao.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
