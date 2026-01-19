package com.tushar.skillswap.challenge.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.tushar.skillswap.challenge.dto.ChallengeResponseDto;
import com.tushar.skillswap.challenge.entity.ChallengeEntity;

@Mapper(componentModel = "spring")
public interface ChallengeMapper {

	@Mapping(source = "createdAt", target = "createdAt")
	ChallengeResponseDto challengeEntityToChallengeEntityDto(ChallengeEntity challengeEntity);
}
