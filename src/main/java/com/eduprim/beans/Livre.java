package com.eduprim.beans;

import java.sql.*;
import java.util.ArrayList;

public class Livre extends Database {
    private int ID;
    private String titre;
    private String auteur;
    private String reference;

    public Livre(){
        super(false);
    }

    public Livre(int ID, String titre, String auteur, String reference) {
        super(false);
        this.ID = ID;
        this.titre = titre;
        this.auteur = auteur;
        this.reference = reference;
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

    public static ArrayList<Livre> getAllLivres() {
        Database database = new Database(true);
        Connection connection = database.getConnection();
        ArrayList<Livre> livres = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Livres");
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                livres.add(new Livre(result.getInt("ID"), result.getString("Titre"), result.getString("Auteur"), result.getString("Reference")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return livres;
    }

    public void findLivre(int id) {
        if (this.connection == null)
            this.getConnection();
        try {
            PreparedStatement ps = this.connection.prepareStatement("SELECT * FROM Livres WHERE ID = ?");
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            result.next();
            this.ID = result.getInt("ID");
            this.titre = result.getString("Titre");
            this.reference = result.getString("Reference");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean rendre() {
        if (Emprunt.isEmprunter(this)) {
            try {
                PreparedStatement ps = this.connection.prepareStatement("UPDATE Emprunte SET DateFin = ? WHERE ID_Livres = ?");
                ps.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
                ps.setInt(2, this.ID);
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
