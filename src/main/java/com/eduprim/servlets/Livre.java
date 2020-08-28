package com.eduprim.servlets;

import com.eduprim.Helpers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Livre", urlPatterns = {"/livre"})
public class Livre extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Helpers.userConnected(request)) {
            request.setAttribute("visibility","hidden");
            if(Helpers.getSessionUser(request).getStatus().getLabel().equals("Admin")) {
                request.setAttribute("visibility", "visible");
                if (request.getParameter("titre") != null && request.getParameter("auteur") != null && request.getParameter("reference") != null) {
                    System.out.println(request.getParameter("titre"));
                    System.out.println(request.getParameter("auteur"));

                    String titre = request.getParameter("titre");
                    String auteur = request.getParameter("auteur");
                    String reference = request.getParameter("reference");
                    com.eduprim.beans.Livre livre = new com.eduprim.beans.Livre(titre, auteur, reference);

                }
            }

            request.setAttribute("livres", com.eduprim.beans.Livre.getAllLivres());
            request.setAttribute("eleves", com.eduprim.beans.Eleve.getAllEleves());
            request.setAttribute("grandbg", "background-1.png");
            request.setAttribute("smallbg", "background-mobile-1.png");
            this.getServletContext().getRequestDispatcher("/WEB-INF/View/livre.jsp").forward(request, response);

    } else {
        response.sendRedirect(request.getContextPath() + "/connexion");
    }
    }
}
