package finalProject.controllers;

import finalProject.dao.CityDAOImpl;
import finalProject.dao.ICityDAO;
import finalProject.dao.ISkillDAO;
import finalProject.dao.SkillDAOImpl;

import finalProject.model.City;
import finalProject.model.Skill;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;



@WebServlet("/insertLawyer")
public class insertLawyerController extends HttpServlet {
    ICityDAO cityDAO = new CityDAOImpl();
    ISkillDAO skillDAO = new SkillDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            List<City> cities = cityDAO.getAll();
            List<Skill> skills = skillDAO.getAll();

            req.setAttribute("cities", cities);
            req.setAttribute("skills", skills);

            System.out.println("Cities: " + cities.size());
            System.out.println("Skills: " + skills.size());
        } catch (SQLException e) {
            e.printStackTrace();

        }


        req.getRequestDispatcher("/WEB-INF/jsp/insertLawyer.jsp").forward(req, resp);
    }
}
