package com.eduprim.servlets;

import com.eduprim.beans.Classe;
import com.eduprim.beans.Eleve;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet", urlPatterns = {"/presence"})
public class studentPresence extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//       Recept class ID
        int idClass = Integer.parseInt(request.getParameter("id"));

        Classe classe = new Classe();
//      Get class's student
        boolean check = classe.findClasse(idClass);
        if(check){
           classe.initUtilisateursList();
           request.setAttribute("students", classe.getUtilisateurs());
           request.setAttribute("name", classe.getNom());
           this.getServletContext().getRequestDispatcher("/WEB-INF/View/classList.jsp").forward(request, response);
        }
    }
}
