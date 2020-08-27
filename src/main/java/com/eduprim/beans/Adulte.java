package com.eduprim.beans;

import java.sql.*;

public class Adulte extends Utilisateur {

    private long telephone;
    private String mail;

    public Adulte() {
        super();
    }

    public Adulte(String nom, String prenom, Date naissance, String addresse, Status status, long telephone, String mail, String motDePasse) {
        super(nom, prenom, naissance, addresse, status);
        this.telephone = telephone;
        this.mail = mail;
        this.saveNewAdulte(motDePasse);
    }

    public Adulte(Utilisateur utilisateur) {
        super(utilisateur);
        try {
            PreparedStatement ps = this.connection.prepareStatement("SELECT Telephone FROM Adulte WHERE ID = ?");
            ps.setInt(1, utilisateur.getID());
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                this.telephone = result.getInt("Telephone");
            }
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }

    public Adulte(Utilisateur utilisateur, long telephone, String mail, String motDePasse) {
        super();
            if (this.connection == null)
                this.getConnection();
            try {
                PreparedStatement ps = this.connection.prepareStatement("INSERT INTO Adulte(ID, Nom, Prenom, DateDeNaissance, Adresse, ID_Status, Telephone, Mail, MotDePasse) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
                ps.setInt(1, utilisateur.getID());
                ps.setString(2, utilisateur.getNom());
                ps.setString(3, utilisateur.getPrenom());
                ps.setDate(4, utilisateur.getDateDeNaissance());
                ps.setString(5, utilisateur.getAdresse());
                ps.setInt(6, utilisateur.getStatus().getID());
                ps.setLong(7, telephone);
                ps.setString(8, mail);
                ps.setString(9, motDePasse);
                ps.executeUpdate();
                this.setID(utilisateur.getID());
                this.setNom(utilisateur.getNom());
                this.setPrenom(utilisateur.getPrenom());
                this.setDateDeNaissance(utilisateur.getDateDeNaissance());
                this.setAdresse(utilisateur.getAdresse());
                this.setStatus(utilisateur.getStatus());
                this.telephone = telephone;
                this.mail = mail;
            }
            catch (SQLException ex) {
                ex.printStackTrace();
            }
    }

    public static Adulte connexion(String mail, String motDePasse) {
        Database database = new Database(false);
        Connection connection = database.getConnection();
        Adulte adulte = new Adulte();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT ID FROM Adulte WHERE Mail = ? AND MotDePasse = ?");
            ps.setString(1, mail);
            ps.setString(2, motDePasse);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                adulte.findAdulte(result.getInt("ID"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return adulte;
    }

    public long getTelephone() {
        return telephone;
    }

    public void setTelephone(long telephone) {
        this.telephone = telephone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    private void saveNewAdulte(String motDePasse) {
        if (this.connection == null)
            this.getConnection();
        try {
            PreparedStatement ps = this.connection.prepareStatement("INSERT INTO Adulte(ID, Nom, Prenom, DateDeNaissance, Adresse, ID_Status, Telephone, MotDePasse, Mail) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, this.getID());
            ps.setString(2, this.getNom());
            ps.setString(3, this.getPrenom());
            ps.setDate(4, this.getDateDeNaissance());
            ps.setString(5, this.getAdresse());
            ps.setInt(6, this.getStatus().getID());
            ps.setLong(7, this.telephone);
            ps.setString(8, motDePasse);
            ps.setString(9, this.mail);
            ps.executeUpdate();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean findAdulte(int id) {
        boolean utilisateurFound = super.findUtilisateur(id);
        if (!utilisateurFound)
            return false;
        try {
            PreparedStatement ps = this.connection.prepareStatement("SELECT Telephone, Mail FROM Adulte WHERE ID = ?");
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                this.telephone = result.getInt("Telephone");
                this.mail = result.getString("Mail");
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
            PreparedStatement ps = this.connection.prepareStatement("UPDATE Adulte SET Nom = ?, Prenom = ?, DateDeNaissance = ?, Adresse = ?, ID_Status = ?, Telephone = ?, Mail = ? WHERE ID = ?");
            ps.setString(1, this.getNom());
            ps.setString(2, this.getPrenom());
            ps.setDate(3, this.getDateDeNaissance());
            ps.setString(4, this.getAdresse());
            ps.setInt(5, this.getStatus().getID());
            ps.setLong(6, this.telephone);
            ps.setInt(7, this.getID());
            ps.setString(8, this.mail);
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
