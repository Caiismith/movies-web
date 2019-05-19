package com.cai.smith.moviesweb.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Comment {

    @JsonProperty("user")
    private String user;

    @JsonProperty("message")
    private String message;

    @JsonProperty("dateCreated")
    private String dateCreated;

    @JsonProperty("like")
    private int like;

    private String dateHumanReadable;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public String getDateHumanReadable() {
        return dateHumanReadable;
    }

    public void setDateHumanReadable(String dateHumanReadable) {
        this.dateHumanReadable = dateHumanReadable;
    }
}
