package com.vikings.ragnar.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Ciaa on 21/02/2017.
 */
@Entity
@Table(name="users")
public class UserEntity  implements Serializable {
    @Id
    @Column(name="User_id")
    private Integer userId;

    @Column(name="Access_Level")
    private Integer accessLevel;


}
