package com.lh;

/**
 * Created by lh on 2018/4/27.
 */
public class MUser {

     private String id;
     private String username;
     private String idcard;
     private String type;
     private String no;

    @Override
    public String toString() {
        return "MUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", idcard='" + idcard + '\'' +
                ", type='" + type + '\'' +
                ", no='" + no + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }
}
