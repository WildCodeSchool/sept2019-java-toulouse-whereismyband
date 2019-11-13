package com.wildcodeschool.whereismyband.repository;

import com.wildcodeschool.whereismyband.entity.Band;
import com.wildcodeschool.whereismyband.entity.BandStyle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BandRepository {

        private final static String DB_URL = "jdbc:mysql://localhost:3306/where_is_my_band?serverTimezone=GMT";
        private final static String DB_USER = "h4rryp0tt3r";
        private final static String DB_PASSWORD = "Horcrux4life!";

        public Band save(String name, String bio, int searchType, String postcode, long idMusician) {
            try {
                Connection connection = DriverManager.getConnection(
                        DB_URL, DB_USER, DB_PASSWORD
                );
                PreparedStatement statement = connection.prepareStatement(
                        "INSERT INTO band (name, bio, search_type, postcode, id_musician) " +
                                "VALUES (?, ?, ?, ?, ?);",
                        Statement.RETURN_GENERATED_KEYS
                );
                statement.setString(1, name);
                statement.setString(2, bio);
                statement.setInt(3, searchType);
                statement.setString(4, postcode);
                statement.setLong(5, idMusician);

                if (statement.executeUpdate() != 1) {
                    throw new SQLException("failed to insert data");
                }

                ResultSet generatedKeys = statement.getGeneratedKeys();

                if (generatedKeys.next()) {
                    Long id = generatedKeys.getLong(1);
                    return new Band(id, name, bio, searchType, postcode, idMusician);
                } else {
                    throw new SQLException("failed to get inserted id");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }

    public Band update(long idBand, String name, String bio, int searchType, String postcode, long idMusician) {
        try {
            Connection connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE band SET name = ?, bio = ?, search_type = ?, postcode = ?, id_musician = ? WHERE id_band = ?",
                    Statement.RETURN_GENERATED_KEYS
            );
            statement.setString(1, name);
            statement.setString(2, bio);
            statement.setInt(3, searchType);
            statement.setString(4, postcode);
            statement.setLong(5, idMusician);
            statement.setLong(6, idBand);


            if (statement.executeUpdate() != 1) {
                throw new SQLException("failed to update data");
            }
            return new Band(idBand, name, bio, searchType, postcode, idMusician);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
