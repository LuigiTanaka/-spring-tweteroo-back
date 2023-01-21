package com.tweteroo.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tweteroo.api.dto.TweetsDTO;
import com.tweteroo.api.model.Tweets;
import com.tweteroo.api.model.Users;
import com.tweteroo.api.repository.TweetsRepository;
import com.tweteroo.api.repository.UserRepository;

@Service
public class TweetsService {
    
    @Autowired 
    private TweetsRepository repository;

    public Tweets save(TweetsDTO dto) {
        return repository.save(new Tweets(dto));
    }

    public Page<Tweets> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Tweets> getTweetsByUsername(String username) {
        return repository.findAllByUsername(username);
    }
}
