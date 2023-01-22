package com.tweteroo.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    private TweetsRepository tweetsRepository;

    @Autowired 
    private UserRepository userRepository;

    public String save(TweetsDTO dto) {
        Users user = userRepository.findByUsername(dto.username());

        if(user != null) {
            tweetsRepository.save(new Tweets(dto.username(), user.getAvatar(), dto.tweet()));
            return "OK";
        } else {
            return "NOT_FOUND";
        }
    }

    public List<Tweets> findAll(Pageable pageable) {
        return tweetsRepository.findAll(pageable).getContent();
    }

    public List<Tweets> getTweetsByUsername(String username) {
        return tweetsRepository.findAllByUsername(username);
    }
}
