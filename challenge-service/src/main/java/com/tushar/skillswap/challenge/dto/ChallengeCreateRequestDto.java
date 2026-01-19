package com.tushar.skillswap.challenge.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ChallengeCreateRequestDto {

	@NotNull
	private Long opponentId;
	
	@NotNull
	private Long skillId;
}
