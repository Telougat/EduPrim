package com.eduprim.servlets;

import com.eduprim.Helpers;
import com.eduprim.beans.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "EleveCreation", urlPatterns = {"/eleve/creation"})
public class EleveCreation extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Helpers.userConnected(request))
        {
            if (Helpers.getSessionUser(request).getStatus().getLabel().equals("Admin"))
            {
                request.setAttribute("grandbg", "background-1.png");
                request.setAttribute("smallbg", "background-mobile-1.png");
                this.getServletContext().getRequestDispatcher("/WEB-INF/View/creationEleve.jsp").forward(request, response);
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
