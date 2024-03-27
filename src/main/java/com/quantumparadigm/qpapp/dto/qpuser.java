package com.quantumparadigm.qpapp.dto;

import org.springframework.stereotype.Component;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Component
@Data
@Entity
public class qpuser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String userName;
	private String userEmail;
	private String userCountry;
	private String userState;
	private String userPassword;
	private long userPhone;
	private String userPhotoLink;
	private boolean userStatus;
}
