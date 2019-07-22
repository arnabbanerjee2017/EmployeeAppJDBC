/*
 * Copyright (c) 2019, ARNAB BANERJEE. All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted only for academic purposes.
 * 
 * For further queries / info: arnab.ban09@gmail.com
 */

package com.arnab.emp.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.arnab.emp.entity.Employee;
import com.arnab.emp.repo.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo repo;
	
	@Async // Denotes Async method
	public CompletableFuture<Employee> getEmployee(int id) {
		return CompletableFuture.completedFuture(repo.getEmployee(id));
	}	
	
	@Async // Denotes Aync method
	public void saveEmployee(Employee e) {
		repo.save(e);
	}
	
}
