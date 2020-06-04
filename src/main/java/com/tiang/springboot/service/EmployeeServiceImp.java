package com.tiang.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.tiang.springboot.model.Employee;
import com.tiang.springboot.repository.EmployeeRepository;
 @Service
public class EmployeeServiceImp implements EmployeeService {
   @Autowired
	EmployeeRepository employeRepository;
  
	
	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeRepository.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) {
		
		this.employeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(long id) {
		
	 Optional<Employee> optional=employeRepository.findById(id) ;
	 Employee employee=null;
	 if(optional.isPresent()) {
		 employee=optional.get();
		 
	 }else {
		 
		 throw new RuntimeException("employee not found id:: " +id);
	 }
	 
		// TODO Auto-generated method stub
		return employee;
	}

	@Override
	public void deleteEmployeeById(long id) {
		
		this.employeRepository.deleteById(id);
		
	}

	@Override
	public Page<Employee> findPaginated(int pageNo, int pageSize) {
		PageRequest pageable = PageRequest.of(pageNo - 1, pageSize);
		 return this.employeRepository.findAll(pageable);
		
	}


	

}
