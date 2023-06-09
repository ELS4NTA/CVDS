package edu.eci.cvds.springbootjpamediumdemo.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeId;
    private String firstName;
    private String lastName;
    private String role;
    private Double salary;

    public Employee() {}
    
    public Employee(String firstName, String lastName, String role, Double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.salary = salary;
    }

    public Long getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public Double getSalary() {
        return salary;
    }
    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        return Objects.equals(employeeId, other.employeeId) &&
            Objects.equals(firstName, other.firstName) &&
            Objects.equals(lastName, other.lastName) &&
            Objects.equals(role, other.role) &&
            Objects.equals(salary, other.salary);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(employeeId, firstName, lastName, role, salary);
    }

    @Override
    public String toString() {
        return String.format("Employee [employeeId=%s, firstName=%s, lastName=%s, role=%s, salary=%s]", 
                            employeeId, firstName, lastName, role, salary);
    }
    
}

