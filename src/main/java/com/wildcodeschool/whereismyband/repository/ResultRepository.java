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

        postCode = postCode.substring(0, 2) + '%';
        try {
            Connection connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );

            ResultSet resultSet;
            PreparedStatement statement;
            if (searchType == 3) {
                statement = connection.prepareStatement(
                        "SELECT * FROM band " +
                                "JOIN need ON band.id_band = need.id_band " +
                                "JOIN instrument ON instrument.id_instrument = need.id_instrument " +
                                "WHERE band.postcode = ? AND need.id_instrument = ? " +
                                "AND need.level = ?;"
                );
                statement.setString(1, postCode);
                //statement.setLong(3, idStyle);
                statement.setLong(2, idInstrument);
                statement.setInt(3, levelInstrument);
            } else {
                statement = connection.prepareStatement(
                        "SELECT * FROM band " +
                                "JOIN need ON band.id_band = need.id_band " +
                                "JOIN instrument ON instrument.id_instrument = need.id_instrument " +
                                "WHERE band.search_type = ? AND band.postcode = ? AND need.id_instrument = ? " +
                                "AND need.level = ?;"
                );
                statement.setInt(1, searchType);
                statement.setString(2, postCode);
                //statement.setLong(3, idStyle);
                statement.setLong(3, idInstrument);
                statement.setInt(4, levelInstrument);
            }

            resultSet = statement.executeQuery();
            List<Result> results = new ArrayList<>();

            while (resultSet.next()) {
                searchType = resultSet.getInt("search_type");
                postCode = resultSet.getString("postcode");
                //idStyle = resultSet.getLong("style");
                idInstrument = resultSet.getLong("id_instrument");
                levelInstrument = resultSet.getInt("level");
                String availabilityBand = resultSet.getString("availability");
                String instrumentName = resultSet.getString("instrument.name");
                long idBand = resultSet.getLong("id_band");
                String bandName = resultSet.getString("band.name");
                String bio = resultSet.getString("bio");

                if (checkAvailability(availability, availabilityBand)) {
                    availabilityBand = weekAvailability(availabilityBand);
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

    public List<Result> getResultNotLog(String postcode) {
        postcode = postcode.substring(0, 2) + '%';
        try {
            Connection connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );

            ResultSet resultSet;
            PreparedStatement statement;

            statement = connection.prepareStatement(
                    "SELECT * FROM band " +
                            "JOIN need ON band.id_band = need.id_band " +
                            "JOIN instrument ON instrument.id_instrument = need.id_instrument " +
                            "WHERE band.postcode LIKE ?" +
                            "LIMIT 3;"
            );

            statement.setString(1, postcode);

            resultSet = statement.executeQuery();
            List<Result> results = new ArrayList<>();

            while (resultSet.next()) {
                int searchType = resultSet.getInt("search_type");
                postcode = resultSet.getString("postcode");
                Long idInstrument = resultSet.getLong("id_instrument");
                int levelInstrument = resultSet.getInt("level");
                String availabilityBand = resultSet.getString("availability");
                String instrumentName = resultSet.getString("instrument.name");
                long idBand = resultSet.getLong("id_band");
                String bandName = resultSet.getString("band.name");
                String bio = resultSet.getString("bio");
                availabilityBand = weekAvailability(availabilityBand);
                results.add(new Result(searchType, postcode,
                        idInstrument, instrumentName, levelInstrument, idBand, bandName, availabilityBand, bio));
            }
            return results;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}