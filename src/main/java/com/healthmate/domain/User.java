package com.healthmate.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Table(name = "HEALTH_MEMBER")
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 50, unique = true)
	private String username;
	
	@Column(length = 50)
	private String password;
	
	@Column(length = 50, unique = true)
	private String email;
	
	
	private String role;
	
	// 성별
	@Column(nullable = false)
	private String gender;
	
	// 운동 목적
	@Column(nullable = false)
	private String purpose;
	
	@CreationTimestamp
	private Timestamp createDate;
}
