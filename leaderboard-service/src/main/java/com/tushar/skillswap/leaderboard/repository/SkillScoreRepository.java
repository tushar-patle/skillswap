package com.tushar.skillswap.leaderboard.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tushar.skillswap.leaderboard.entity.SkillScoreEntity;

public interface SkillScoreRepository extends JpaRepository<SkillScoreEntity, Long> {

	Optional<SkillScoreEntity> findByUserIdAndSkillId(Long userId, Long skillId);
	
	@Query("""
			SELECT s
			FROM SkillScoreEntity s
			WHERE s.skillId = :skillId
			ORDER BY s.points DESC
			""")
	List<SkillScoreEntity> findTopBySkill(@Param("skillId") Long skillId);
}