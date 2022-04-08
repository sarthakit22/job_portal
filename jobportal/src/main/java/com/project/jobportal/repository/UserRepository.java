package com.project.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.jobportal.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	
	  @Query("select u from UserEntity u WHERE u.email=:email and u.password=:password") 
	  UserEntity authentication(@Param("email") String email, @Param("password") String password);
}
