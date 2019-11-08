package com.wildcodeschool.whereismyband.repository;

import com.wildcodeschool.whereismyband.entity.Instrument;
import com.wildcodeschool.whereismyband.entity.Musician;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MusicianRepository {

    private final static String DB_URL = "jdbc:mysql://localhost:3306/where_is_my_band?serverTimezone=GMT";
    private final static String DB_USER = "h4rryp0tt3r";
    private final static String DB_PASSWORD = "Horcrux4life!";

    public Musician save(String password, String alias, String email, String postcode, String bio,
                         String avatar, String availability, int searchType) {
        try {
            Connection connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO musician (password, alias, email, postcode, bio, avatar, availability, search_type) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?);",
                    Statement.RETURN_GENERATED_KEYS
            );
            statement.setString(1, password);
            statement.setString(2, alias);
            statement.setString(3, email);
            statement.setString(4, postcode);
            statement.setString(5, bio);
            statement.setString(6, avatar);
            statement.setString(7, availability);
            statement.setInt(8, searchType);

            if (statement.executeUpdate() != 1) {
                throw new SQLException("failed to insert data");
            }

            ResultSet generatedKeys = statement.getGeneratedKeys();

            if (generatedKeys.next()) {
                int id = generatedKeys.getInt(1);
                return new Musician(id, password, alias, email, postcode, bio,
                        avatar, availability, searchType);
            } else {
                throw new SQLException("failed to get inserted id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Musician getMusicianLogIn(String mail, String pass) {

        try {
            Connection connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            PreparedStatement statement = connection.prepareStatement(

                    "SELECT * FROM musician where email = ? and password = ?;"
            );

            statement.setString(1, mail);
            statement.setString(2, pass);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int id_musician = resultSet.getInt("id_musician");
                String password = resultSet.getString("password");
                String alias = resultSet.getString("alias");
                String email = resultSet.getString("email");
                String postcode = resultSet.getString("postcode");
                String bio = resultSet.getString("bio");
                String avatar = resultSet.getString("avatar");
                String availability = resultSet.getString("availability");
                int searchType = resultSet.getInt("search_type");
                return new Musician(id_musician, password, alias, email, postcode, bio, avatar, availability, searchType);
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Musician update(int idMusician, String password, String alias, String email, String postcode, String bio,
                           String avatar, String availability, int searchType) {

        try {
            Connection connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE musician SET password = ?, alias = ?, email = ?, postcode = ?, bio = ?, avatar = ?, availability = ?," +
                            " search_type = ? WHERE id_musician = ?",
                    Statement.RETURN_GENERATED_KEYS
            );
            statement.setString(1, password);
            statement.setString(2, alias);
            statement.setString(3, email);
            statement.setString(4, postcode);
            statement.setString(5, bio);
            statement.setString(6, avatar);
            statement.setString(7, availability);
            statement.setInt(8, searchType);
            statement.setInt(9, idMusician);

            if (statement.executeUpdate() != 1) {
                throw new SQLException("failed to update data");
            }
            return new Musician(idMusician, password, alias, email, postcode, bio,
                    avatar, availability, searchType);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}