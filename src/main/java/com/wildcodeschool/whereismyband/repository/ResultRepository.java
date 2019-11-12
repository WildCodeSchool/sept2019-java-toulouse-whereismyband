package com.wildcodeschool.whereismyband.repository;

import com.wildcodeschool.whereismyband.entity.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ResultRepository {

    private final static String DB_URL = "jdbc:mysql://localhost:3306/where_is_my_band?serverTimezone=GMT";
    private final static String DB_USER = "h4rryp0tt3r";
    private final static String DB_PASSWORD = "Horcrux4life!";

    public List<Result> getResult(int searchType, String postCode, /*long idStyle,*/ long idInstrument, int levelInstrument, String availability) {

        try {
            Connection connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM band " +
                            "JOIN need ON band.id_band = need.id_band " +
                            "JOIN instrument ON instrument.id_instrument = need.id_instrument " +
                            "WHERE search_type = ? AND postcode = ? AND need.id_instrument = ? " +
                            "AND level = ?;"
            );
            statement.setInt(1, searchType);
            statement.setString(2, postCode);
            //statement.setLong(3, idStyle);
            statement.setLong(3, idInstrument);
            statement.setInt(4, levelInstrument);

            ResultSet resultSet = statement.executeQuery();
            List<Result> results = new ArrayList<>();

            while (resultSet.next()) {
                searchType = resultSet.getInt("search_type");
                postCode = resultSet.getString("postcode");
                //idStyle = resultSet.getLong("style");
                idInstrument = resultSet.getLong("id_instrument");
                levelInstrument = resultSet.getInt("level");
                String availabilityBand = resultSet.getString("availability");
                //long searchId = resultSet.getLong("id_search");
                String instrumentName = resultSet.getString("instrument.name");
                long idBand = resultSet.getLong("id_band");
                String bandName = resultSet.getString("band.name");
                String bio = resultSet.getString("bio");
                //TODO : tester les dispos.
                if (checkAvailability(availability, availabilityBand)) {
                    results.add(new Result(searchType, postCode,
                            idInstrument, instrumentName, levelInstrument, idBand, bandName, availabilityBand, bio));
                }
            }
            return results;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean checkAvailability(String musicianAvailability, String bandAvailability) {
        for (int i = 0; i < 7; i++) {
            if (musicianAvailability.charAt(i) == bandAvailability.charAt(i) && musicianAvailability.charAt(i) == '1') {
                return true;
            }
        }
        return false;
    }
}
