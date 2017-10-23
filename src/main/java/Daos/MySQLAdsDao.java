package Daos;

import java.sql.*;

import com.mysql.cj.jdbc.Driver;
import Interfaces.Ads;
import Models.Ad;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {

    private Connection connection;

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    Config.getUrl(),
                    Config.getUsername(),
                    Config.getPassword()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Override
    public List<Ad> all() {
        try {
            String sql = "Select * FROM ads";
            List<Ad> ads = new ArrayList<>();

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                ads.add(new Ad(
                        rs.getLong("id"),
                        rs.getLong("user_id"),
                        rs.getString("title"),
                        rs.getString("description")
                ));
            }
            return ads;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Long insert(Ad ad) {
        try {
            long userId = ad.getUserId();
            String title = ad.getTitle();
            String description = ad.getDescription();

            String query = String.format("INSERT INTO ads(user_id, title, description) VALUES ('%s', '%s', '%s')",
                    userId,
                    title,
                    description
            );

            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = stmt.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getLong(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }
}

