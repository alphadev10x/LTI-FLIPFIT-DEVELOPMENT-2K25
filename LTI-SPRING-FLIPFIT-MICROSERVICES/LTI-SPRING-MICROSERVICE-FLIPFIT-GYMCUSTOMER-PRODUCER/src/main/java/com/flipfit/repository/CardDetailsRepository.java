package com.flipfit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flipfit.entity.CardDetails;

@Repository
public interface CardDetailsRepository extends  JpaRepository<CardDetails, Long>{

}
