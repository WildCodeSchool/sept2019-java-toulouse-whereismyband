package com.wildcodeschool.whereismyband.repository;

import com.wildcodeschool.whereismyband.entity.BandAndStyle;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BandAndStyleRepository {

    private final static String DB_URL = "jdbc:mysql://localhost:3306/where_is_my_band?serverTimezone=GMT";
    private final static String DB_USER = "h4rryp0tt3r";
    private final static String DB_PASSWORD = "Horcrux4life!";

    public BandAndStyle getBandsByIdMusician(long idMusician) {
        try {
            Connection connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM band JOIN band_style ON band.id_band = band_style.id_band WHERE band.id_musician = ?;"
            );
            statement.setLong(1, idMusician);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Long idBand = resultSet.getLong("id_band");
                String name = resultSet.getString("name");
                String bio = resultSet.getString("bio");
                int searchType = resultSet.getInt("search_type");
                String postcode = resultSet.getString("postcode");
                long idStyle = resultSet.getLong("id_style");
                return new BandAndStyle(idBand, name, bio, searchType, postcode, idMusician, idStyle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
