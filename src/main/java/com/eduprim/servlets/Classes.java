package com.eduprim.servlets;

import com.eduprim.Helpers;
import com.eduprim.beans.Adulte;
import com.eduprim.beans.Classe;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.IOException;

@WebServlet(name = "Classes", urlPatterns = {"/classes"})
public class Classes extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Adulte adulte = new Adulte();
        adulte.findAdulte(8);
        request.setAttribute("classes", adulte.getClasses());
        this.getServletContext().getRequestDispatcher("/WEB-INF/classes.jsp").forward(request, response);
    }
}
