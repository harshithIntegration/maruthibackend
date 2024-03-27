package com.quantumparadigm.qpapp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.quantumparadigm.qpapp.dao.commonDao;
import com.quantumparadigm.qpapp.dto.qpuser;

import jakarta.servlet.http.HttpSession;

@Component
public class commonService {
	
	@Autowired
	commonDao commonDao;
	
	public  Map<String, Object> userLogin(qpuser u, HttpSession httpSession) {
	    Map<String, Object> response = new HashMap<>();
	    List<qpuser> exUser = commonDao.findUserByEmail(u.getUserEmail());
	    if (exUser.isEmpty()) {
	        response.put("message", "fail");
	        response.put("error","Invalid email");
	    } else {
	        Optional<qpuser> matchingUser = exUser.stream()
	                .filter(user -> user.getUserPassword().equals(u.getUserPassword()))
	                .findFirst();

	        if (matchingUser.isPresent()) {
	        	response.put("message", "pass");
	            response.put("user", matchingUser.get());
	        } else {
	            response.put("message", "fail");
	            response.put("error", "Invalid password");
	        }
	    }
	    return response;
	}

	
	public Map<String, Object> userSignUp(qpuser u, HttpSession httpSession) {
		List<qpuser> exUser=commonDao.findUserByEmail(u.getUserEmail());
		Map<String, Object> response = new HashMap<>();
		if(!exUser.isEmpty()) {
			response.put("message", "fail");
			response.put("error", "Account already exists");
		}else {
			commonDao.userSignUp(u);
			response.put("message", "pass");
		}
		return response;
	}

}
