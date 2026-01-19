package com.tushar.skillswap.challenge.entity;

import java.time.LocalDateTime;

import com.tushar.skillswap.common.entity.BaseEntity;
import com.tushar.skillswap.common.enums.ChallengeStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "challenges")
@Getter
@Setter
public class ChallengeEntity extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "challenger_id", nullable = false)
	private Long challengerId;
	
	@Column(name = "opponent_id", nullable = false)
	private Long opponentId;
	
	@Column(name = "skill_id", nullable = false)
	private Long skillId;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private ChallengeStatus status;
	
	@Column(name = "winner_id")
	private Long winnerId;
	
	@Column(name = "accepted_at")
    private LocalDateTime acceptedAt;

    @Column(name = "completed_at")
    private LocalDateTime completedAt;
	
	
}
