package finalProject.controllers;
import finalProject.Util.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/login")
public class loginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username.equals("lawyer_admin") && password.equals("Lawyer12345!")) {

            try {
                Connection connection = DBUtil.getConnection();

                HttpSession session = req.getSession(true);
                session.setAttribute("dbConnection", connection);
                session.setAttribute("loggedUser", username);

                resp.sendRedirect(req.getContextPath() +"/adminOurTeam");
            } catch (SQLException e) {
                e.printStackTrace();
                resp.sendRedirect("login.jsp?error=db");
            }
        } else {
            resp.sendRedirect("login.jsp?error=true");
        }
    }
}
