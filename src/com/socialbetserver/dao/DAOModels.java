package com.socialbetserver.dao;

import com.socialbetserver.model.*;

/**
 * com.socialbetserver.dao in SocialBetServer
 * Made by Floran Pagliai <floran.pagliai@gmail.com>
 * Started on 05/12/2013 at 14:26
 */

public class DAOModels {
    private ADAO<UsersModel> usersDAO = new UsersDAO();
    private ADAO<PronosticsModel> pronosticsDAO = new PronosticsDAO();

    public ADAO<UsersModel> getUsersDAO() {
        return usersDAO;
    }

    public ADAO<PronosticsModel> getPronosticsDAO() {
        return pronosticsDAO;
    }
}
