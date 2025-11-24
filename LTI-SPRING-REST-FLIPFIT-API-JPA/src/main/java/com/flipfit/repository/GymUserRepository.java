package com.flipfit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flipfit.entity.GymUser;


@Repository
public interface GymUserRepository extends JpaRepository<GymUser, Long>{

}
