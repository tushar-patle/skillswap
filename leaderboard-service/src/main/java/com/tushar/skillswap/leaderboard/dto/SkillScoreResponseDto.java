package com.tushar.skillswap.leaderboard.dto;

import lombok.Data;

@Data
public class SkillScoreResponseDto {

	private Long userId;
	private Long skillId;
	private Integer points;
}
