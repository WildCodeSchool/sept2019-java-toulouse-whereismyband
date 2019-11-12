package com.wildcodeschool.whereismyband.repository;

import com.wildcodeschool.whereismyband.entity.Instrument;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InstrumentRepository {

    private final static String DB_URL = "jdbc:mysql://localhost:3306/where_is_my_band?serverTimezone=GMT";
    private final static String DB_USER = "h4rryp0tt3r";
    private final static String DB_PASSWORD = "Horcrux4life!";

    public List<Instrument> findAllInstrument() {
        try {
            Connection connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM instrument;"
            );
            ResultSet resultSet = statement.executeQuery();

            List<Instrument> instruments = new ArrayList<>();

            while (resultSet.next()) {
                Long id_instrument = resultSet.getLong("id_instrument");
                String name = resultSet.getString("name");
                if (name.length() > 35) {
                    name = name.substring(0, 35) + "...";
                }
                instruments.add(new Instrument(id_instrument, name));
            }
            return instruments;
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Instrument getInstrumentById(long idInstrument) {
        try {
            Connection connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM instrument WHERE id_instrument = ?;"
            );

            statement.setLong(1, idInstrument);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                return new Instrument(idInstrument, name);
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}