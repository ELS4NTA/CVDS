package edu.eci.cvds.springbootjpamediumdemo;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import edu.eci.cvds.springbootjpamediumdemo.model.Employee;
import edu.eci.cvds.springbootjpamediumdemo.service.EmployeeService;

@SpringBootApplication
public class SpringBootJpaMediumDemoApp {

    @Autowired
    EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJpaMediumDemoApp.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return (args) -> {
            
            System.out.println("\nDeleting all employees....");
            employeeService.deleteAllEmployees();

            System.out.println("Adding employees....\n");
            employeeService.addEmployee(new Employee("Daniel", "Santanilla", "CVDS Student", 0.00, LocalDate.of(2003, 4, 10)));
            employeeService.addEmployee(new Employee("Jorge", "Useche", "CVDS Teacher", 9999.00, LocalDate.of(0001, 6, 15)));
            
            System.out.println("\nGetting all employees....");
            employeeService.getAllEmployees().forEach(employee -> System.out.println(employee));
        };
    }

}
