package com.eduprim.servlets;

import com.eduprim.Helpers;
import com.eduprim.beans.Eleve;
import com.eduprim.beans.Status;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "StudentProfile", urlPatterns = {"/eleve"})
public class StudentProfile extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Helpers.userConnected(request)) {
//       Recept student ID
            int idEleve = Integer.parseInt(request.getParameter("id"));

            Eleve eleve = new Eleve();
//      Get student information
            boolean check = eleve.findEleve(idEleve);
            if (check) {
//          Build de response
                request.setAttribute("student", eleve);
//          Send student information to the view
                this.getServletContext().getRequestDispatcher("/WEB-INF/View/studentCard.jsp").forward(request, response);
            } else {
                // 404
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/connexion");
        }
    }
}
