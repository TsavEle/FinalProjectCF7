package finalProject.service;

import finalProject.dto.InsertLawyerDTO;
import finalProject.dto.ReadOnlyDTO;
import finalProject.dto.UpdateLawyerDTO;
import finalProject.exceptions.LawyerAlreadyExistsException;
import finalProject.exceptions.LawyerDAOException;
import finalProject.exceptions.LawyerNotFoundException;
import finalProject.model.Skill;

import java.util.List;

public interface ILawyerService {
    ReadOnlyDTO insertLawyer(InsertLawyerDTO dto)
        throws LawyerDAOException, LawyerAlreadyExistsException;
    ReadOnlyDTO updateLawyer(Integer id, UpdateLawyerDTO dto)
        throws LawyerDAOException, LawyerAlreadyExistsException, LawyerNotFoundException;
    void deleteLawyer(Integer id)
        throws LawyerDAOException, LawyerNotFoundException;
    ReadOnlyDTO getLawyerById(Integer id)
        throws LawyerDAOException, LawyerNotFoundException;
    List<ReadOnlyDTO> getLawyersBySkill(Skill skill)
        throws LawyerDAOException, LawyerNotFoundException;
    List<ReadOnlyDTO> getAllLawyers()
        throws LawyerDAOException;




}
