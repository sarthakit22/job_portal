package com.project.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.jobportal.entity.ApplyEntity;

@Repository
public interface ApplyRepository extends JpaRepository<ApplyEntity, Long>{

}
