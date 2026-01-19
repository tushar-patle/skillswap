package com.tushar.skillswap.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tushar.skillswap.user.entity.SkillEntity;

public interface SkillRepository extends JpaRepository<SkillEntity, Long> {

	Optional<SkillEntity> findByNameIgnoreCase(String name);
}
