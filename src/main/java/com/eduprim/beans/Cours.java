package com.eduprim.beans;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Cours extends Database {
    private Note note;
    private Matiere matiere;
    private Utilisateur utilisateur;
    private Presence presence;
    private Timestamp dateDebut;
    private Timestamp dateFin;

    public Cours() {
        super(false);
    }

    public Cours(Note note, Matiere matiere, Utilisateur utilisateur, Presence presence, Timestamp dateDebut, Timestamp dateFin, boolean existe) {
        super(true);
        if (!existe) {
            try {
                PreparedStatement ps = this.connection.prepareStatement("INSERT INTO Cours(ID, ID_Matiere, ID_Utilisateurs, ID_Presences, DateDebut, DateFin) VALUES (?, ?, ?, ?, ?, ?)");
                ps.setInt(1, note.getID());
                ps.setInt(2, matiere.getID());
                ps.setInt(3, utilisateur.getID());
                ps.setInt(4, presence.getID());
                ps.setTimestamp(5, dateDebut);
                ps.setTimestamp(6, dateFin);
                ps.executeUpdate();
                this.note = note;
                this.matiere = matiere;
                this.utilisateur = utilisateur;
                this.presence = presence;
                this.dateDebut = dateDebut;
                this.dateFin = dateFin;
            }
            catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            this.note = note;
            this.matiere = matiere;
            this.utilisateur = utilisateur;
            this.presence = presence;
            this.dateDebut = dateDebut;
            this.dateFin = dateFin;
        }
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Presence getPresence() {
        return presence;
    }

    public void setPresence(Presence presence) {
        this.presence = presence;
    }

    public Timestamp getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Timestamp dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Timestamp getDateFin() {
        return dateFin;
    }

    public void setDateFin(Timestamp dateFin) {
        this.dateFin = dateFin;
    }

    public boolean save() {
        if (this.utilisateur != null && this.presence != null)
            return false;
        if (this.connection == null)
            this.getConnection();
        try {
            PreparedStatement ps = this.connection.prepareStatement("UPDATE Cours SET DateDebut = ?, DateFin = ? WHERE ID_Presences = ? AND ID_Utilisateurs = ?");
            ps.setTimestamp(1, this.dateDebut);
            ps.setTimestamp(2, this.dateFin);
            ps.setInt(3, this.presence.getID());
            ps.setInt(4, this.utilisateur.getID());
            int modifications = ps.executeUpdate();
            if (modifications > 0)
                return true;
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
