package Servlets;

import Model.User;
import ServiceInterfaces.UserService;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext context = getServletContext();
        UserService userService = (UserService) context.getAttribute("userService");

        String login = request.getParameter("login");
        User user = userService.getByLogin(login);

        if (user == null) {
            request.getRequestDispatcher("/WEB-INF/jsp/Error.jsp").forward(request, response);
            return;
        }
        String pass = request.getParameter("pass");

        if (!userService.checkPassword(user, pass)) {
            request.getRequestDispatcher("/WEB-INF/jsp/Error.jsp").forward(request, response);
            return;
        }
        request.getSession().setAttribute("user", user);
        request.getRequestDispatcher("MainPage.jsp").forward(request, response);
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
