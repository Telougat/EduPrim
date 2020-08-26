package com.eduprim.beans;

import java.sql.*;

public class Adulte extends Utilisateur {

    private long telephone;

    public Adulte() {
        super();
    }

    public Adulte(String nom, String prenom, Date naissance, String addresse, Status status, long telephone) {
        super(nom, prenom, naissance, addresse, status);
        this.telephone = telephone;
        this.saveNewAdulte();
    }

    public Adulte(Utilisateur utilisateur, long telephone) {
        super();
        if (utilisateur.getStatus().getLabel().equals("Professeur") || utilisateur.getStatus().getLabel().equals("Directeur")) {
            if (this.connection == null)
                this.getConnection();
            try {
                PreparedStatement ps = this.connection.prepareStatement("INSERT INTO Adulte(ID, Nom, Prenom, DateDeNaissance, Adresse, ID_Status, Telephone) VALUES (?, ?, ?, ?, ?, ?, ?)");
                ps.setInt(1, utilisateur.getID());
                ps.setString(2, utilisateur.getNom());
                ps.setString(3, utilisateur.getPrenom());
                ps.setDate(4, utilisateur.getDateDeNaissance());
                ps.setString(5, utilisateur.getAdresse());
                ps.setInt(6, utilisateur.getStatus().getID());
                ps.setLong(7, telephone);
                ps.executeUpdate();
                this.setID(utilisateur.getID());
                this.setNom(utilisateur.getNom());
                this.setPrenom(utilisateur.getPrenom());
                this.setDateDeNaissance(utilisateur.getDateDeNaissance());
                this.setAdresse(utilisateur.getAdresse());
                this.setStatus(utilisateur.getStatus());
                this.telephone = telephone;
            }
            catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void saveNewAdulte() {
        if (this.connection == null)
            this.getConnection();
        try {
            PreparedStatement ps = this.connection.prepareStatement("INSERT INTO Adulte(ID, Nom, Prenom, DateDeNaissance, Adresse, ID_Status, Telephone) VALUES (?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, this.getID());
            ps.setString(2, this.getNom());
            ps.setString(3, this.getPrenom());
            ps.setDate(4, this.getDateDeNaissance());
            ps.setString(5, this.getAdresse());
            ps.setInt(6, this.getStatus().getID());
            ps.setLong(7, this.telephone);
            ps.executeUpdate();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean findAdulte(int id) {
        super.findUtilisateur(id);
        try {
            PreparedStatement ps = this.connection.prepareStatement("SELECT Telephone FROM Adulte WHERE ID = ?");
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                this.telephone = result.getInt("Telephone");
                return true;
            }
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean save(boolean dontSaveUtilisateur) {
        if (this.getID() <= 0)
            return false;
        if (this.connection == null)
            this.getConnection();
        if (!dontSaveUtilisateur)
            super.save();
        try {
            PreparedStatement ps = this.connection.prepareStatement("UPDATE Adulte SET Nom = ?, Prenom = ?, DateDeNaissance = ?, Adresse = ?, ID_Status = ?, Telephone = ? WHERE ID = ?");
            ps.setString(1, this.getNom());
            ps.setString(2, this.getPrenom());
            ps.setDate(3, this.getDateDeNaissance());
            ps.setString(4, this.getAdresse());
            ps.setInt(5, this.getStatus().getID());
            ps.setLong(6, this.telephone);
            ps.setInt(7, this.getID());
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
