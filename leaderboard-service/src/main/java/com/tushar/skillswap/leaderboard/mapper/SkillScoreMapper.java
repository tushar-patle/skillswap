package com.tushar.skillswap.leaderboard.mapper;

import org.mapstruct.Mapper;

import com.tushar.skillswap.leaderboard.dto.SkillScoreResponseDto;
import com.tushar.skillswap.leaderboard.entity.SkillScoreEntity;

@Mapper(componentModel = "spring")
public interface SkillScoreMapper {

	SkillScoreResponseDto skillScoreEntitytoSkillScoreEntityDto(SkillScoreEntity skillScoreEntity);
}
