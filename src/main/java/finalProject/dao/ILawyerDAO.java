package finalProject.dao;

import finalProject.exceptions.LawyerDAOException;
import finalProject.model.Lawyer;
import finalProject.model.Skill;

import java.util.List;
import java.util.Map;

public interface ILawyerDAO {

    Lawyer insert(Lawyer lawyer, List<Integer> selectedSkillIds) throws LawyerDAOException;
    Lawyer update(Lawyer lawyer, List<Integer> selectedSkillIds) throws LawyerDAOException;
    void delete(Integer id) throws LawyerDAOException;
    Lawyer getById(Integer id) throws LawyerDAOException;
    List<Lawyer> getAll() throws LawyerDAOException;
    Lawyer getByUUID(String uuid) throws LawyerDAOException;
    Lawyer getByLastname(String lastname) throws LawyerDAOException;
    Lawyer getByVat(String vat) throws  LawyerDAOException;
    Lawyer getByEmail(String email) throws  LawyerDAOException;
    Map<Integer, Skill> getSkillsByLawyerId(int lawyerId) throws LawyerDAOException;
    List<Lawyer> getLawyersBySkill(Skill skill) throws LawyerDAOException;

}
