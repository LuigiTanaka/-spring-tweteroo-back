package com.tweteroo.api.model;

import com.tweteroo.api.dto.TweetsDTO;

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

    @Column(length = 400, nullable = false)
    private String tweet;

    public Tweets(TweetsDTO data) {
        this.username = data.username(); 
        this.tweet = data.tweet();
    }

}
