package com.eduprim.servlets;

import com.eduprim.beans.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.Statement;

@WebServlet(name = "Index", urlPatterns = {"/"})
public class Index extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Adulte logger = Adulte.connexion("fpichon@cesi.fr", "123");
        System.out.println("Log successful");
        System.out.println(logger.getNom() + " " + logger.getPrenom() + " " + logger.getTelephone() + "  " + logger.getMail());
        this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }
}
