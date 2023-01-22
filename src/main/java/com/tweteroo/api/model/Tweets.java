package com.tweteroo.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Tweets {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 40, nullable = false)
    private String username;

    @Column(nullable = false)
    private String avatar;

    @Column(length = 400, nullable = false)
    private String tweet;

    public Tweets(String username, String avatar, String tweet) {
        this.username = username; 
        this.avatar = avatar; 
        this.tweet = tweet;
    }

}
