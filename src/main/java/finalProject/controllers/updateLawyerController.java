package finalProject.controllers;

import finalProject.dao.CityDAOImpl;
import finalProject.dao.ICityDAO;
import finalProject.dao.ISkillDAO;
import finalProject.dao.SkillDAOImpl;
import finalProject.dao.ILawyerDAO;
import finalProject.dao.LawyerDAOImpl;
import finalProject.exceptions.LawyerDAOException;
import finalProject.model.City;
import finalProject.model.Skill;
import finalProject.model.Lawyer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/updateLawyer")
public class updateLawyerController extends HttpServlet {
    private final ICityDAO cityDAO = new CityDAOImpl();
    private final ISkillDAO skillDAO = new SkillDAOImpl();
    private final ILawyerDAO lawyerDAO = new LawyerDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            // 1. Get lawyerId from request
            String idParam = req.getParameter("id");
            if (idParam == null || idParam.isEmpty()) {
                resp.sendRedirect(req.getContextPath() + "/adminOurTeam");
                return;
            }
            int lawyerId = Integer.parseInt(idParam);

            // 2. Load lawyer by ID
            Lawyer lawyer = lawyerDAO.getById(lawyerId);
            if (lawyer == null) {
                resp.sendRedirect(req.getContextPath() + "/adminOurTeam");
                return;
            }

            // 3. Load cities and skills
            List<City> cities = cityDAO.getAll();
            List<Skill> skills = skillDAO.getAll();

            // 4. Put into request
            req.setAttribute("lawyer", lawyer);
            req.setAttribute("cities", cities);
            req.setAttribute("skills", skills);

            // Debug
            System.out.println("Loaded Lawyer: " + lawyer.getFirstname() + " " + lawyer.getLastname());
            System.out.println("Cities: " + cities.size());
            System.out.println("Skills: " + skills.size());

            // 5. Forward to JSP
            req.getRequestDispatcher("/WEB-INF/jsp/updateLawyer.jsp").forward(req, resp);

        } catch (SQLException | LawyerDAOException e) {
            e.printStackTrace();
            throw new ServletException("Database error while loading lawyer for update", e);
        }
    }
}
