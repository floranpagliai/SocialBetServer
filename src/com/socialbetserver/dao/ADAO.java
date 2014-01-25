package com.socialbetserver.dao;

import com.socialbetserver.ConnexionPostgreSQL;

import java.sql.Connection;

/**
 * com.socialbetserver.dao in SocialBetServer
 * Made by Floran Pagliai <floran.pagliai@gmail.com>
 * Started on 03/12/2013 at 22:58
 */

public abstract class ADAO<T> {
    public Connection connect = ConnexionPostgreSQL.getInstance();

    /**
     * Permet de créer une entrée dans la base de données
     * par rapport à un objet
     * @param obj
     */
    public abstract T create(T obj);

    /**
     * Permet de récupérer un objet via son ID
     * @param id
     * @return
     */
    public abstract T find(int id);

    /**
     * Permet de récupérer un objet via u
     * @param key
     * @param keyEntry
     * @return
     */
    public abstract T findByKey(String key, String keyEntry);

    /**
     * Permet de mettre à jour les données d'une entrée dans la base
     * @param obj
     */
    public abstract T update(T obj);

    /**
     * Permet la suppression d'une entrée de la base
     * @param obj
     */
    public abstract void delete(T obj);

    public abstract int countRow();

    public abstract int nbRow();
}
