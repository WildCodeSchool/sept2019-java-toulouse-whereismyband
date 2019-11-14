package com.wildcodeschool.whereismyband.repository;

import com.wildcodeschool.whereismyband.entity.Style;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StyleRepository {
    private final static String DB_URL = "jdbc:mysql://localhost:3306/where_is_my_band?serverTimezone=GMT";
    private final static String DB_USER = "h4rryp0tt3r";
    private final static String DB_PASSWORD = "Horcrux4life!";

    public List<Style> findAllStyle() {
        try {
            Connection connection = DriverManager.getConnection(
                    DB_URL, DB_USER, DB_PASSWORD
            );
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM style;"
            );
            ResultSet resultSet = statement.executeQuery();

            List<Style> styles = new ArrayList<>();

            while (resultSet.next()) {
                Long idStyle = resultSet.getLong("id_style");
                String style = resultSet.getString("style");
                if (style.length() > 35) {
                    style = style.substring(0, 35) + "...";
                }
                styles.add(new Style(idStyle, style));
            }
            return styles;
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
