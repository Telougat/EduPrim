package com.eduprim.servlets;

import com.eduprim.beans.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.sql.Statement;

@WebServlet(name = "Index", urlPatterns = {"/"})
public class Index extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mail = "mail";
        String mdp = "MDP";

        Adulte adulte = Adulte.connexion(mail, mdp);
        if (adulte.getMail() != null && !adulte.getMail().isEmpty() && adulte.getStatus() != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", adulte);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }
}
