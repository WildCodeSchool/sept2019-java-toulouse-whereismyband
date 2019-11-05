package com.wildcodeschool.whereismyband.repository;

import com.wildcodeschool.whereismyband.entity.LevelInstrument;

import java.sql.*;

public class LevelInstrumentRepository {

    private final static String DB_URL = "jdbc:mysql://localhost:3306/where_is_my_band?serverTimezone=GMT";
    private final static String DB_USER = "h4rryp0tt3r";
    private final static String DB_PASSWORD = "Horcrux4life!";

    public LevelInstrument save(int id_musician, int id_instrument, int level) {
        try {
            Connection connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO level_instrument(id_musician, id_instrument, level) VALUES (?, ?, ?);"
            );
            statement.setInt(1, id_musician);
            statement.setInt(2, id_instrument);
            statement.setInt(3, level);


            if (statement.executeUpdate() != 1) {
                throw new SQLException("failed to insert data");
            }
            return new LevelInstrument(id_musician, id_instrument, level);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
