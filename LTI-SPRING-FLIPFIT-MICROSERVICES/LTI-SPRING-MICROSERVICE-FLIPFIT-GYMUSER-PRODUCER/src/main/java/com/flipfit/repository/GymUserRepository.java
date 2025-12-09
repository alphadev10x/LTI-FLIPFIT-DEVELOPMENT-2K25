package com.flipfit.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.flipfit.constants.JPQLConstant;
import com.flipfit.entity.GymUser;


@Repository
public interface GymUserRepository extends JpaRepository<GymUser, Long>{
	
	@Query(value = JPQLConstant.JPQL_FINDEMAILANDPASSWORD)
	public Optional<GymUser> findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
	
	 public boolean existsByEmail(String email);

	 public Optional<GymUser> findByEmail(String email);
}
