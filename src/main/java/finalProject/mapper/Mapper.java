package finalProject.mapper;

import finalProject.dao.CityDAOImpl;
import finalProject.dao.ICityDAO;
import finalProject.dto.*;
import finalProject.model.City;
import finalProject.model.Lawyer;
import finalProject.model.Skill;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Mapper {

    public static CityDTO cityToDTO(City city){
        return new CityDTO(city.getId(), city.getName());
    }

    public static City cityDTOToCity(CityDTO cityDTO) {
        return new City(cityDTO.getId(), cityDTO.getName());
    }

    private static List<SkillDTO> skillsToSkillDTO(Map<Integer, Skill> skills) {
        return skills.values().stream()
                .map(skill -> {
                    SkillDTO dto = new SkillDTO();
                    dto.setId(skill.getId());
                    dto.setName(skill.getName());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    private static Skill skillDTOToSkill(SkillDTO dto) {
        return new Skill(dto.getId(), dto.getName());
    }

    public static SkillDTO skillToSkillDTO(Skill skill) {
        return new SkillDTO(
                skill.getId(),
                skill.getName()
        );
    }

    public static Lawyer laywerDTOToLawyer(LawyerDTO lawyerDTO) {

        Map<Integer, Skill> skillMap = lawyerDTO.getSkills()
                .stream()
                .collect(Collectors.toMap(SkillDTO::getId, Mapper::skillDTOToSkill));

        return new Lawyer(
                null,
                lawyerDTO.getFirstname(),
                lawyerDTO.getLastname(),
                lawyerDTO.getPhoneNumber(),
                lawyerDTO.getZipcode(),
                lawyerDTO.getStreetName(),
                lawyerDTO.getStreetNumber(),
                lawyerDTO.getEmail(),
                lawyerDTO.getVat(),
                lawyerDTO.getCity().getId(),
                null,
                null,
                null,
                skillMap
        );
    }

    public static ReadOnlyDTO lawyerToLawyerDTO(Lawyer lawyer) throws SQLException {
        ICityDAO cityDAO = new CityDAOImpl();
        City city = cityDAO.getCityById(lawyer.getCityId());
        CityDTO cityDTO = new CityDTO(city.getId(), city.getName());

        List<SkillDTO> skillsDto = lawyer.getSkills()
                .values()
                .stream()
                .map(Mapper::skillToSkillDTO)
                .collect(Collectors.toList());


        ReadOnlyDTO readOnlyDTO = new ReadOnlyDTO();
        readOnlyDTO.setFirstname(lawyer.getFirstname());
        readOnlyDTO.setLastname(lawyer.getLastname());
        readOnlyDTO.setPhoneNumber(lawyer.getPhoneNumber());
        readOnlyDTO.setZipcode(lawyer.getZipcode());
        readOnlyDTO.setStreetName(lawyer.getStreetName());
        readOnlyDTO.setStreetNumber(lawyer.getStreetNumber());
        readOnlyDTO.setEmail(lawyer.getEmail());
        readOnlyDTO.setVat(lawyer.getVat());
        readOnlyDTO.setCity(cityDTO);
        readOnlyDTO.setSkills(skillsDto);
        readOnlyDTO.setCreatedAt(lawyer.getCreatedAt());
        readOnlyDTO.setUuid(lawyer.getUuid());
        readOnlyDTO.setUpdatedAt(lawyer.getUpdatedAt());
        readOnlyDTO.setId(lawyer.getId());

        return readOnlyDTO;
    }

    public static Lawyer insertLawyerDTOToLawyer(InsertLawyerDTO dto) {
        Map<Integer, Skill> skills = dto.getSkills()
                .stream()
                .collect(Collectors.toMap(SkillDTO::getId, Mapper::skillDTOToSkill));
        return new Lawyer(
                null,
                dto.getFirstname(),
                dto.getLastname(),
                dto.getPhoneNumber(),
                dto.getZipcode(),
                dto.getStreetName(),
                dto.getStreetNumber(),
                dto.getEmail(),
                dto.getVat(),
                dto.getCity().getId(),
                null,
                null,
                null,
                skills
        );
    }

    public static Lawyer updateLawyerDTOToLawyer(UpdateLawyerDTO dto) {
        Map<Integer, Skill> skills = dto.getSkills()
                .stream()
                .collect(Collectors.toMap(SkillDTO::getId, Mapper::skillDTOToSkill));
        return new Lawyer(
                dto.getId(),
                dto.getFirstname(),
                dto.getLastname(),
                dto.getPhoneNumber(),
                dto.getZipcode(),
                dto.getStreetName(),
                dto.getStreetNumber(),
                dto.getEmail(),
                dto.getVat(),
                dto.getCity().getId(),
                null,
                null,
                null,
                skills
        );
    }
}
