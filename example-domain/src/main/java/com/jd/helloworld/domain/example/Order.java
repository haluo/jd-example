package com.jd.helloworld.domain.example;

import java.io.Serializable;
import java.util.Date;

/**
 * User: hanxy
 * Date: 2010-8-20
 * Time: 15:06:33
 * @table example_order
 */
public class Order implements Serializable {

    private int id;
    private int userId;
    private String orderName;
    private int status;
    private Date created;
    private Date modified;

    public void setId(int id) {
        this.id = id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public int getUserId() {
        return userId;
    }

    public String getOrderName() {
        return orderName;
    }

    public int getStatus() {
        return status;
    }

    public Date getCreated() {
        return created;
    }

    public Date getModified() {
        return modified;
    }
}
