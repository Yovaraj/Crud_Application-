package com.example.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;
import com.example.repository.EmpRespository;

import com.example.entity.Employee;
@Service
public class EmpService {
	@Autowired
	private EmpRespository repo;
	public void addEmp(Employee e)
	{
		repo.save(e);
	}
	public List<Employee> getAllEmp()
	{
		return repo.findAll();
	}
	public Employee getEMpById(int id)
	{
		Optional<Employee> e = repo.findById(id);
		if(e.isPresent())
		{
			return e.get();
		}
		return null;
	}
	public void deletEmp(int id) {
		repo.deleteById(id);
	}
}
