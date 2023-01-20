package com.tweteroo.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.api.dto.TweetsDTO;
import com.tweteroo.api.model.Tweets;
import com.tweteroo.api.repository.TweetsRepository;

@Service
public class TweetsService {
    
    @Autowired 
    private TweetsRepository repository;

    public Tweets save(TweetsDTO dto) {
        return repository.save(new Tweets(dto));
    }
}
