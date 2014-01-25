package com.socialbetserver.dao;

import com.socialbetserver.model.UsersModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * com.socialbetserver.dao in SocialBetServer
 * Made by Floran Pagliai <floran.pagliai@gmail.com>
 * Started on 03/12/2013 at 23:03
 */

public class UsersDAO extends ADAO<UsersModel> {
    @Override
    public UsersModel create(UsersModel obj) {
        try {
            PreparedStatement prepare = this.connect
                    .prepareStatement(
                            "INSERT INTO users (login, password) VALUES(?, ?)"
                    );
            prepare.setString(1, obj.getLogin());
            prepare.setString(2, obj.getPassword());
            prepare.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public UsersModel find(int id) {
        UsersModel obj = new UsersModel();
        try {
            ResultSet result = this.connect
                    .createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE
                    ).executeQuery(
                            "SELECT * FROM users WHERE id = '" + id + "'"
                    );
            if (result.first())
                obj = new UsersModel(
                        id,
                        result.getString("name"),
                        result.getString("encrypted_password"),
                        result.getInt("rank")
                );

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public UsersModel findByKey(String key, String text) {
        UsersModel obj = new UsersModel();
        try {
            ResultSet result = this.connect
                    .createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE
                    ).executeQuery(
                            "SELECT * FROM users WHERE " + key + " = '" + text + "'"
                    );
            if (result.first())
                obj = new UsersModel(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getString("encrypted_password"),
                        result.getInt("rank")
                );

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public UsersModel update(UsersModel obj) {
        try {
            PreparedStatement prepare = this.connect
                    .prepareStatement(
                            "UPDATE users SET login=? AND password=? WHERE id=?"
                    );
            prepare.setString(1, obj.getLogin());
            prepare.setString(2, obj.getPassword());
            prepare.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public void delete(UsersModel obj) {
        try {
            PreparedStatement prepare = this.connect
                    .prepareStatement(
                            "DELETE FROM users WHERE id=?"
                    );
            prepare.setInt(1, obj.getId());
            prepare.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int countRow() {
        try {
            ResultSet result = this.connect
                    .createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE
                    ).executeQuery(
                            "SELECT * FROM users"
                    );
            result.last();
            return result.getInt("id");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int nbRow() {
        try {
            ResultSet result = this.connect
                    .createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE
                    ).executeQuery(
                            "SELECT * FROM users"
                    );
            result.last();
            return result.getRow();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
