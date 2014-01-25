package com.socialbetserver;

import com.socialbetserver.dao.DAOModels;
import com.socialbetserver.controler.Jclient;

import java.net.ServerSocket;
import java.util.Vector;

/**
 * com.socialbetserver in SocialBetServer
 * Made by Floran Pagliai <floran.pagliai@gmail.com>
 * Started on 03/12/2013 at 23:01
 */

public class Server {
    public Vector usersLogged = new Vector();
    private Integer usersConnected = 0;

    public static void main(String args[]) {
        String retval = "";
        Server serveur = new Server();
        DAOModels daoModels = new DAOModels();
        try {
            Integer port = 4242;
            ServerSocket ss = new ServerSocket(port.intValue());
            while (true) {
                new Jclient(ss.accept(), daoModels, serveur);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addUsersConnected() {
        this.usersConnected++;
    }

    public void delUsersConnected() {
        this.usersConnected--;
    }

    public String getUsersConnected() {
        return this.usersConnected.toString();
    }

    public void addUsersLogged(int id) {
         this.usersLogged.addElement(id);
    }

    public void delUsersLogged(int id) {
        for (int i = 0; i <= this.usersLogged.size() ; i++) {
            if (id != -1 && this.usersLogged.elementAt(i).equals(id))
                this.usersLogged.removeElementAt(i);
        }
    }

    public boolean getUsersLogged(int id) {
        return  this.usersLogged.contains(id);
    }
}
