package com.socialbetserver.model;

/**
 * com.socialbetserver.model in SocialBetServer
 * Made by Floran Pagliai <floran.pagliai@gmail.com>
 * Started on 27/01/2014 at 02:59
 */

public class PronosticsModel {
    private int id_;
    private boolean validate_;
    private boolean confirm_;

    public PronosticsModel(int id_, boolean validate_, boolean confirm_) {
        this.id_ = id_;
        this.validate_ = validate_;
        this.confirm_ = confirm_;
    }
}
