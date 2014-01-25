package com.socialbetserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * com.socialbetserver in SocialBetServer
 * Made by Floran Pagliai <floran.pagliai@gmail.com>
 * Started on 03/12/2013 at 22:34
 */

public class ConnexionPostgreSQL {
    private String url_ = "jdbc:postgresql://ec2-54-225-89-245.compute-1.amazonaws.com:5432/d43tpj19k3rofc";
    private String user_ = "qrbzsfrazeutsp";
    private String passwd_ = "4SRzbBqhbawl3QE06mZgvuK4a_";
    private static Connection connect_;

    private ConnexionPostgreSQL(){
        try {
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            DriverManager.setLoginTimeout(5);
            url_ += "?user=" + user_ + "&password=" + passwd_ + "&ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
            connect_ = DriverManager.getConnection(url_);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getInstance(){
        if(connect_ == null){
            new ConnexionPostgreSQL();
        }
        return connect_;
    }
}
