package com.vikings.ragnar.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Ciaran Sweeney on 21/02/2017.
 */
@Entity
@Table(name="users")
public class UserEntity  implements Serializable {
    @Id
    @Column(name="User_id")
    private Integer userId;

    @Column(name="Password")
    private String password;

    @Column(name="Access_Level")
    private Integer accessLevel;

    public UserEntity(Integer u, String psw, Integer a ){
        userId=u;
        password=psw;
        accessLevel=a;
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
}
