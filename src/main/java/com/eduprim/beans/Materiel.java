package com.eduprim.beans;

import java.sql.*;
import java.util.ArrayList;

public class Materiel extends Database {
    private int ID;
    private String label;
    private String reference;

    public Materiel() {
        super(false);
    }

    public Materiel(int ID, String label, String reference) {
        super(false);
        this.ID = ID;
        this.label = label;
        this.reference = reference;
    }

    public Materiel(String label, String reference) {
        super(true);
        try {
            PreparedStatement ps = this.connection.prepareStatement("INSERT INTO Materiels(Label, Reference) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, label);
            ps.setString(2, reference);
            ps.executeUpdate();
            ResultSet result = ps.getGeneratedKeys();
            result.next();
            this.ID = result.getInt(1);
            this.label = label;
            this.reference = reference;
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

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public static ArrayList<Materiel> getAllMateriels() {
        Database database = new Database(true);
        Connection connection = database.getConnection();
        ArrayList<Materiel> materiels = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM Materiels");
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                materiels.add(new Materiel(result.getInt("ID"), result.getString("Label"), result.getString("Reference")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return materiels;
    }

    public boolean rendre() {
        if (UtilisationMateriel.isEmprunter(this)) {
            try {
                PreparedStatement ps = this.connection.prepareStatement("UPDATE Utilise SET DateFin = ? WHERE ID_Materiels = ?");
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

    public void findMateriel(int id) {
        if (this.connection == null)
            this.getConnection();
        try {
            PreparedStatement ps = this.connection.prepareStatement("SELECT * FROM Materiels WHERE ID = ?");
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            result.next();
            this.ID = result.getInt("ID");
            this.label = result.getString("Label");
            this.reference = result.getString("Reference");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
