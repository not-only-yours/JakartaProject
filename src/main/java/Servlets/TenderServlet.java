package Servlets;

import Model.Tender;
import ServiceInterfaces.TenderService;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TenderServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext context=getServletContext(); 
        TenderService tenderService=(TenderService)context.getAttribute("tenderService");
        Tender tender = tenderService.getTenderById(Integer.parseInt(request.getParameter("tender")));
        request.setAttribute("tender", tender);
        request.getRequestDispatcher("WEB-INF/jsp/TenderPage.jsp").forward(request,response);
       
       
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
