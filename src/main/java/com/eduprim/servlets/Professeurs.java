package com.eduprim.servlets;

import com.eduprim.Helpers;
import com.eduprim.beans.Adulte;
import com.eduprim.beans.Classe;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Professeurs", urlPatterns = "/professeurs")
public class Professeurs extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("grandbg", "background-2.png");
        request.setAttribute("smallbg", "background-mobile-1.png");
        request.setAttribute("professeurs", Adulte.getAllProffeseurs());
        this.getServletContext().getRequestDispatcher("/WEB-INF/View/professeurs.jsp").forward(request, response);
    }
}
