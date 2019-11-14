package com.wildcodeschool.whereismyband.repository;

import com.wildcodeschool.whereismyband.entity.Search;
import java.sql.*;

public class SearchRepository {

    private final static String DB_URL = "jdbc:mysql://localhost:3306/where_is_my_band?serverTimezone=GMT";
    private final static String DB_USER = "h4rryp0tt3r";
    private final static String DB_PASSWORD = "Horcrux4life!";

    public Search save(String postcode, String availability, int searchType, Long idInstrument, int level, Long idStyle, Long idMusician, Long idInstrument2, int level2) {
        try {
            Connection connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO search (postcode, availability, search_type, id_instrument, level, id_style, id_musician, id_instrument2, level2) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);",
                    Statement.RETURN_GENERATED_KEYS
            );
            statement.setString(1, postcode);
            statement.setString(2, availability);
            statement.setInt(3, searchType);
            statement.setLong(4, idInstrument);
            statement.setInt(5, level);
            statement.setLong(6, idStyle);
            statement.setLong(7, idMusician);
            statement.setLong(8, idInstrument);
            statement.setInt(9, level2);

            if (statement.executeUpdate() != 1) {
                throw new SQLException("failed to insert data");
            }

            ResultSet generatedKeys = statement.getGeneratedKeys();

            if (generatedKeys.next()) {
                Long id = generatedKeys.getLong(1);
                return new Search(id, postcode, availability, searchType, idInstrument, level, idStyle, idMusician, idInstrument2, level2);
            } else {
                throw new SQLException("failed to get inserted id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Search update(Long idSearch, String postcode, String availability, int searchType, Long idInstrument, int level, Long idStyle, Long idMusician, Long idInstrument2, int level2) {
        try {
            Connection connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE search SET postcode = ?, availability = ?, search_type = ?, id_instrument = ?, level = ?, id_style = ?, id_instrument2 = ?, level2 = ?" +
                            " WHERE id_search = ?",
                    Statement.RETURN_GENERATED_KEYS
            );
            statement.setString(1, postcode);
            statement.setString(2, availability);
            statement.setInt(3, searchType);
            statement.setLong(4, idInstrument);
            statement.setInt(5, level);
            statement.setLong(6, idStyle);
            statement.setLong(7, idInstrument2);
            statement.setInt(8, level2);
            statement.setLong(9, idSearch);

            if (statement.executeUpdate() != 1) {
                throw new SQLException("failed to update data");
            }
            return new Search(idSearch, postcode, availability, searchType, idInstrument, level, idStyle, idMusician, idInstrument2, level2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Search getSearchByIdMusician(Long idMusician) {
            try {
                Connection connection = DriverManager.getConnection(
                        DB_URL, DB_USER, DB_PASSWORD
                );
                PreparedStatement statement = connection.prepareStatement(

                        "SELECT * FROM search where id_musician = ?;"
                );

                statement.setLong(1, idMusician);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    Long idSearch = resultSet.getLong("id_search");
                    String postcode = resultSet.getString("postcode");
                    String availability = resultSet.getString("availability");
                    int searchType = resultSet.getInt("search_type");
                    Long idInstrument = resultSet.getLong("id_instrument");
                    int level = resultSet.getInt("level");
                    Long idStyle = resultSet.getLong("id_style");
                    Long idInstrument2 = resultSet.getLong("id_instrument2");
                    int level2 = resultSet.getInt("level2");
                    return new Search(idSearch, postcode, availability, searchType, idInstrument, level, idStyle, idMusician, idInstrument2, level2);
                }
            } catch (
                    SQLException e) {
                e.printStackTrace();
            }
            return null;
    }
}