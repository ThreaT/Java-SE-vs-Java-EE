package com.java.se.vs.java.ee.database.example;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement preparedStatement;

    public static void main(String[] args) {
        try {
            createDatabase();
            create(1, "HelloWorld!");
            read();
            update(1, "Updated HelloWorld!");
            delete(1);
            deleteDatabase();
        } catch (SQLException | IOException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void createDatabase() throws SQLException {
        System.out.println("Creating Database...");
        connection = DriverManager.getConnection("jdbc:derby:JavaSEDatabaseExample;create=true");
        statement = connection.createStatement();
        statement.execute("CREATE TABLE examples(id INT PRIMARY KEY, example varchar(500) NOT NULL)");
    }

    public static void create(Integer id, String example) throws SQLException {
        System.out.println("Creating Record...");
        String sql = "INSERT INTO examples VALUES (?, ?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, example);
        preparedStatement.executeUpdate();
    }

    public static void read() throws SQLException {
        System.out.println("Reading Records...");
        String sql = "SELECT * FROM examples";
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            Integer id = resultSet.getInt("id");
            String example = resultSet.getString("example");
            System.out.println("id: " + id + ", example: " + example);
        }
    }

    public static void update(Integer id, String example) throws SQLException {
        System.out.println("Updating Record...");
        preparedStatement = connection.prepareStatement("UPDATE examples SET example = ? WHERE id = ?");
        preparedStatement.setString(1, example);
        preparedStatement.setInt(2, id);
        preparedStatement.executeUpdate();
    }

    public static void delete(Integer id) throws SQLException {
        System.out.println("Deleting Record...");
        preparedStatement = connection.prepareStatement("DELETE FROM examples WHERE id = ?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

    public static void deleteDatabase() throws SQLException, IOException {
        File database = new File("JavaSEDatabaseExample");
        System.out.println("Deleting Database at " + database.getAbsolutePath() + "...");
        database.delete();
        preparedStatement.close();
        statement.close();
        connection.close();
    }
}
