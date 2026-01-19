package com.tushar.skillswap.leaderboard.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Entity
@Table(name = "skill_scores", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "skill_id"}))
@Data
public class SkillScoreEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "user_id", nullable = false)
	private Long userId;
	
	@Column(name = "skill_id", nullable = false)
	private Long skillId;
	
	@Column(nullable = false)
	private Integer points = 0;
	
	@Column(name = "last_updated", nullable = false)
	private LocalDateTime lastUpdated;
}
