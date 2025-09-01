package finalProject.controllers;

import finalProject.dao.ILawyerDAO;
import finalProject.dao.ISkillDAO;
import finalProject.dao.LawyerDAOImpl;
import finalProject.dao.SkillDAOImpl;
import finalProject.dto.ReadOnlyDTO;
import finalProject.exceptions.LawyerDAOException;
import finalProject.exceptions.LawyerNotFoundException;
import finalProject.mapper.Mapper;
import finalProject.model.Lawyer;
import finalProject.model.Skill;
import finalProject.service.ILawyerService;
import finalProject.service.LawyerServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@WebServlet("/visitorOurTeam")
public class  visitorOurTeamController extends HttpServlet {
    ILawyerDAO lawyerDAO = new LawyerDAOImpl();
    ILawyerService lawyerService = new LawyerServiceImpl(lawyerDAO);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String practice = req.getParameter("practice");
        List<ReadOnlyDTO> readOnlyDTOS = Collections.emptyList();

        try {
            if (practice != null && !practice.trim().isEmpty()) {
                ISkillDAO skillDAO = new SkillDAOImpl();
                Skill skill = skillDAO.getSkillByName(practice);

                if (skill != null) {
                    readOnlyDTOS = lawyerService.getLawyersBySkill(skill);
                } else {
                    req.setAttribute("message", "No skill found with name: " + practice);
                }
            } else {
                readOnlyDTOS = lawyerService.getAllLawyers();
            }

            req.setAttribute("lawyers", readOnlyDTOS);

        } catch (LawyerNotFoundException e) {
            req.setAttribute("message", e.getMessage());
        } catch (LawyerDAOException | SQLException e) {
            req.setAttribute("message", "Database error: " + e.getMessage());
        }

        req.getRequestDispatcher("/visitorOurTeam.jsp").forward(req, resp);
    }
}
