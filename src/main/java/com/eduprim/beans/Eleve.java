package com.eduprim.beans;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Eleve extends Utilisateur {
    private String mailParent;
    private String telephoneParent;

    public Eleve(){
        super();
    }

    public Eleve(String nom, String prenom, Date naissance, String addresse, Status status, String mail, String telephone) {
        super(nom, prenom, naissance, addresse, status);
        this.mailParent = mail;
        this.telephoneParent = telephone;
        this.saveNewEleve();
    }

    public Eleve(Utilisateur utilisateur, String mail, String telephone) {
        this(utilisateur.getNom(), utilisateur.getPrenom(), utilisateur.getDateDeNaissance(), utilisateur.getAdresse(), utilisateur.getStatus(), mail, telephone);
    }

    public String getMailParent() {
        return mailParent;
    }

    public void setMailParent(String mailParent) {
        this.mailParent = mailParent;
    }

    public String getTelephoneParent() {
        return telephoneParent;
    }

    public void setTelephoneParent(String telephoneParent) {
        this.telephoneParent = telephoneParent;
    }

    public boolean findEleve(int id) {
        boolean utilisateurFound = super.findUtilisateur(id);
        if (!utilisateurFound)
            return false;
        try {
            PreparedStatement ps = this.connection.prepareStatement("SELECT Telephone_Parent, Mail_Parent FROM Eleve WHERE ID = ?");
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                this.telephoneParent = result.getString("Telephone_Parent");
                this.mailParent = result.getString("Mail_Parent");
                return true;
            }
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    private void saveNewEleve() {
        if (this.connection == null)
            this.getConnection();
        try {
            PreparedStatement ps = this.connection.prepareStatement("INSERT INTO Eleve(ID, Nom, Prenom, DateDeNaissance, Adresse, ID_Status, Telephone_Parent, Mail_Parent) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, this.getID());
            ps.setString(2, this.getNom());
            ps.setString(3, this.getPrenom());
            ps.setDate(4, this.getDateDeNaissance());
            ps.setString(5, this.getAdresse());
            ps.setInt(6, this.getStatus().getID());
            ps.setString(7, this.telephoneParent);
            ps.setString(8, this.mailParent);
            ps.executeUpdate();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean save(boolean dontSaveUtilisateur) {
        if (this.getID() <= 0)
            return false;
        if (this.connection == null)
            this.getConnection();
        if (!dontSaveUtilisateur)
            super.save();
        try {
            PreparedStatement ps = this.connection.prepareStatement("UPDATE Eleve SET Nom = ?, Prenom = ?, DateDeNaissance = ?, Adresse = ?, ID_Status = ?, Telephone_Parent = ?, Mail_Parent = ? WHERE ID = ?");
            ps.setString(1, this.getNom());
            ps.setString(2, this.getPrenom());
            ps.setDate(3, this.getDateDeNaissance());
            ps.setString(4, this.getAdresse());
            ps.setInt(5, this.getStatus().getID());
            ps.setString(6, this.telephoneParent);
            ps.setString(7, this.mailParent);
            ps.setInt(8, this.getID());
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
