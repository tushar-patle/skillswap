package com.tushar.skillswap.user.service;

import com.tushar.skillswap.user.dto.UserRequestDto;
import com.tushar.skillswap.user.dto.UserResponseDto;

public interface UserService {

	UserResponseDto createUser(UserRequestDto userRequestDto);
	
	UserResponseDto getUserById(Long userId);
}
