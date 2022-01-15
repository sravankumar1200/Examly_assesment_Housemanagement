package com.example.demo.repository;

import com.example.demo.model.Employee;
import java.util.*;

import org.hibernate.query.criteria.internal.expression.function.AggregationFunction.LEAST;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestParam;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Modifying
    @Query(value="SELECT * FROM EMPLOYEES WHERE Employees.FIRSTNAME= :firstname",nativeQuery = true)
    List<Employee> findByName(String firstname);
   
    
}
