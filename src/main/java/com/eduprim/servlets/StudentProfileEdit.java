package com.eduprim.servlets;

import com.eduprim.beans.Eleve;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StudentProfileEdit", urlPatterns = {"/Edition"})
public class StudentProfileEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//       Recept student ID
//        int idEleve = Integer.parseInt(request.getParameter("id"));

//        Eleve eleve = new Eleve();
////      Get student information
//        boolean check = eleve.findEleve(idEleve);
//        if(check){
//          Build de response
//            request.setAttribute("Name", eleve.getNom());
//            request.setAttribute("firstName", eleve.getPrenom());
//            request.setAttribute("birthDate", eleve.getDateDeNaissance());
//            request.setAttribute("address", eleve.getAdresse());
//            request.setAttribute("mail", eleve.getMailParent());
//            request.setAttribute("phone", eleve.getTelephoneParent());
//          Send student information to the view
            this.getServletContext().getRequestDispatcher("/WEB-INF/View/studentCardEdit.jsp").forward(request, response);
//        }
    }
}
