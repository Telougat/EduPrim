package com.eduprim.servlets;

import com.eduprim.Helpers;
import com.eduprim.beans.Adulte;
import com.eduprim.beans.Classe;
import com.eduprim.beans.Eleve;
import com.eduprim.beans.Status;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "ProfesseurCreation", urlPatterns = {"/prof/creation"})
public class ProfesseurCreation extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Helpers.userConnected(request)) {
            if (Helpers.getSessionUser(request).getStatus().getLabel().equals("Admin")) {
                String nom = request.getParameter("nom");
                String prenom = request.getParameter("prenom");
                String mail = request.getParameter("mail");
                String naissance = request.getParameter("naissance");
                String motDePasse = request.getParameter("motDePasse");
                String adresse = request.getParameter("adresse");
                String telephone = request.getParameter("telephone");
                System.out.println("OK !");
                if (checkValue(nom) && checkValue(prenom) && checkValue(mail) && checkValue(naissance) && checkValue(motDePasse) && checkValue(adresse) && checkValue(telephone)) {
                    System.out.println("PAssage !");
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    Date parsed = null;
                    java.sql.Date sqlDate = null;
                    try {
                        parsed = format.parse(naissance);
                        sqlDate = new java.sql.Date(parsed.getTime());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    Status status = new Status();
                    status.findStatus("Professeur");
                    Adulte adulte = new Adulte(nom, prenom, sqlDate, adresse, status, Long.parseLong(telephone), mail, motDePasse);
                    response.sendRedirect(request.getContextPath() + "/accueil");
                }
                else {
                    this.getServletContext().getRequestDispatcher("/WEB-INF/View/creationProfesseur.jsp").forward(request, response);
                }
            }
        }
        else {
            response.sendError(403);
            return;
        }
    }

    private boolean checkValue(String value) {
        return !value.isEmpty() && value != null;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Helpers.userConnected(request))
        {
            if (Helpers.getSessionUser(request).getStatus().getLabel().equals("Admin"))
            {
                request.setAttribute("grandbg", "background-1.png");
                request.setAttribute("smallbg", "background-mobile-1.png");
                this.getServletContext().getRequestDispatcher("/WEB-INF/View/creationProfesseur.jsp").forward(request, response);
            }
            else {
                response.sendError(403);
                return;
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/connexion");
        }
    }
}
