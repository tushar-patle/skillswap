package com.tushar.skillswap.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tushar.skillswap.challenge.entity.ChallengeEntity;
import com.tushar.skillswap.common.enums.ChallengeStatus;

public interface ChallengeRepository extends JpaRepository<ChallengeEntity, Long>{

	@Query("""
			SELECT c
			FROM ChallengeEntity c
			WHERE c.status = :status
			""")
	List<ChallengeEntity> findByStatus(@Param("status") ChallengeStatus status);
	
	@Query("""
	        SELECT c
	        FROM ChallengeEntity c
	        WHERE c.opponentId = :userId
	        AND c.status = 'CREATED'
	        """)
	    List<ChallengeEntity> findPendingChallengesForUser(@Param("userId") Long userId);

	@Query("""
	        SELECT c
	        FROM ChallengeEntity c
	        WHERE c.skillId = :skillId
	        AND c.status = 'COMPLETED'
	        """)
	    List<ChallengeEntity> findCompletedBySkill(@Param("skillId") Long skillId);

}
