package com.tushar.skillswap.user.dto;

import com.tushar.skillswap.common.enums.UserStatus;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "User details response")
public class UserResponseDto {

	@Schema(example = "1")
	private Long id;
	
	@Schema(example = "name_123")
	private String username;
	
	@Schema(example = "abc@xyz.com")
	private String email;
	
	@Schema(example = "Tushar")
	private String displayName;
	
	@Schema(example = "ACTIVE")
	private UserStatus status;
	
}
