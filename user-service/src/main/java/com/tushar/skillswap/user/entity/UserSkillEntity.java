package com.tushar.skillswap.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user_skills", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "skill_id"}))
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
