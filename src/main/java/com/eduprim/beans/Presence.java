package com.eduprim.beans;

import java.sql.*;

public class Presence extends Database{
    private int ID;
    private Timestamp date;
    private boolean present;

    public Presence() {
        super(false);
    }

    public Presence(int ID, Timestamp date, boolean present) {
        super(false);
        this.ID = ID;
        this.date = date;
        this.present = present;
    }

    public Presence(Timestamp date, boolean present) {
        super(true);
        try {
            PreparedStatement ps = this.connection.prepareStatement("INSERT INTO Presences(Date, Present) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setTimestamp(1, date);
            ps.setBoolean(2, present);
            ps.executeUpdate();
            ResultSet result = ps.getGeneratedKeys();
            result.next();
            this.ID = result.getInt(1);
            this.date = date;
            this.present = present;
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }
    }

    public int getID() {
        return ID;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }

    public void findPresent(int id) {
        if (this.connection == null)
            this.getConnection();
        try {
            PreparedStatement ps = this.connection.prepareStatement("SELECT * FROM Presences WHERE ID = ?");
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            result.next();
            this.ID = id;
            this.date = result.getTimestamp("Date");
            this.present = result.getBoolean("Present");
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
            PreparedStatement ps = this.connection.prepareStatement("UPDATE Presences SET Date = ?, Present = ? WHERE ID = ?");
            ps.setTimestamp(1, this.date);
            ps.setBoolean(2, this.present);
            ps.setInt(3, this.ID);
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
