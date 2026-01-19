package com.tushar.skillswap.challenge.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.tushar.skillswap.challenge.dto.ChallengeCreateRequestDto;
import com.tushar.skillswap.challenge.dto.ChallengeResponseDto;
import com.tushar.skillswap.challenge.entity.ChallengeEntity;
import com.tushar.skillswap.challenge.exception.InvalidChallengeStateException;
import com.tushar.skillswap.challenge.mapper.ChallengeMapper;
import com.tushar.skillswap.challenge.repository.ChallengeRepository;
import com.tushar.skillswap.common.enums.ChallengeStatus;

import jakarta.transaction.Transactional;

@Service
public class ChallengeServiceImpl implements ChallengeService {

	private final ChallengeRepository challengeRepository;
	private final ChallengeMapper challengeMapper;

	public ChallengeServiceImpl(ChallengeRepository challengeRepository, ChallengeMapper challengeMapper) {
		super();
		this.challengeRepository = challengeRepository;
		this.challengeMapper = challengeMapper;
	}

	@Override
	@Transactional
	public ChallengeResponseDto createChallenge(Long challengerId,
			ChallengeCreateRequestDto challengeCreateRequestDto) {

		// cannot challenge yourself.
		if (challengerId.equals(challengeCreateRequestDto.getOpponentId())) {
			throw new InvalidChallengeStateException("Cannot challenge yourself");
		}

		ChallengeEntity challengeEntity = new ChallengeEntity();
		challengeEntity.setChallengerId(challengerId);
		challengeEntity.setOpponentId(challengeCreateRequestDto.getOpponentId());
		challengeEntity.setSkillId(challengeCreateRequestDto.getSkillId());
		challengeEntity.setStatus(ChallengeStatus.CREATED);

		ChallengeEntity saved = challengeRepository.save(challengeEntity);
		return challengeMapper.challengeEntityToChallengeEntityDto(saved);
	}

	@Override
	@Transactional
	public ChallengeResponseDto acceptChallenge(Long challengerId, Long userId) {
		ChallengeEntity challengeEntity = challengeRepository.findById(challengerId)
				.orElseThrow(() -> new IllegalArgumentException("Challenge Not Found"));

		if (!challengeEntity.getOpponentId().equals(userId)) {
			throw new InvalidChallengeStateException("Only opponent can accept");
		}

		if (challengeEntity.getStatus() != ChallengeStatus.CREATED) {
			throw new InvalidChallengeStateException("Challenge already processed");
		}

		challengeEntity.setStatus(ChallengeStatus.ACCEPTED);
		challengeEntity.setAcceptedAt(LocalDateTime.now());
		
		return challengeMapper.challengeEntityToChallengeEntityDto(challengeEntity);
	}

	@Override
	@Transactional
	public ChallengeResponseDto completeChallenge(Long challengerId, Long winnerId) {
		ChallengeEntity challengeEntity = challengeRepository.findById(challengerId)
				.orElseThrow(() -> new IllegalArgumentException("Challenge not found."));

		if (challengeEntity.getStatus() != ChallengeStatus.ACCEPTED) {
			throw new InvalidChallengeStateException("Challenge not in accepted status.");
		}

		challengeEntity.setWinnerId(winnerId);
		challengeEntity.setStatus(ChallengeStatus.COMPLETED);
		challengeEntity.setCompletedAt(LocalDateTime.now());

		return challengeMapper.challengeEntityToChallengeEntityDto(challengeEntity);
	}

}
