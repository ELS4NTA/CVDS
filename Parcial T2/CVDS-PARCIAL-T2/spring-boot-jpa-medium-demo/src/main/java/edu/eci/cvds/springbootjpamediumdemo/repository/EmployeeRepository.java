package edu.eci.cvds.springbootjpamediumdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.eci.cvds.springbootjpamediumdemo.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    
}
