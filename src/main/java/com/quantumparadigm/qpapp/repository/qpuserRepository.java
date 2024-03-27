package com.quantumparadigm.qpapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.quantumparadigm.qpapp.dto.qpuser;
@Component
public interface qpuserRepository extends JpaRepository<qpuser, Integer> {
	List<qpuser> findByUserEmail(String userEmail);
}
