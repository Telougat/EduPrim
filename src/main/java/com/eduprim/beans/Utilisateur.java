package com.eduprim.beans;

import java.sql.*;

public class Utilisateur extends Database {

    private int ID;
    private String nom;
    private String prenom;
    private Date dateDeNaissance;
    private String adresse;
    private Status status;

    public Utilisateur() {
        super(false);
    }

    public Utilisateur(String nom, String prenom, Date naissance, String addresse, Status status) {
        super(true);
        try{
            PreparedStatement ps = this.connection.prepareStatement("INSERT INTO Utilisateurs(Nom, Prenom, DateDeNaissance, Adresse, ID_Status) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, nom);
            ps.setString(2, prenom);
            ps.setDate(3, naissance);
            ps.setString(4, addresse);
            ps.setInt(5, status.getID());
            ps.executeUpdate();
            ResultSet result = ps.getGeneratedKeys();
            result.next();
            this.ID = result.getInt(1);
            this.nom = nom;
            this.prenom = prenom;
            this.dateDeNaissance = naissance;
            this.adresse = addresse;
            this.status = new Status(status);
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Utilisateur(int id, String nom, String prenom, Date naissance, String addresse, Status status) {
        super(false);
        this.ID = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = naissance;
        this.adresse = addresse;
        this.status = new Status(status);
    }

    public Utilisateur(Utilisateur utilisateur) {
        super(false);
        this.ID = utilisateur.getID();
        this.nom = utilisateur.getNom();
        this.prenom = utilisateur.getPrenom();
        this.dateDeNaissance = utilisateur.getDateDeNaissance();
        this.adresse = utilisateur.getAdresse();
        this.status = new Status(utilisateur.getStatus());
    }

    public int getID() {
        return ID;
    }

    protected void setID(int id) {
        this.ID = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(Date dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = new Status(status);
    }

    public boolean findUtilisateur(int id) {
        if (this.connection == null)
            this.getConnection();
        try {
            PreparedStatement ps = this.connection.prepareStatement("SELECT u.*, s.Label as statusLabel FROM Utilisateurs as u INNER JOIN Status as s ON s.ID = u.ID_Status WHERE u.ID = ?");
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                this.ID = result.getInt("ID");
                this.nom = result.getString("Nom");
                this.prenom = result.getString("Prenom");
                this.dateDeNaissance = result.getDate("DateDeNaissance");
                this.adresse = result.getString("Adresse");
                this.status = new Status(result.getInt("ID_Status"), result.getString("statusLabel"));
                return true;
            }
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean save() {
        if (this.ID <= 0)
            return false;
        if (this.connection == null)
            this.getConnection();
        try {
            PreparedStatement ps = this.connection.prepareStatement("UPDATE Utilisateurs SET Nom = ?, Prenom = ?, DateDeNaissance = ?, Adresse = ?, ID_Status = ? WHERE ID = ?");
            ps.setString(1, this.nom);
            ps.setString(2, this.prenom);
            ps.setDate(3, this.dateDeNaissance);
            ps.setString(4, this.adresse);
            ps.setInt(5, this.status.getID());
            ps.setInt(6, this.ID);
            int modifications = ps.executeUpdate();
            if (modifications > 0) {
                return true;
            }
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return false;
    }
}
