package finalProject.controllers;

import finalProject.dao.ILawyerDAO;
import finalProject.dao.LawyerDAOImpl;
import finalProject.exceptions.LawyerDAOException;
import finalProject.model.Lawyer;
import finalProject.service.ILawyerService;
import finalProject.service.LawyerServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/saveUpdatedLawyer")
public class saveUpdatedLawyerController extends HttpServlet {
    private final ILawyerDAO lawyerDAO = new LawyerDAOImpl();
    private final ILawyerService lawyerService = new LawyerServiceImpl(lawyerDAO);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String phoneNumber = req.getParameter("phoneNumber");
        String zipcode = req.getParameter("zipcode");
        String streetName = req.getParameter("streetName");
        String streetNumber = req.getParameter("streetNumber");
        String email = req.getParameter("email");
        String vat = req.getParameter("vat");
        int cityId = Integer.parseInt(req.getParameter("cityId"));

        String[] selectedSkillsParam = req.getParameterValues("skills");
        List<Integer> selectedSkillIds = new ArrayList<>();
        if (selectedSkillsParam != null) {
            for (String skillIdStr : selectedSkillsParam) {
                selectedSkillIds.add(Integer.parseInt(skillIdStr));
            }
        }

        Lawyer lawyer = new Lawyer();
        lawyer.setId(id);
        lawyer.setFirstname(firstname);
        lawyer.setLastname(lastname);
        lawyer.setPhoneNumber(phoneNumber);
        lawyer.setZipcode(zipcode);
        lawyer.setStreetName(streetName);
        lawyer.setStreetNumber(streetNumber);
        lawyer.setEmail(email);
        lawyer.setVat(vat);
        lawyer.setCityId(cityId);

        try {
            Lawyer existingByEmail = lawyerDAO.getByEmail(email);
            if (existingByEmail != null && existingByEmail.getId() != lawyer.getId()) {
                req.getSession().setAttribute("emailError", "Email already exists!");
                resp.sendRedirect(req.getContextPath() + "/updateLawyer");
                return;
            }

            Lawyer existingByVat = lawyerDAO.getByVat(vat);
            if (existingByVat != null && existingByVat.getId() != lawyer.getId()) {
                req.getSession().setAttribute("vatError", "Vat already exists!");
                resp.sendRedirect(req.getContextPath() + "/updateLawyer");
                return;
            }
            lawyerDAO.update(lawyer, selectedSkillIds);
            // Redirect to a success page or back to the form
            req.getSession().setAttribute("successMessage", "Lawyer updated successfully!");
            resp.sendRedirect(req.getContextPath() + "/adminOurTeam");
        } catch (LawyerDAOException e) {
            e.printStackTrace();
            req.setAttribute("errorMessage", "Error saving lawyer: " + e.getMessage());
            req.getRequestDispatcher("WEB-INF/jsp/updateLawyer.jsp").forward(req, resp);
        }
    }
}
