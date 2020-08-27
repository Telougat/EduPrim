package com.eduprim.beans;

import java.sql.*;

public class Note extends Database {
    private int ID;
    private float note;
    private Date date;

    public Note() {
        super(false);
    }

    public Note(float note, Date date) {
        super(true);
        try {
            PreparedStatement ps = this.connection.prepareStatement("INSERT INTO Notes(Note, Date) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setFloat(1, note);
            ps.setDate(2, date);
            ps.executeUpdate();
            ResultSet result = ps.getGeneratedKeys();
            this.ID = result.getInt(1);
            this.note = result.getFloat("Note");
            this.date = result.getDate("Date");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Note(int ID, float note, Date date) {
        super(false);
        this.ID = ID;
        this.note = note;
        this.date = date;
    }

    public int getID() {
        return ID;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void findNote(int id) {
        if (this.connection == null)
            this.getConnection();
        try {
            PreparedStatement ps = this.connection.prepareStatement("SELECT * FROM Notes WHERE ID = ?");
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            this.ID = result.getInt("ID");
            this.note = result.getFloat("Note");
            this.date = result.getDate("Date");
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
            PreparedStatement ps = this.connection.prepareStatement("UPDATE Notes SET Note = ?, Date = ? WHERE ID = ?");
            ps.setFloat(1, this.note);
            ps.setDate(2, this.date);
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
