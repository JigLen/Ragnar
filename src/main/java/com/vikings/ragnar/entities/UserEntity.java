package com.vikings.ragnar.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Ciaran Sweeney on 21/02/2017.
 */
@NamedQueries({
        @NamedQuery(name = "getUser", query = "from UserEntity user where user.userId = :id and user.password= :password")
})

@Entity
@Table(name="users")
public class UserEntity  implements Serializable {
    @Id @Column(name="User_id")     private Integer userId;
    @Column(name="Password")        private String password;
    @Column(name="Access_Level")    private Integer accessLevel;
    @Column(name="Description")     private String description;

    public UserEntity(Integer u, String psw, Integer a, String description){
        userId=u;
        password=psw;
        accessLevel=a;
        this.description = description;
    }

    public String Login(Integer userId, String password)
    {
        return "Id:" + userId + " " + "Password:" + password;
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

    @Override
    public String toString() {
        return "UserEntity{" +
                "userId=" + userId +
                ", password='" + password + '\'' +
                ", accessLevel=" + accessLevel +
                ", description='" + description + '\'' +
                '}';
    }
}