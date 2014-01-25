package com.socialbetserver.controler;

import com.socialbetserver.Server;
import com.socialbetserver.dao.DAOModels;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * com.socialbetserver.view in SocialBetServer
 * Made by Floran Pagliai <floran.pagliai@gmail.com>
 * Started on 04/12/2013 at 20:06
 */

public class Jclient implements Runnable {
    private Thread t_;
    private Socket socket_;
    private PrintWriter out_;
    private BufferedReader in_;
    private DAOModels daoModels_;
    private int userId_ = -1;
    private Server server_;

    public Jclient(Socket s, DAOModels daoModels, Server server) {
        this.socket_ = s;
        this.daoModels_ = daoModels;
        this.server_ = server;
        try {
            out_ = new PrintWriter(socket_.getOutputStream());
            in_ = new BufferedReader(new InputStreamReader(socket_.getInputStream()));
            this.server_.addUsersConnected();
        } catch (IOException e) {
            e.printStackTrace();
        }
        t_ = new Thread(this);
        t_.start();
    }

    public void run() {
        String message = "";
        String tokens[];
        try {
            char charCur[] = new char[1];
            while (in_.read(charCur, 0, 1) != -1) {
                if (charCur[0] != '\u0000' && charCur[0] != '\n' && charCur[0] != '\r')
                    message += charCur[0];
                else if (!message.equalsIgnoreCase("")) {
                    tokens = message.split("[;]");
                    commands(tokens);
                    out_.flush();
                    System.out.println(message);
                    message = "";
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                this.server_.delUsersConnected();
                this.server_.delUsersLogged(this.userId_);
                this.userId_ = -1;
                socket_.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void commands(String tokenCmds[]) {
        if (tokenCmds[0].equalsIgnoreCase("getranked") && tokenCmds.length == 2)
            out_.println(getRanked(tokenCmds[1]));
        else
            out_.println("error");
    }

    private String getRanked(String nb) {
        String ret = "";
        int size;
        try {
            size = Integer.parseInt(nb);
        } catch (NumberFormatException e) {
            return "error";
        }
        for (Integer i = 1 ; i <= size ; i++) {
            ret += daoModels_.getUsersDAO().findByKey("rank", i.toString()).toString();
        }
        return ret;
    }
}