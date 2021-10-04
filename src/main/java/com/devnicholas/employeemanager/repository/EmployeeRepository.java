package com.devnicholas.employeemanager.repository;

import com.devnicholas.employeemanager.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employees,Long> {
}
