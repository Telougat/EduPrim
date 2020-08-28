package com.eduprim.servlets;

import com.eduprim.Helpers;
import com.eduprim.beans.Classe;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CreationClasse", urlPatterns = {"/classe/create"})
public class CreationClasse extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Helpers.userConnected(request)) {
            if (Helpers.getSessionUser(request).getStatus().getLabel().equals("Admin")) {
                String nom = request.getParameter("nomClasse");
                if (nom != null && !nom.isEmpty()) {
                    Classe classe = new Classe(nom);
                    this.getServletContext().getRequestDispatcher("/WEB-INF/View/adminLobby.jsp").forward(request, response);
                }
                else {
                    this.getServletContext().getRequestDispatcher("/WEB-INF/View/creationClasse.jsp").forward(request, response);
                }
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Helpers.userConnected(request))
        {
            if (Helpers.getSessionUser(request).getStatus().getLabel().equals("Admin"))
            {
                request.setAttribute("grandbg", "background-1.png");
                request.setAttribute("smallbg", "background-mobile-1.png");
                this.getServletContext().getRequestDispatcher("/WEB-INF/View/creationClasse.jsp").forward(request, response);
            }
            else {
                response.sendError(403);
                return;
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/connexion");
        }
    }
}
