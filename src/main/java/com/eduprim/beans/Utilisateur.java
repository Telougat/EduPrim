package com.eduprim.beans;

import java.lang.reflect.Array;
import java.sql.*;
import java.util.ArrayList;

public class Utilisateur extends Database {

    private int ID;
    private String nom;
    private String prenom;
    private Date dateDeNaissance;
    private String adresse;
    private Status status;
    private ArrayList<Classe> classes = new ArrayList<>();

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

    public Utilisateur(int id, String nom, String prenom, Date naissance, String adresse, Status status) {
        super(false);
        this.ID = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = naissance;
        this.adresse = adresse;
        this.status = new Status(status);
    }

    public Utilisateur(int id, String nom, String prenom, Date naissance, String adresse, Status status, ArrayList<Classe> classes) {
        this(id, nom, prenom, naissance, adresse, status);
        this.classes = new ArrayList<>(classes);
    }

    public Utilisateur(Utilisateur utilisateur) {
        super(false);
        this.ID = utilisateur.getID();
        this.nom = utilisateur.getNom();
        this.prenom = utilisateur.getPrenom();
        this.dateDeNaissance = utilisateur.getDateDeNaissance();
        this.adresse = utilisateur.getAdresse();
        this.status = new Status(utilisateur.getStatus());
        this.classes = new ArrayList<>(utilisateur.getClasses());
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

    public ArrayList<Classe> getClasses() {
        return classes;
    }

    public void setClasses(ArrayList<Classe> classes) {
        this.classes = classes;
    }

    public boolean findUtilisateur(int id) {
        if (this.connection == null)
            this.getConnection();
        try {
            PreparedStatement ps = this.connection.prepareStatement("SELECT u.*, s.Label as statusLabel, c.ID as classeID, c.Nom as classeNom FROM Utilisateurs as u" +
                    " INNER JOIN Status as s ON s.ID = u.ID_Status" +
                    " INNER JOIN Appartient as ap ON ap.ID = u.ID" +
                    " INNER JOIN Classes as c ON c.ID = ap.ID_Classes" +
                    " WHERE u.ID = ?");
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                this.ID = result.getInt("ID");
                this.nom = result.getString("Nom");
                this.prenom = result.getString("Prenom");
                this.dateDeNaissance = result.getDate("DateDeNaissance");
                this.adresse = result.getString("Adresse");
                this.status = new Status(result.getInt("ID_Status"), result.getString("statusLabel"));
                this.classes.add(new Classe(result.getInt("classeID"), result.getString("classeNom")));
                while (result.next()) {
                    this.classes.add(new Classe(result.getInt("classeID"), result.getString("classeNom")));
                }
                return true;
            }
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean linkToClasse(Classe classe) {
        if (this.ID <=0)
            return false;
        if (this.connection == null)
            this.getConnection();
        try {
            PreparedStatement ps = this.connection.prepareStatement("INSERT INTO Appartient(ID, ID_Classes) VALUES (?, ?)");
            ps.setInt(1, this.ID);
            ps.setInt(2, classe.getID());
            int modifications = ps.executeUpdate();
            if (modifications > 0) {
                this.classes.add(new Classe(classe));
                return true;
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public int initClasseList() {
        if (this.ID <= 0)
            return -1;
        if (this.connection == null)
            this.getConnection();
        try {
            PreparedStatement ps = this.connection.prepareStatement("SELECT c.* FROM Classes as c" +
                    " INNER JOIN Appartient as ap ON ap.ID_Classes = c.ID" +
                    " INNER JOIN Utilisateurs as u ON u.ID = ap.ID" +
                    " WHERE u.ID = ?");
            ps.setInt(1, this.ID);
            ResultSet result = ps.executeQuery();
            int nbClasses = -1;
            while (result.next()) {
                nbClasses++;
                this.classes.add(new Classe(result.getInt("ID"), result.getString("Nom")));
            }
            return nbClasses;
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
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
