package com.eduprim.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ClasseSuppression", urlPatterns = {"/classe/delete"})
public class ClasseSuppression extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("grandbg", "background-1.png");
        request.setAttribute("smallbg", "background-mobile-1.png");
        this.getServletContext().getRequestDispatcher("/WEB-INF/View/suppressionClasse.jsp").forward(request, response);
    }
}
