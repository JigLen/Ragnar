package com.vikings.ragnar.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Ciaran Sweeney on 21/02/2017.
 */

@NamedQueries({
        @NamedQuery(name = "getUser", query = "from UserEntity user where user.username = :username and user.password= :password")
})

@Entity
@Table(name="users")
public class UserEntity  implements Serializable {
    @Column(name="Username")        private String username;
    @Id @Column(name="User_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer userId;
    @Column(name="Password")        private String password;
    @Column(name="Access_Level")    private Integer accessLevel;
    @Column(name="Description")     private String description;


    public UserEntity(String username, String password, Integer accessLevel, String description){
        this.username = username;
        this.password = password;
        this.accessLevel = accessLevel;
        this.description = description;
    }

    public String Login(String username, String password)
    {
        return "username:" + username + " " + "Password:" + password;
    }

    public UserEntity() {
    }

    public Integer getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public Integer getAccessLevel() {
        return accessLevel;
    }

    public String getDescription() {
        return description;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccessLevel(Integer accessLevel) {
        this.accessLevel = accessLevel;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "username='" + username + '\'' +
                ", userId=" + userId +
                ", password='" + password + '\'' +
                ", accessLevel=" + accessLevel +
                ", description='" + description + '\'' +
                '}';
    }
}