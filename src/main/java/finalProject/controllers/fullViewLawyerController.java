package finalProject.controllers;

import finalProject.dao.CityDAOImpl;
import finalProject.dao.ICityDAO;
import finalProject.dao.ILawyerDAO;
import finalProject.dao.LawyerDAOImpl;
import finalProject.exceptions.LawyerDAOException;
import finalProject.model.City;
import finalProject.model.Lawyer;
import finalProject.service.ILawyerService;
import finalProject.service.LawyerServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/fullViewLawyer")
public class fullViewLawyerController extends HttpServlet {
    private ILawyerDAO lawyerDAO = new LawyerDAOImpl();
    private  ILawyerService lawyerService = new LawyerServiceImpl(lawyerDAO);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String idParam = req.getParameter("id");
        if (idParam != null && !idParam.isEmpty()) {
            try {
                int id = Integer.parseInt(idParam);
                Lawyer lawyer = lawyerDAO.getById(id);

                ICityDAO cityDAO = new CityDAOImpl();
                City city = cityDAO.getCityById(lawyer.getCityId());
                req.setAttribute("lawyer",lawyer);
                req.setAttribute("city", city);


                req.getRequestDispatcher("/WEB-INF/jsp/fullViewLawyer.jsp").forward(req, resp);
            } catch (LawyerDAOException | SQLException e) {
                e.printStackTrace();
                resp.sendRedirect("/WEB-INF/jsp/adminOurTeam.jsp");
            }
        } else {
            resp.sendRedirect("/WEB-INF/jsp/adminOurTeam.jsp");
        }
    }
}
