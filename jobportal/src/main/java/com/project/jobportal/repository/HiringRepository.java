package com.project.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.jobportal.entity.HrHiring;

@Repository
public interface  HiringRepository extends JpaRepository<HrHiring, Long> {
	
	@Query("select u from HrHiring u WHERE u.branch=:branch and u.experience=:experience") 
	HrHiring branchEx(@Param("branch") String branch, @Param("experience") String experience);

}