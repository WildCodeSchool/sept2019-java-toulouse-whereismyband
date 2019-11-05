package com.wildcodeschool.whereismyband.repository;

import com.wildcodeschool.whereismyband.entity.Musician;

import java.sql.*;

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
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
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
}

