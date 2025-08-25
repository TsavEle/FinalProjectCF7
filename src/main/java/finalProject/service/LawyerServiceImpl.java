package finalProject.service;

import finalProject.dao.ILawyerDAO;
import finalProject.dao.LawyerDAOImpl;
import finalProject.dto.InsertLawyerDTO;
import finalProject.dto.ReadOnlyDTO;
import finalProject.dto.SkillDTO;
import finalProject.dto.UpdateLawyerDTO;
import finalProject.exceptions.LawyerAlreadyExistsException;
import finalProject.exceptions.LawyerDAOException;
import finalProject.exceptions.LawyerNotFoundException;
import finalProject.mapper.Mapper;
import finalProject.model.Lawyer;
import finalProject.model.Skill;

import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

public class LawyerServiceImpl implements ILawyerService{

    private final ILawyerDAO lawyerDAO;

    public LawyerServiceImpl(ILawyerDAO lawyerDAO) {
        this.lawyerDAO = lawyerDAO;
    }

    @Override
    public ReadOnlyDTO insertLawyer(InsertLawyerDTO dto)
            throws LawyerDAOException, LawyerAlreadyExistsException {

        try {
            Lawyer lawyer = Mapper.insertLawyerDTOToLawyer(dto);
            List<Integer> selectedSkillIds = Optional.ofNullable(dto.getSkills())
                    .orElse(Collections.emptyList())
                    .stream()
                    .map(SkillDTO::getId)
                    .collect(Collectors.toList());

            if (lawyerDAO.getByEmail(dto.getEmail()) != null) {
                throw new LawyerAlreadyExistsException("Lawyer with email " + dto.getEmail() + " already exists");
            }

            if (lawyerDAO.getByVat(dto.getVat()) != null) {
                throw new LawyerAlreadyExistsException("Lawyer with vat " + dto.getVat() + " already exists");
            }
            Lawyer insertedLawyer = lawyerDAO.insert(lawyer, selectedSkillIds);
            return Mapper.lawyerToLawyerDTO(insertedLawyer);

        } catch (SQLException e) {
            throw new LawyerDAOException("Error converting Lawyer to ReadOnlyDTO");
        }
    }

    @Override
    public ReadOnlyDTO updateLawyer(Integer id, UpdateLawyerDTO dto) throws LawyerDAOException, LawyerAlreadyExistsException, LawyerNotFoundException {
        Lawyer lawyer;
        Lawyer returnedLawyer;

        try {
            if (lawyerDAO.getById(id) == null)
                throw new LawyerNotFoundException("Lawyer with id " + id + " not found!");

            returnedLawyer = lawyerDAO.getByEmail(dto.getEmail());
            if (returnedLawyer != null && !returnedLawyer.getId().equals(dto.getId()))
                throw new LawyerAlreadyExistsException("Lawyer with id " + id + " already exists!");

            lawyer = Mapper.updateLawyerDTOToLawyer(dto);
            List<Integer> selectedSkillIds = Optional.ofNullable(dto.getSkills())
                    .orElse(Collections.emptyList())
                    .stream()
                    .map(SkillDTO::getId)
                    .collect(Collectors.toList());
            Lawyer updatedLawyer = lawyerDAO.update(lawyer, selectedSkillIds);
            return Mapper.lawyerToLawyerDTO(updatedLawyer);


        } catch (SQLException e) {
            e.printStackTrace();
            throw new LawyerDAOException("Error converting Lawyer to ReadOnlyDTO");
        }
    }

    @Override
    public void deleteLawyer(Integer id) throws LawyerDAOException, LawyerNotFoundException {
        try {
            if (lawyerDAO.getById(id) == null)
                throw  new LawyerNotFoundException("Lawyer with id " + id + " not found!");
            lawyerDAO.delete(id);
        } catch (LawyerDAOException | LawyerNotFoundException e) {
            e.printStackTrace();
            throw e;
        }


    }

    @Override
    public ReadOnlyDTO getLawyerById(Integer id) throws LawyerDAOException, LawyerNotFoundException {
        Lawyer lawyer;

        try {
            lawyer = lawyerDAO.getById(id);
            if (lawyer == null)
                throw new LawyerNotFoundException("Lawyer with id " + id + " not found!");
            return Mapper.lawyerToLawyerDTO(lawyer);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new LawyerDAOException("Error converting Lawyer to ReadOnlyDTO");
        }
    }

    @Override
    public List<ReadOnlyDTO> getLawyersBySkill(Skill skill) throws LawyerDAOException, LawyerNotFoundException {
        List<Lawyer> lawyersToConvert;
        List<ReadOnlyDTO> lawyersToReturn;

        try {
            lawyersToConvert = lawyerDAO.getLawyersBySkill(skill);
            if (lawyersToConvert == null)
                throw new LawyerNotFoundException("No lawyers with selected skill " + skill.getName());
            lawyersToReturn = Mapper.lawyersToReadOnlyDTOs(lawyersToConvert);
        } catch (LawyerDAOException e) {
            e.printStackTrace();
            throw e;
        }
        return lawyersToReturn;
    }

    @Override
    public List<ReadOnlyDTO> getAllLawyers() throws LawyerDAOException {
        return Mapper.lawyersToReadOnlyDTOs(lawyerDAO.getAll());
    }
}
