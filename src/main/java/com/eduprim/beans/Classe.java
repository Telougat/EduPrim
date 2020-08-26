package com.eduprim.beans;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Classe extends Database {

    private int ID;
    private String nom;

    public Classe() {
        super(false);
    }

    public Classe(String nom) {
        super(true);
        try{
            PreparedStatement ps = this.connection.prepareStatement("INSERT INTO Classes(Nom) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, nom);
            ps.executeUpdate();
            ResultSet result = ps.getGeneratedKeys();
            result.next();
            this.ID = result.getInt(1);
            this.nom = nom;
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Classe(int id, String nom) {
        super(false);
        this.ID = id;
        this.nom = nom;
    }

    public Classe(Classe classe) {
        super(false);
        this.ID = classe.getID();
        this.nom = classe.getNom();
    }

    public int getID() {
        return ID;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean findClasse(String nom) {
        if (this.connection == null)
            this.getConnection();
        try {
            PreparedStatement ps = this.connection.prepareStatement("SELECT * FROM Classes WHERE Nom = ?");
            ps.setString(1, nom);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                this.ID = result.getInt("ID");
                this.nom = result.getString("Nom");
                return true;
            }
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean findClasse(int Id) {
        if (this.connection == null)
            this.getConnection();
        try {
            PreparedStatement ps = this.connection.prepareStatement("SELECT * FROM Classes WHERE ID = ?");
            ps.setInt(1, Id);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                this.ID = result.getInt("ID");
                this.nom = result.getString("Nom");
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
        if (this.nom.isEmpty() || this.ID <= 0)
            return false;
        if (this.connection == null)
            this.getConnection();
        try {
            PreparedStatement ps = this.connection.prepareStatement("UPDATE Classes SET Nom = ? WHERE ID = ?");
            ps.setString(1, this.nom);
            ps.setInt(2, this.ID);
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
