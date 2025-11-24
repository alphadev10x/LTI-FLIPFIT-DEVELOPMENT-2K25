package com.flipfit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flipfit.entity.GymScheduler;

@Repository
public interface GymSchedulerRepository extends JpaRepository<GymScheduler, Long> {

}
