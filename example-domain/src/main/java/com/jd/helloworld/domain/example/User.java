package com.jd.helloworld.domain.example;

import java.io.Serializable;
import java.util.Date;

/**
 * User: hanxy
 * Date: 2010-8-20
 * Time: 15:03:58
 * @table example_user
 */
public class User implements Serializable {

    private int id;
    private String userAccount;
    private int userType;
    private Date created;
    private Date modified;

    public void setId(int id) {
        this.id = id;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public int getId() {
        return id;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public int getUserType() {
        return userType;
    }

    public Date getCreated() {
        return created;
    }

    public Date getModified() {
        return modified;
    }
}
