package com.eduprim.beans;

import java.sql.*;
import java.util.ArrayList;

public class Matiere extends Database {
    private int ID;
    private String label;

    public Matiere() {
        super(false);
    }

    public Matiere(int ID, String label) {
        super(false);
        this.ID = ID;
        this.label = label;
    }

    public Matiere(String label) {
        super(true);
        try {
            PreparedStatement ps = this.connection.prepareStatement("INSERT INTO Matiere(Label) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, label);
            ps.executeUpdate();
            ResultSet result = ps.getGeneratedKeys();
            this.ID = result.getInt(1);
            this.label = label;
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }
    }

    public int getID() {
        return ID;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public static ArrayList<Matiere> getAllMatieres() {
        Database database = new Database(true);
        Connection connection = database.getConnection();
        ArrayList<Matiere> matieres = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Matiere");
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                matieres.add(new Matiere(result.getInt("ID"), result.getString("Label")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return matieres;
    }

    public void findMatiere(String label) {
        if (this.connection == null)
            this.getConnection();
        try {
            PreparedStatement ps = this.connection.prepareStatement("SELECT ID, Label FROM Matiere WHERE Label = ?");
            ps.setString(1, label);
            ResultSet result = ps.executeQuery();
            this.ID = result.getInt("ID");
            this.label = result.getString("Label");
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean save() {
        if (this.ID <= 0)
            return false;
        if (this.connection == null)
            this.getConnection();
        try {
            PreparedStatement ps = this.connection.prepareStatement("UPDATE Matiere SET Label = ? WHERE ID = ?");
            ps.setString(1, this.label);
            ps.setInt(2, this.ID);
            int modifications = ps.executeUpdate();
            if (modifications > 0)
                return true;
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
