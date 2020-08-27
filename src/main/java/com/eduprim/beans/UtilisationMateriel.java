package com.eduprim.beans;

import java.sql.*;
import java.util.ArrayList;

public class UtilisationMateriel extends Database{
    private Timestamp dateDebut;
    private Timestamp dateFin;
    private Materiel materiel;
    private Utilisateur utilisateur;

    public UtilisationMateriel(Timestamp dateDebut, Timestamp dateFin, Materiel materiel, Utilisateur utilisateur, boolean existe) {
        super(true);
        if (!UtilisationMateriel.isEmprunter(materiel) && !existe)
        {
            try {
                PreparedStatement ps = this.connection.prepareStatement("INSERT INTO Utilise(ID, ID_Materiels, DateDebut, DateFin) VALUES (?, ?, ?, ?)");
                ps.setInt(1, utilisateur.getID());
                ps.setInt(2, materiel.getID());
                ps.setTimestamp(3, dateDebut);
                ps.setTimestamp(4, dateFin);
                ps.executeUpdate();
                this.dateDebut = dateDebut;
                this.dateFin = dateFin;
                this.materiel = materiel;
                this.utilisateur = utilisateur;
            }
            catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else if(existe) {
            this.dateDebut = dateDebut;
            this.dateFin = dateFin;
            this.utilisateur = utilisateur;
            this.materiel = materiel;
        }
    }

    public static ArrayList<UtilisationMateriel> getEmprunts(Utilisateur utilisateur) {
        Database database = new Database(true);
        Connection connection = database.getConnection();
        ArrayList<UtilisationMateriel> emprunts = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT ut.DateDebut, ut.DateFin, m.ID as materielID, m.Label as materielLabel, m.Reference as materielReference FROM Utilise as ut" +
                    " INNER JOIN Materiels as m ON m.ID = ut.ID_Materiels" +
                    " WHERE ut.ID = ?");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return emprunts;
    }

    public void save() {
        if (this.connection == null)
            this.getConnection();
        try {
            PreparedStatement ps = this.connection.prepareStatement("UPDATE Utilise SET ID = ?, DateDebut = ?, DateFin = ? WHERE ID_Materiels = ?");
            ps.setInt(1, this.utilisateur.getID());
            ps.setTimestamp(2, this.dateDebut);
            ps.setTimestamp(3, this.dateFin);
            ps.setInt(4, this.materiel.getID());
            ps.executeUpdate();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static boolean isEmprunter(Materiel materiel) {
        Database database = new Database(true);
        Connection connection = database.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT MAX(ut.DateFin) as dernierEmprunt FROM Utilise as ut" +
                    " INNER JOIN Materiels as m ON m.ID = ut.ID_Materiels" +
                    " WHERE ut.ID_Materiels = ?");
            ps.setInt(1, materiel.getID());
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                if (result.getTimestamp("dernierEmprunt") != null) {
                    Timestamp dateFinDernierEmprunt = result.getTimestamp("dernierEmprunt");
                    return dateFinDernierEmprunt.after(new Timestamp(System.currentTimeMillis()));
                } else {
                    return false;
                }
            }
            else
                return false;
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
