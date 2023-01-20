package com.tweteroo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.api.model.Tweets;

public interface TweetsRepository extends JpaRepository<Tweets, Long> {
    
}
