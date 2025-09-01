package finalProject.controllers;

import finalProject.dao.ILawyerDAO;
import finalProject.dao.LawyerDAOImpl;
import finalProject.exceptions.LawyerDAOException;
import finalProject.service.ILawyerService;
import finalProject.service.LawyerServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/deleteLawyerController")
public class deleteLawyerController extends HttpServlet {
    private ILawyerDAO lawyerDAO = new LawyerDAOImpl();
    private ILawyerService lawyerService = new LawyerServiceImpl(lawyerDAO);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String idParam = req.getParameter("id");
        if (idParam != null && !idParam.isEmpty()) {
            try {
                int id = Integer.parseInt(idParam);
                lawyerDAO.delete(id);
            } catch (LawyerDAOException e) {
                e.printStackTrace();
            }
        }
        req.getSession().setAttribute("successMessage", "Lawyer deleted successfully!");
        resp.sendRedirect(req.getContextPath() + "/adminOurTeam");
    }
}
