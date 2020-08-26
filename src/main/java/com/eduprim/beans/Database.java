package com.eduprim.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class Database {
    private final String bdd;
    private final String url;
    private final String args;
    private final String user;
    private final String password;
    private Connection connection;

    public Database() {
        this.bdd = "javaCP";
        this.url = "jdbc:mysql://51.15.2.200:3306/";
        this.args = "?serverTimezone=UTC";
        this.user = "javaCP";
        this.password = "enloketi";
    }

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url+bdd+args,user,password);
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return connection;
    }

    public void closeConnection()
    {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void insertTest() {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO Classes(Nom) VALUES (?)");
            ps.setString(1, "TestConnexion");
            ps.executeUpdate();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
