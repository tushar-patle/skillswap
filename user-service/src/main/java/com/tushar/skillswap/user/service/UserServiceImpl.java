package com.tushar.skillswap.user.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tushar.skillswap.user.dto.UserRequestDto;
import com.tushar.skillswap.user.dto.UserResponseDto;
import com.tushar.skillswap.user.entity.UserEntity;
import com.tushar.skillswap.user.exception.UserAlreadyExistsException;
import com.tushar.skillswap.user.mapper.UserMapper;
import com.tushar.skillswap.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final UserMapper userMapper;
	private final PasswordEncoder passwordEncoder;

	public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.userMapper = userMapper;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	@Transactional
	public UserResponseDto createUser(UserRequestDto userRequestDto) {

		// Business validation
		if (userRepository.findByUsername(userRequestDto.getUsername()).isPresent()) {
			throw new UserAlreadyExistsException("Username already exists");
		}

		if (userRepository.findByEmail(userRequestDto.getEmail()).isPresent()) {
			throw new UserAlreadyExistsException("User Email already exists");
		}

		// Mapping
		UserEntity userEntity = userMapper.userEntityDtoToUserEntity(userRequestDto);
		userEntity.setPasswordHash(passwordEncoder.encode(userRequestDto.getPassword()));

		// Persistence
		UserEntity savedUser = userRepository.save(userEntity);
		return userMapper.userEntityToUserEntityDto(savedUser);
	}

	@Override
	@Transactional(readOnly = true)
	public UserResponseDto getUserById(Long userId) {

		UserEntity userEntity = userRepository.findById(userId)
				.orElseThrow(() -> new IllegalArgumentException("User not found"));
		return userMapper.userEntityToUserEntityDto(userEntity);
	}

}
