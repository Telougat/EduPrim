package com.eduprim.servlets;

import com.eduprim.Helpers;
import com.eduprim.beans.Adulte;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Connexion", urlPatterns = {"/connexion"})
public class Connexion extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String mdp = request.getParameter("mdp");

        HttpSession session = request.getSession();
        session.setAttribute("userExist", null);

        Adulte adulte = Adulte.connexion(email, mdp);
        if(adulte.getMail() != null && !adulte.getMail().isEmpty() && adulte.getStatus() != null) {
            Helpers.setSessionUser(request, adulte);
            if(session.getAttribute("userExist") != null) {
                session.setAttribute("userExist", null);
            }
            if(adulte.getStatus().getLabel().equals("Admin")) {
                this.getServletContext().getRequestDispatcher("/WEB-INF/View/adminLobby.jsp").forward(request, response);
            }
            else {
                response.sendRedirect(request.getContextPath() + "/classes");
            }
        }
        else {
            session.setAttribute("userExist", false);
            this.getServletContext().getRequestDispatcher("/WEB-INF/View/login.jsp").forward(request, response);
            session.setAttribute("userExist", null);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/View/login.jsp").forward(request, response);
    }
}
