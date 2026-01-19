package com.tushar.skillswap.challenge.dto;

import java.time.LocalDateTime;

import com.tushar.skillswap.common.enums.ChallengeStatus;

import lombok.Data;

@Data
public class ChallengeResponseDto {

	private Long id;
	private Long challengerId;
	private Long opponentId;
	private Long skillId;
	private ChallengeStatus status;
	private LocalDateTime createdAt;
}
