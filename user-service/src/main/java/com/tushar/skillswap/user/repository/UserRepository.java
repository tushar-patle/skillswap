package com.tushar.skillswap.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tushar.skillswap.user.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{

	Optional<UserEntity> findByUsername(String username);
	
	Optional<UserEntity> findByEmail(String email);
	
	@Query("""
			SELECT u
			FROM UserEntity u
			WHERE u.id IN :ids
			""")
	List<UserEntity> findByIds(@Param("ids") List<Long> ids);
}
