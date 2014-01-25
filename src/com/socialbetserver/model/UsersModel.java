package com.socialbetserver.model;

/**
 * com.socialbetserver.model in SocialBetServer
 * Made by Floran Pagliai <floran.pagliai@gmail.com>
 * Started on 03/12/2013 at 22:45
 */

public class UsersModel {
    private int id_;
    private String login_;
    private String password_;
    private int rank_;

    public UsersModel() {
        this.id_ = -1;
        this.login_ = "";
        this.password_ = "";
    }

    public UsersModel(String login, String password) {
        this.id_ = -1;
        this.login_ = login;
        this.password_ = password;
    }

    public UsersModel(int id, String login, String password, int rank) {
        this.id_ = id;
        this.login_ = login;
        this.password_ = password;
        this.rank_ = rank;
    }

    public int getId() {
        return this.id_;
    }

    public void setId(int id) {
        this.id_ = id;
    }

    public String getLogin() {
        return this.login_;
    }

    public void setLogin(String login) {
        this.login_ = login;
    }

    public String getPassword() {
        return this.password_;
    }

    public void setPassword(String password) {
        this.password_ = password;
    }

    public int getRank_() {
        return rank_;
    }

    public void setRank(int rank) {
        this.rank_ = rank;
    }

    @Override
    public String toString() {
        String str = "|" + this.getId() + ";" + this.getLogin() + ";" + this.getRank_();
        return str;
    }

    public boolean isNull() {
        if (login_.equalsIgnoreCase("") && password_.equalsIgnoreCase(""))
            return true;
        else
            return false;
    }
}
