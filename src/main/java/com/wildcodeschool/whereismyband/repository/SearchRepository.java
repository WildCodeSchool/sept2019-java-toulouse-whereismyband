package com.wildcodeschool.whereismyband.repository;

import com.wildcodeschool.whereismyband.entity.Search;
import java.sql.*;

public class SearchRepository {

    private final static String DB_URL = "jdbc:mysql://localhost:3306/where_is_my_band?serverTimezone=GMT";
    private final static String DB_USER = "h4rryp0tt3r";
    private final static String DB_PASSWORD = "Horcrux4life!";

    public Search save(String postcode, String availability, int searchType, Long idInstrument, int level, Long idStyle, Long idMusician) {
        try {
            Connection connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO search (postcode, availability, search_type, id_instrument, level, id_style, id_musician) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?);",
                    Statement.RETURN_GENERATED_KEYS
            );
            statement.setString(1, postcode);
            statement.setString(2, availability);
            statement.setInt(3, searchType);
            statement.setLong(4, idInstrument);
            statement.setInt(5, level);
            statement.setLong(6, idStyle);
            statement.setLong(7, idMusician);

            if (statement.executeUpdate() != 1) {
                throw new SQLException("failed to insert data");
            }

            ResultSet generatedKeys = statement.getGeneratedKeys();

            if (generatedKeys.next()) {
                Long id = generatedKeys.getLong(1);
                return new Search(id, postcode, availability, searchType, idInstrument, level, idStyle, idMusician);
            } else {
                throw new SQLException("failed to get inserted id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
