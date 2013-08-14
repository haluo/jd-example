package com.jd.helloworld.domain.example;

import java.io.Serializable;
import java.util.Date;

/**
 * User: Administrator
 * Date: 2010-4-15
 * Time: 18:10:05
 * @table example
 */
public class Example implements Serializable{
  

    /**
     * 流水号
     */
    private int id;
    /**
     * 名称
     */
    private String name;
    /**
     * 类型
     */
    private int type;
    /**
     * 创建日期
     */
    private Date created;
    /**
     * 修改日期
     */
    private Date modified;

    public int getId() {
        return id;
    }

    /**
     * @column id
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }
}
