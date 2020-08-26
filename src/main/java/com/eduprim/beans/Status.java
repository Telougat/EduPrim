package com.eduprim.beans;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Status extends Database {
    private int ID;
    private String Label;

    public Status() {
        super(false);
    }

    public Status(String Designation) {
        super(true);
        try{
            PreparedStatement ps = this.connection.prepareStatement("INSERT INTO Status(Label) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, Designation);
            ps.executeUpdate();
            ResultSet result = ps.getGeneratedKeys();
            result.next();
            this.ID = result.getInt(1);
            this.Label = Designation;
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Status(int id, String label) {
        super(false);
        this.ID = id;
        this.Label = label;
    }

    public Status(Status status) {
        super(false);
        this.ID = status.getID();
        this.Label = status.getLabel();
    }

    public int getID() {
        return ID;
    }

    public String getLabel() {
        return Label;
    }

    public void setLabel(String label) {
        Label = label;
    }

    public boolean findStatus(String Label) {
        if (this.connection == null)
            this.getConnection();
        try {
            PreparedStatement ps = this.connection.prepareStatement("SELECT * FROM Status WHERE Label = ?");
            ps.setString(1, Label);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                this.ID = result.getInt("ID");
                this.Label = result.getString("Label");
                return true;
            }
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean findStatus(int Id) {
        if (this.connection == null)
            this.getConnection();
        try {
            PreparedStatement ps = this.connection.prepareStatement("SELECT * FROM Status WHERE ID = ?");
            ps.setInt(1, Id);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                this.ID = result.getInt("ID");
                this.Label = result.getString("Label");
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
        if (this.Label.isEmpty() || this.ID <= 0)
            return false;
        if (this.connection == null)
            this.getConnection();
        try {
            PreparedStatement ps = this.connection.prepareStatement("UPDATE Status SET Label = ? WHERE ID = ?");
            ps.setString(1, this.Label);
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
