package finalProject.controllers;

import finalProject.dao.ILawyerDAO;
import finalProject.dao.LawyerDAOImpl;
import finalProject.dto.ReadOnlyDTO;
import finalProject.exceptions.LawyerDAOException;
import finalProject.service.ILawyerService;
import finalProject.service.LawyerServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/visitorOurTeam")
public class  visitorOurTeamController extends HttpServlet {
    ILawyerDAO lawyerDAO = new LawyerDAOImpl();
    ILawyerService lawyerService = new LawyerServiceImpl(lawyerDAO);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ReadOnlyDTO> readOnlyDTOS;

        try {
            readOnlyDTOS = lawyerService.getAllLawyers();
            req.setAttribute("lawyers", readOnlyDTOS);
        } catch (LawyerDAOException e) {
            req.setAttribute("message", e.getMessage());
        }
        req.getRequestDispatcher("/visitorOurTeam.jsp").forward(req, resp);
    }
}
