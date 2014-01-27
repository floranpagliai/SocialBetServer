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
    private int points_;
    private int real_points_;
    private String image_;

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


    public UsersModel(int id, String login, String password, int rank, int points, int real_points, String image) {
        this.id_ = id;
        this.login_ = login;
        this.password_ = password;
        this.rank_ = rank;
        this.points_ = points;
        this.real_points_ = real_points;
        this.image_ = image;

    }

    public int getId_() {
        return id_;
    }

    public void setId_(int id_) {
        this.id_ = id_;
    }

    public String getLogin_() {
        return login_;
    }

    public void setLogin_(String login_) {
        this.login_ = login_;
    }

    public String getPassword_() {
        return password_;
    }

    public void setPassword_(String password_) {
        this.password_ = password_;
    }

    public int getRank_() {
        return rank_;
    }

    public void setRank_(int rank_) {
        this.rank_ = rank_;
    }

    public int getPoints_() {
        return points_;
    }

    public void setPoints_(int points_) {
        this.points_ = points_;
    }

    public int getReal_points_() {
        return real_points_;
    }

    public void setReal_points_(int real_points_) {
        this.real_points_ = real_points_;
    }

    public String getImage_() {
        return image_;
    }

    public void setImage_(String image_) {
        this.image_ = image_;
    }

    @Override
    public String toString() {
        String str = "|" + this.getId_() + ";" + this.getLogin_() + ";" + this.getRank_()
                + ";" + this.getPoints_() + ";" + this.getReal_points_() + ";" + this.getImage_();
        return str;
    }

    public boolean isNull() {
        if (login_.equalsIgnoreCase("") && password_.equalsIgnoreCase(""))
            return true;
        else
            return false;
    }
}
