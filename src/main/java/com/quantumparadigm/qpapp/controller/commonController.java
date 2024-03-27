package com.quantumparadigm.qpapp.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quantumparadigm.qpapp.dto.qpuser;
import com.quantumparadigm.qpapp.service.commonService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/qp")
public class commonController {
	@Autowired
	commonService commonService;
	
	 @PostMapping("/userLogin")
	    public ResponseEntity<Object> userLogin(@RequestBody qpuser u, HttpSession httpSession) {
	        Object responseData = commonService.userLogin(u, httpSession);
	        return new ResponseEntity<>(responseData, HttpStatus.OK);
	    }

	    @PostMapping("/userSignUp")
	    public ResponseEntity<Object> userSignUp(@RequestBody qpuser u, HttpSession httpSession) {
	        Map<String, Object> responseString = commonService.userSignUp(u, httpSession);
	        return new ResponseEntity<>(responseString, HttpStatus.OK);
	    }
}
