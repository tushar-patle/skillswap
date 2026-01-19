package com.tushar.skillswap.challenge.service;

import com.tushar.skillswap.challenge.dto.ChallengeCreateRequestDto;
import com.tushar.skillswap.challenge.dto.ChallengeResponseDto;

public interface ChallengeService {

	ChallengeResponseDto createChallenge(Long challengerId, ChallengeCreateRequestDto challengeCreateRequestDto);

	ChallengeResponseDto acceptChallenge(Long challengerId, Long userId);

	ChallengeResponseDto completeChallenge(Long challengerId, Long winnerId);
}
