package com.quantumparadigm.qpapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.quantumparadigm.qpapp.dto.qpuser;
import com.quantumparadigm.qpapp.repository.qpuserRepository;

@Component
public class commonDao {
	
	@Autowired
	qpuserRepository qpuserRepository;
	
	public String userSignUp(qpuser u) {
		qpuserRepository.save(u);
		return "Added";
	}
	
	public List<qpuser> findUserByEmail(String userEmail) {
		return qpuserRepository.findByUserEmail(userEmail);
	}
}
