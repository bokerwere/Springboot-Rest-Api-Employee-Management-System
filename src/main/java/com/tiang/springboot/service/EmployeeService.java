package com.tiang.springboot.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.tiang.springboot.model.Employee;

public interface EmployeeService {
	
   List<Employee> getAllEmployee();
   void saveEmployee(Employee employee);
   Employee getEmployeeById(long id);
   void deleteEmployeeById(long id);
   Page < Employee > findPaginated(int pageNo, int pageSize);
   

}
