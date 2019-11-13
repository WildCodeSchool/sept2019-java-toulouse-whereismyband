package com.wildcodeschool.whereismyband.repository;

import com.wildcodeschool.whereismyband.entity.Need;

import java.sql.*;

public class NeedRepository {
    private final static String DB_URL = "jdbc:mysql://localhost:3306/where_is_my_band?serverTimezone=GMT";
    private final static String DB_USER = "h4rryp0tt3r";
    private final static String DB_PASSWORD = "Horcrux4life!";

    public Need save(Long idInstrument, Long idBand, String availability, int level) {
        try {
            Connection connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO need (id_instrument, id_band, availability, level, encours) " +
                            "VALUES (?, ?, ?, ?, ?);",
                    Statement.RETURN_GENERATED_KEYS
            );
            statement.setLong(1, idInstrument);
            statement.setLong(2, idBand);
            statement.setString(3, availability);
            statement.setInt(4, level);
            statement.setInt(5, 1);

            if (statement.executeUpdate() != 1) {
                throw new SQLException("failed to insert data");
            }

            ResultSet generatedKeys = statement.getGeneratedKeys();

            if (generatedKeys.next()) {
                Long id = generatedKeys.getLong(1);
                return new Need(id, idInstrument, idBand, availability, level);
            } else {
                throw new SQLException("failed to get inserted id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Long desactiveNeed(Long idNeed) {
        try {
            Connection connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE need SET encours = 0 WHERE id_need = ?;"
            );
            statement.setLong(1, idNeed);
            if (statement.executeUpdate() != 1) {
                throw new SQLException("failed to insert data");
            }

            ResultSet generatedKeys = statement.getGeneratedKeys();

            if (statement.executeUpdate() != 1) {
                throw new SQLException("failed to update data");
            }

            return idNeed;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return idNeed;
    }
}
