package finalProject.dao;

import finalProject.exceptions.LawyerDAOException;
import finalProject.model.City;
import finalProject.model.Lawyer;
import finalProject.model.Skill;

import java.util.List;

public interface ILawyerDAO {

    Lawyer insert(Lawyer lawyer, List<Integer> selectedSkillIds) throws LawyerDAOException;
    Lawyer update(Lawyer lawyer, List<Integer> selectedSkillIds) throws LawyerDAOException;
    void delete(Integer id) throws LawyerDAOException;
    Lawyer getById(Integer id) throws LawyerDAOException;
    List<Lawyer> getAll() throws LawyerDAOException;

    Lawyer getByUUID(String uuid) throws LawyerDAOException;
    List<Lawyer> getSkill(Skill skillName) throws LawyerDAOException;
    Lawyer getByLastname(String lastname) throws LawyerDAOException;
    List<Lawyer> getByCity(City cityName) throws LawyerDAOException;
}
