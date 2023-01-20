package com.tweteroo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.TweetsDTO;
import com.tweteroo.api.model.Tweets;
import com.tweteroo.api.repository.TweetsRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tweets")
public class TweetController {
    
    @Autowired
    private TweetsRepository repository;

    @PostMapping
    public String create(@RequestBody @Valid TweetsDTO req) {
        repository.save(new Tweets(req));
        return "OK";
    }

}
