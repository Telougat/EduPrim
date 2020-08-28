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

@WebServlet(name = "StudentProfileEdit", urlPatterns = {"/edition"})
public class StudentProfileEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = "name";
        String firstName = "firstName";
        String phone = "phone";
        String address = "address";
        Date date = Date.valueOf(("date"));
        String mail = "mail";
        int id = Integer.parseInt("id");

        Eleve eleve = new Eleve();
        eleve.findEleve(id);
        eleve.setMailParent(mail);
        eleve.setTelephoneParent(phone);
        eleve.setAdresse(address);
        eleve.setDateDeNaissance(date);
        eleve.setNom(name);
        eleve.setPrenom(firstName);

        boolean cde = eleve.save();
        System.out.println(cde);
        request.setAttribute("cde", cde);
        this.getServletContext().getRequestDispatcher("/WEB-INF/View/studentCardEdit.jsp").forward(request, response);
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
                this.getServletContext().getRequestDispatcher("/WEB-INF/View/studentCardEdit.jsp").forward(request, response);
            } else {
                // 404
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/connexion");
        }
    }
}
