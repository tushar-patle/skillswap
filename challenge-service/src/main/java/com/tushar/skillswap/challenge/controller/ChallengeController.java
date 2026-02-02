package com.tushar.skillswap.challenge.controller;

import com.tushar.skillswap.challenge.entity.ChallengeEntity;
import com.tushar.skillswap.challenge.repository.ChallengeRepository;
import com.tushar.skillswap.common.enums.ChallengeStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/challenges")
public class ChallengeController {

    private final ChallengeRepository challengeRepository;

    public ChallengeController(ChallengeRepository challengeRepository) {
        this.challengeRepository = challengeRepository;
    }

    @GetMapping("/pending/{userId}")
    public List<ChallengeEntity> getPending(@PathVariable("userId") Long userId) {
        return challengeRepository.findPendingChallengesForUser(userId, ChallengeStatus.CREATED);
    }
}
