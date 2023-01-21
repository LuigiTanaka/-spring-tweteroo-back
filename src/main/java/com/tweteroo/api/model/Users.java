package com.tweteroo.api.model;

import java.util.List;

import com.tweteroo.api.dto.UserDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor

public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 40, nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String avatar;

    //@OneToMany(mappedBy = "user")
    //private List<Tweets> tweets;
    
    public Users(UserDTO data) {
        this.username = data.username();
        this.avatar = data.avatar();
    }

}
