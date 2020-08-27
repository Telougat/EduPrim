package com.eduprim.beans;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Livre extends Database {
    private int ID;
    private String titre;
    private String auteur;
    private String reference;

    public Livre(){
        super(false);
    }

    public Livre(String titre, String auteur, String reference) {
        super(true);
        try {
            PreparedStatement ps = this.connection.prepareStatement("INSERT INTO Livres(Titre, Auteur, Reference) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, titre);
            ps.setString(2, auteur);
            ps.setString(3, reference);
            ps.executeUpdate();
            ResultSet result = ps.getGeneratedKeys();
            result.next();
            this.ID = result.getInt(1);
            this.auteur = auteur;
            this.titre = titre;
            this.reference = reference;
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }
    }

    public int getID() {
        return ID;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public boolean rendre() {
        if (Emprunt.isEmprunter(this)) {
            try {
                PreparedStatement ps = this.connection.prepareStatement("UPDATE Emprunte SET DateFin = ? WHERE ID_Livres = ?");
                ps.setInt(1, this.ID);
                int modifications = ps.executeUpdate();
                if (modifications > 0)
                    return true;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }
}
