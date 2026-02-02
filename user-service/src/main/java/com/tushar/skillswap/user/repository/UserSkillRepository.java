package com.tushar.skillswap.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tushar.skillswap.user.entity.UserSkillEntity;

public interface UserSkillRepository extends JpaRepository<UserSkillEntity, Long> {

	List<UserSkillEntity> findByUserId(Long userId);

	List<UserSkillEntity> findBySkillId(Long skillId);

	List<UserSkillEntity> findByUserIdAndSkillId(Long userId, Long skillId);

}
