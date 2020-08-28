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
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(name = "StudentProfileEdit", urlPatterns = {"/edition"})
public class StudentProfileEdit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String firstName = request.getParameter("firstName");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String date = request.getParameter("date");
        String mail = request.getParameter("mail");
        int id = Integer.parseInt(request.getParameter("id"));

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsed = null;
            java.sql.Date sqlDate = null;
            try {
                parsed = format.parse(date);
                sqlDate = new java.sql.Date(parsed.getTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }

            Eleve eleve = new Eleve();
            eleve.findEleve(id);
            eleve.setMailParent(mail);
            eleve.setTelephoneParent(phone);
            eleve.setAdresse(address);
            eleve.setDateDeNaissance(sqlDate);
            eleve.setNom(name);
            eleve.setPrenom(firstName);

            boolean cde = eleve.save();

            request.setAttribute("cde", cde);
            request.setAttribute("student", eleve);

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
                request.setAttribute("cde", null);
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
