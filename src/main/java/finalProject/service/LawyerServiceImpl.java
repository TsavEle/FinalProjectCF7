package finalProject.service;

import finalProject.dao.ILawyerDAO;
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
        return null;
    }

    @Override
    public void deleteLawyer(Integer id) throws LawyerDAOException, LawyerNotFoundException {

    }

    @Override
    public ReadOnlyDTO getLawyerById(Integer id) throws LawyerDAOException, LawyerNotFoundException {
        return null;
    }

    @Override
    public ReadOnlyDTO getLawyerBySkill(Skill skill) throws LawyerDAOException, LawyerNotFoundException {
        return null;
    }

    @Override
    public List<ReadOnlyDTO> getAllLawyers() throws LawyerDAOException {
        return List.of();
    }
}
