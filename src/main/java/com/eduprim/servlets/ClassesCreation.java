package com.eduprim.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ClassesCreation", urlPatterns = {"/classes/creation"})
public class ClassesCreation extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("grandbg", "background-test.png");
        request.setAttribute("smallbg", "background-test-mobile.png");
        this.getServletContext().getRequestDispatcher("/WEB-INF/View/classeCreation.jsp").forward(request, response);
    }
}
