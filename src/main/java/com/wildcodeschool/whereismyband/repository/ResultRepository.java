package com.wildcodeschool.whereismyband.repository;

import com.wildcodeschool.whereismyband.entity.Result;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ResultRepository {

    private final static String DB_URL = "jdbc:mysql://localhost:3306/where_is_my_band?serverTimezone=GMT";
    private final static String DB_USER = "h4rryp0tt3r";
    private final static String DB_PASSWORD = "Horcrux4life!";

    public List<Result> getResult(Long idSearch, int searchType, String postCode, long idStyle, long idInstrument,
                                  int levelInstrument, String availability, long idInstrument2, int levelInstrument2) {

        String request = "SELECT * FROM band JOIN need ON band.id_band = need.id_band " +
                "JOIN instrument ON instrument.id_instrument = need.id_instrument JOIN band_style ON band.id_band = band_style.id_band " +
                "JOIN style ON style.id_style = band_style.id_style WHERE";
        if (searchType == 1 || searchType == 2) {
            request += " band.search_type = " + String.valueOf(searchType) + " AND";
        }
        if (idStyle > 1) {
            request += " band_style.id_style = " + String.valueOf(idStyle) + " AND";
        }
        request += " (need.id_instrument = " + String.valueOf(idInstrument) + " AND need.level = " + String.valueOf(levelInstrument) + ")";
        if (idInstrument2 > 0) {
            request += " OR (need.id_instrument = " + String.valueOf(idInstrument) + " AND need.level = " + String.valueOf(levelInstrument) + ")";
        }
        request += ";";

        try {
            Connection connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );

            ResultSet resultSet;
            PreparedStatement statement;
            statement = connection.prepareStatement(request);

            resultSet = statement.executeQuery();
            List<Result> results = new ArrayList<>();

            while (resultSet.next()) {
                searchType = resultSet.getInt("search_type");
                postCode = resultSet.getString("postcode");
                idStyle = resultSet.getLong("id_style");
                idInstrument = resultSet.getLong("id_instrument");
                levelInstrument = resultSet.getInt("level");
                String availabilityBand = resultSet.getString("availability");
                String instrumentName = resultSet.getString("instrument.name");
                long idBand = resultSet.getLong("id_band");
                String bandName = resultSet.getString("band.name");
                String bio = resultSet.getString("bio");
                Long idMusician = resultSet.getLong("id_musician");
                String style = resultSet.getString("style");


                if (checkAvailability(availability, availabilityBand)) {
                    availabilityBand = weekAvailability(availabilityBand);
                    results.add(new Result(idMusician, idSearch, searchType, postCode, idInstrument,
                            instrumentName, levelInstrument, idBand, bandName, availability, bio, idStyle,
                            style));
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

    private String weekAvailability(String availabilityBand) {
        StringBuilder s = new StringBuilder();
        if (availabilityBand.charAt(0) == '1') {
            s.append("Lun ");
        }
        if (availabilityBand.charAt(1) == '1') {
            s.append("Mar ");
        }
        if (availabilityBand.charAt(2) == '1') {
            s.append("Mer ");
        }
        if (availabilityBand.charAt(3) == '1') {
            s.append("Jeu ");
        }
        if (availabilityBand.charAt(4) == '1') {
            s.append("Ven ");
        }
        if (availabilityBand.charAt(5) == '1') {
            s.append("Sam ");
        }
        if (availabilityBand.charAt(6) == '1') {
            s.append("Dim ");
        }
        return s.toString();
    }
}
