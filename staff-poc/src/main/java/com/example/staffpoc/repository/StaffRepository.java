package com.example.staffpoc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.staffpoc.model.StaffDetails;
@Repository
//public interface StaffRepository extends JpaRepository<StaffDetails, Long> {
//    List<StaffDetails> findByJoinDateYearAndSalaryGreaterThan(int year, double salary);
//}

public interface StaffRepository extends JpaRepository<StaffDetails, Long> {
    @Query(value = "SELECT * FROM staff WHERE YEAR(join_date) = :year AND salary > :salary", nativeQuery = true)
    List<StaffDetails> findByJoinDateYearAndSalaryGreaterThan(@Param("year") int year, @Param("salary") double salary);
}

