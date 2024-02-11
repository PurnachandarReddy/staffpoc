package com.example.staffpoc.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.staffpoc.exception.NoDataFoundException;
import com.example.staffpoc.model.StaffDetails;
import com.example.staffpoc.repository.StaffRepository;

@Service
public class StaffService {
	private static final Logger LOGGER = LoggerFactory.getLogger(StaffService.class);
	
	@Autowired
    private StaffRepository staffRepository;

    public List<StaffDetails> findStaffByCriteria(int year, double salary) {
    	List<StaffDetails> staffList = staffRepository.findByJoinDateYearAndSalaryGreaterThan(year, salary); 
    	
    
        staffList.forEach(staff -> LOGGER.info("Staff ID: {}, Name: {}", staff.getId(), staff.getName()));
        List<StaffDetails> details=staffList.stream()
                .filter(staff -> staff.getProjects().size() > 1)
                .collect(Collectors.toList());
        if (details.isEmpty()) {
            throw new NoDataFoundException("No staff found matching the criteria.");
        }
        return details;
        
        
    
    }
    
}
