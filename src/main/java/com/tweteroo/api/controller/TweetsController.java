package com.tweteroo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.TweetsDTO;
import com.tweteroo.api.model.Tweets;
import com.tweteroo.api.service.TweetsService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/tweets")
public class TweetsController {
    
    @Autowired
    private TweetsService service;;


    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public String create(@RequestBody @Valid TweetsDTO req) {
        String res = service.save(req);
        return res;
    }

    @GetMapping
    public ResponseEntity<List<Tweets>> getTweets(@PageableDefault(page = 0, size = 5) Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @GetMapping("/{username}")
    public ResponseEntity<List<Tweets>> getTweetsByUsername(@PathVariable String username) {
        return ResponseEntity.ok(service.getTweetsByUsername(username));
    }

}
