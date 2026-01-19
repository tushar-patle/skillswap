package com.tushar.skillswap.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tushar.skillswap.user.entity.UserSkillEntity;

public interface UserSkillRepository extends JpaRepository<UserSkillEntity, Long> {

	@Query("""
			SELECT us
			FROM UserSkillEntity us
			WHERE us.userId IN :userId
			""")
	List<UserSkillEntity> findByUserId(@Param("userid") Long userId);

	@Query("""
			SELECT us
			FROM UserSkillEntity us
			WHERE us.skillId IN :skillId
			""")
	List<UserSkillEntity> findBySkillId(@Param("skillId") Long skillId);

	@Query("""
			SELECT us
			FROMM UserSkillEntity us
			WHERE us.userId = :userId
			AND us.skillId = :skillId
			""")
	List<UserSkillEntity> findByUserAndSkill(@Param("userId") Long userId, @Param("skillId") Long skillId);

}
