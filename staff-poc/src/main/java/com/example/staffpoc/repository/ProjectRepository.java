package com.example.staffpoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.staffpoc.model.ProjectDetails;
@Repository
public interface ProjectRepository extends JpaRepository<ProjectDetails, Long> {
	
	
}
