package com.example.staffpoc.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.staffpoc.exception.NoDataFoundException;
import com.example.staffpoc.model.StaffDetails;
import com.example.staffpoc.service.StaffService;

@RestController
@RequestMapping("/api/staff")
public class StaffController {
	
	
    private final StaffService staffService;

    // Constructor injection
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }
    

    @GetMapping("/2023WithSalary>30k")
    public ResponseEntity<List<StaffDetails>> getStaffJoinedIn2023WithCriteria() throws NoDataFoundException{
        int year = 2023;
        double salaryThreshold = 30000.0;
        List<StaffDetails> staffList = staffService.findStaffByCriteria(year, salaryThreshold);
        return new ResponseEntity<>(staffList, HttpStatus.OK);
    }
}
