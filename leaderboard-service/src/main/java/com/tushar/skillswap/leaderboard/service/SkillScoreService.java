package com.tushar.skillswap.leaderboard.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.tushar.skillswap.leaderboard.entity.SkillScoreEntity;
import com.tushar.skillswap.leaderboard.repository.SkillScoreRepository;

import jakarta.transaction.Transactional;

@Service
public class SkillScoreService {

	private final SkillScoreRepository skillScoreRepository;

	public SkillScoreService(SkillScoreRepository skillScoreRepository) {
		this.skillScoreRepository = skillScoreRepository;
	}

	@Transactional
	public void addPoints(Long userId, Long skillId, int points) {
		SkillScoreEntity skillScoreEntity = skillScoreRepository.findByUserIdAndSkillId(userId, skillId)
				.orElseGet(() -> {
					SkillScoreEntity s = new SkillScoreEntity();
					s.setUserId(userId);
					s.setSkillId(skillId);
					s.setPoints(0);
					return s;
				});

		skillScoreEntity.setPoints(skillScoreEntity.getPoints() + points);
		skillScoreEntity.setLastUpdated(LocalDateTime.now());
	}
}
