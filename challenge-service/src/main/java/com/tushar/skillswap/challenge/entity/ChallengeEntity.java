package com.tushar.skillswap.challenge.entity;

import com.tushar.skillswap.common.enums.ChallengeStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

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
