package com.flipfit.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flipfit.entity.GymRole;


@Repository
public interface GymRoleRepository extends JpaRepository<GymRole, Long> {

	Optional<GymRole> findByRoleName(String roleName);

}
