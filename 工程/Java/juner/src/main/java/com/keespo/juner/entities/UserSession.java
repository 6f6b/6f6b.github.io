package com.keespo.juner.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserSession {
    @Id
    private Integer userId;
    private String session;

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
