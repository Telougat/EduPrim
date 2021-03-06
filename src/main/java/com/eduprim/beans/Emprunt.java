package com.eduprim.beans;

import java.sql.*;
import java.util.ArrayList;

public class Emprunt extends Database {
    private Timestamp dateDebut;
    private Timestamp dateFin;
    private Livre livre;
    private Utilisateur utilisateur;

    public Emprunt(Timestamp dateDebut, Timestamp dateFin, Livre livre, Utilisateur utilisateur, boolean ancien) {
        super(true);
        if (!Emprunt.isEmprunter(livre) && !ancien)
        {
            try {
                PreparedStatement ps = this.connection.prepareStatement("INSERT INTO Emprunte(ID, ID_Livres, DateDebut, DateFin) VALUES (?, ?, ?, ?)");
                ps.setInt(1, utilisateur.getID());
                ps.setInt(2, livre.getID());
                ps.setTimestamp(3, dateDebut);
                ps.setTimestamp(4, dateFin);
                ps.executeUpdate();
                this.dateDebut = dateDebut;
                this.dateFin = dateFin;
                this.livre = livre;
                this.utilisateur = utilisateur;
            }
            catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else if(ancien) {
            this.dateDebut = dateDebut;
            this.dateFin = dateFin;
            this.utilisateur = utilisateur;
            this.livre = livre;
        }
    }

    public static ArrayList<Emprunt> getEmprunts(Utilisateur utilisateur) {
        Database database = new Database(true);
        Connection connection = database.getConnection();
        ArrayList<Emprunt> emprunts = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT e.DateDebut, e.DateFin, l.ID as livreID, l.Titre as livreTitre, l.Auteur as livreAuteur, l.Reference as livreReference FROM Emprunte as e" +
                    " INNER JOIN Livres as l ON l.ID = e.ID_Livres" +
                    " WHERE e.ID = ?");
            ps.setInt(1, utilisateur.getID());
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                Livre newLivre = new Livre(result.getInt("livreID"), result.getString("livreTitre"), result.getString("livreAuteur"), result.getString("livreReference"));
                emprunts.add(new Emprunt(result.getTimestamp("DateDebut"), result.getTimestamp("DateFin"), newLivre, utilisateur, true));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return emprunts;
    }

    public Timestamp getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Timestamp dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Timestamp getDateFin() {
        return dateFin;
    }

    public void setDateFin(Timestamp dateFin) {
        this.dateFin = dateFin;
    }

    public Livre getLivre() {
        return livre;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void save() {
        if (this.connection == null)
            this.getConnection();
        try {
            PreparedStatement ps = this.connection.prepareStatement("UPDATE Emprunte SET ID = ?, DateDebut = ?, DateFin = ? WHERE ID_Livres = ?");
            ps.setInt(1, this.utilisateur.getID());
            ps.setTimestamp(2, this.dateDebut);
            ps.setTimestamp(3, this.dateFin);
            ps.setInt(4, this.livre.getID());
            ps.executeUpdate();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static boolean isEmprunter(Livre livre) {
        Database database = new Database(true);
        Connection connection = database.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT MAX(em.DateFin) as dernierEmprunt FROM Emprunte as em" +
                    " INNER JOIN Livres as l ON l.ID = em.ID_Livres" +
                    " WHERE em.ID_Livres = ?");
            ps.setInt(1, livre.getID());
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                if (result.getTimestamp("dernierEmprunt") != null) {
                    Timestamp dateFinDernierEmprunt = result.getTimestamp("dernierEmprunt");
                    return dateFinDernierEmprunt.after(new Timestamp(System.currentTimeMillis()));
                } else {
                    return false;
                }
            }
            else
                return false;
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
