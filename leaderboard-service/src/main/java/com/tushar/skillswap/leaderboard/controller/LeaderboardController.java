package com.tushar.skillswap.leaderboard.controller;

import com.tushar.skillswap.leaderboard.entity.SkillScoreEntity;
import com.tushar.skillswap.leaderboard.repository.SkillScoreRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/leaderboard")
public class LeaderboardController {

    private final SkillScoreRepository skillScoreRepository;

    public LeaderboardController(SkillScoreRepository skillScoreRepository) {
        this.skillScoreRepository = skillScoreRepository;
    }

    @GetMapping("/skill/{skillId}")
    public List<SkillScoreEntity> getLeaderboard(
            @PathVariable("skillId") Long skillId,
            Pageable pageable
    ) {
        return skillScoreRepository.findLeaderboardBySkill(skillId, pageable);
    }
}