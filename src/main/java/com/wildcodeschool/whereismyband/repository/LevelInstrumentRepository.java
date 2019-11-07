package com.wildcodeschool.whereismyband.repository;

import com.wildcodeschool.whereismyband.entity.LevelInstrument;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LevelInstrumentRepository {

    private final static String DB_URL = "jdbc:mysql://localhost:3306/where_is_my_band?serverTimezone=GMT";
    private final static String DB_USER = "h4rryp0tt3r";
    private final static String DB_PASSWORD = "Horcrux4life!";

    public LevelInstrument save(int idMusician, int idInstrument, int level) {
        try {
            Connection connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO level_instrument(id_musician, id_instrument, level) VALUES (?, ?, ?);"
            );
            statement.setInt(1, idMusician);
            statement.setInt(2, idInstrument);
            statement.setInt(3, level);
            if (statement.executeUpdate() != 1) {
                throw new SQLException("failed to insert data");
            }
            return new LevelInstrument(idMusician, idInstrument, level);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public LevelInstrument update(int idMusician, int idInstrument, int level, int previousInstrument) {
        try {
            Connection connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE level_instrument SET id_musician = ?, id_instrument = ?, level = ? WHERE id_musician = ? AND id_instrument = ?;"
            );
            statement.setInt(1, idMusician);
            statement.setInt(2, idInstrument);
            statement.setInt(3, level);
            statement.setInt(1, idMusician);
            statement.setInt(2, previousInstrument);

            if (statement.executeUpdate() != 1) {
                throw new SQLException("failed to update data");
            }
            return new LevelInstrument(idMusician, idInstrument, level);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<LevelInstrument> getLevelInstrumentByIdMusician(int idMusician) {
        try {
            Connection connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            PreparedStatement statement = connection.prepareStatement(

                    "SELECT * FROM level_instrument where id_musician = ?;"
            );

            statement.setInt(1, idMusician);
            ResultSet resultSet = statement.executeQuery();

            List<LevelInstrument> levels = new ArrayList<>();

            while (resultSet.next()) {
                int idInstrument = resultSet.getInt("id_instrument");
                int level = resultSet.getInt("level");
                levels.add(new LevelInstrument(idMusician, idInstrument, level));
            }
            return levels;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
