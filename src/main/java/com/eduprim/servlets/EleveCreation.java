package com.eduprim.servlets;

import com.eduprim.Helpers;
import com.eduprim.beans.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(name = "EleveCreation", urlPatterns = {"/eleve/creation"})
public class EleveCreation extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Helpers.userConnected(request)) {
            if (Helpers.getSessionUser(request).getStatus().getLabel().equals("Admin")) {
                String nom = request.getParameter("nom");
                String prenom = request.getParameter("prenom");
                String naissance = request.getParameter("naissance");
                String classe = request.getParameter("classe");
                String mailResponsable = request.getParameter("mail");
                String adresseResponsable = request.getParameter("adresse");
                String telephoneResponsable = request.getParameter("telephone");

                if (checkValue(nom) && checkValue(prenom) && checkValue(naissance) && checkValue(classe) && checkValue(mailResponsable) && checkValue(adresseResponsable) && checkValue(telephoneResponsable)) {
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
                    status.findStatus("Eleve");
                    Eleve eleve = new Eleve(nom, prenom, sqlDate, adresseResponsable, status, mailResponsable, telephoneResponsable);
                    Classe classeToLink = new Classe();
                    classeToLink.findClasse(Integer.parseInt(classe));
                    eleve.linkToClasse(classeToLink);
                    response.sendRedirect(request.getContextPath() + "/accueil");
                }
                else {
                    this.getServletContext().getRequestDispatcher("/WEB-INF/View/creationEleve.jsp").forward(request, response);
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
                request.setAttribute("classes", Classe.getAllClasses());
                request.setAttribute("grandbg", "background-1.png");
                request.setAttribute("smallbg", "background-mobile-1.png");
                this.getServletContext().getRequestDispatcher("/WEB-INF/View/creationEleve.jsp").forward(request, response);
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
