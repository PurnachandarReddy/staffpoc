package com.example.staffpoc.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "staff")
public class StaffDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    @Column(name = "join_date")
    private LocalDate joinDate;
    
    private double salary;
    
    @OneToMany(mappedBy = "staff", cascade = CascadeType.ALL)
    private List<ProjectDetails> projects; // Mapping to projects

	public StaffDetails() {
		super();
	}

	
	public StaffDetails(Long id, String name, LocalDate joinDate, double salary, List<ProjectDetails> projects) {
		super();
		this.id = id;
		this.name = name;
		this.joinDate = joinDate;
		this.salary = salary;
		this.projects = projects;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public LocalDate getJoinDate() {
		return joinDate;
	}


	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	public List<ProjectDetails> getProjects() {
		return projects;
	}


	public void setProjects(List<ProjectDetails> projects) {
		this.projects = projects;
	}

    
}
