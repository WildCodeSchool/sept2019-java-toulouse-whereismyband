package com.wildcodeschool.whereismyband.repository;

import com.wildcodeschool.whereismyband.entity.BandStyle;
import java.sql.*;

public class BandStyleRepository {

    private final static String DB_URL = "jdbc:mysql://localhost:3306/where_is_my_band?serverTimezone=GMT";
    private final static String DB_USER = "h4rryp0tt3r";
    private final static String DB_PASSWORD = "Horcrux4life!";

    public BandStyle save(Long idStyle, Long idBand) {
        try {
            Connection connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO band_style (id_style, id_band) " +
                            "VALUES (?, ?);",
                    Statement.RETURN_GENERATED_KEYS
            );
            statement.setLong(1, idStyle);
            statement.setLong(2, idBand);

            if (statement.executeUpdate() != 1) {
                throw new SQLException("failed to insert data");
            }

            ResultSet generatedKeys = statement.getGeneratedKeys();

            if (generatedKeys.next()) {
                Long id = generatedKeys.getLong(1);
                return new BandStyle(idStyle, idBand);
            } else {
                throw new SQLException("failed to get inserted id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public BandStyle update(Long idStyle, Long idBand) {
        try {
            Connection connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE band_style SET id_style = ? WHERE id_band = ?",
                    Statement.RETURN_GENERATED_KEYS
            );
            statement.setLong(1, idStyle);
            statement.setLong(2, idBand);

            if (statement.executeUpdate() != 1) {
                throw new SQLException("failed to update data");
            }
            return new BandStyle(idStyle, idBand);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
