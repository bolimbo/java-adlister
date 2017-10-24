package com.codeup.adlister.dao;

import Daos.Config;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MySQLUsersDao implements Users {
    Connection connection = null;

    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    public List<User> all (){
        String sql = "select * from users";
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                rs.getLong("id");
                rs.getString("username");
                rs.getString("email");
                rs.getString("password");

            }
        } catch (SQLException e) {
throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public User findByUsername(String username) {
        String query = "Select * from users where username=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);


            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                return new User(
                        rs.getLong("id"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("password")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Long insert(User user) {
        try {
            String query = "insert into users(username,password,email) VALUES (?,?,?)";

            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getEmail());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new user.", e);
        }


    }
}
