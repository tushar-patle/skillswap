package com.tushar.skillswap.user.entity;

import com.tushar.skillswap.common.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "userSkills", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "skill_id"}))
@Getter
@Setter
public class UserSkillEntity extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "user_id", nullable = false)
	private Long userId;
	
	@Column(name = "skill_id", nullable = false)
	private Long skillId;
	
	@Column(name = "proficiency_level")
	private Integer proficiencyLevel;

	@Column(name = "years_of_experience")
    private Integer yearsOfExperience;
}
