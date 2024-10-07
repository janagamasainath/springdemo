package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Patent;

@Repository
public interface PatentRepo extends JpaRepository<Patent, Integer> {
	
	/*
	 * @Query("SELECT p FROM Patent p WHERE p.salary > :salary") List<Patent>
	 * findPatentsWithSalaryGreaterThan(@Param("salary") int salary);
	 */
}
