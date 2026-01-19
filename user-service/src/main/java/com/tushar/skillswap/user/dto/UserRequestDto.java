package com.tushar.skillswap.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "Request payload to create a user")
public class UserRequestDto {

	@Schema(example = "name_123", description = "Unique username")
	@NotBlank
	@Size(min = 3, max = 50)
	private String username;
	
	@Schema(example = "abc@xyz.com")
	@Email
	@NotBlank
	private String email;
	
	@Schema(example = "StrongPassword@123")
	@NotBlank
	private String password;
	
	@Schema(example = "Tushar")
	private String displayName;
}
