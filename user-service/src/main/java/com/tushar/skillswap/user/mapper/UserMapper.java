package com.tushar.skillswap.user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.tushar.skillswap.user.dto.UserRequestDto;
import com.tushar.skillswap.user.dto.UserResponseDto;
import com.tushar.skillswap.user.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {

	@Mapping(target = "passwordHash", ignore = true)
	@Mapping(target = "status", ignore = true)
	UserEntity userEntityDtoToUserEntity(UserRequestDto userRequestDto); 
	
	UserResponseDto userEntityToUserEntityDto(UserEntity userEntity);
}
