package com.wildcodeschool.whereismyband.repository;

import com.wildcodeschool.whereismyband.entity.NeedInstrument;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NeedInstrumentRepository {

    private final static String DB_URL = "jdbc:mysql://localhost:3306/where_is_my_band?serverTimezone=GMT";
    private final static String DB_USER = "h4rryp0tt3r";
    private final static String DB_PASSWORD = "Horcrux4life!";

    public List<NeedInstrument> getNeedsByIdBands(Long idBand) {
        try {
            Connection connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM need JOIN instrument i on need.id_instrument = i.id_instrument WHERE need.id_band = ? AND encours = 1;"
            );
            statement.setLong(1, idBand);
            ResultSet resultSet = statement.executeQuery();
            List<NeedInstrument> needs = new ArrayList<>();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                Long idNeed = resultSet.getLong("id_need");
                Long idInstrument = resultSet.getLong("id_instrument");
                String availability = resultSet.getString("availability");
                int level = resultSet.getInt("level");
                needs.add(new NeedInstrument(idNeed, idInstrument, idBand, availability, level, name));
            }
            return needs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
