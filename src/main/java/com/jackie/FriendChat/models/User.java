package com.jackie.FriendChat.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
//Basic Class Object Attributes -------------------------
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		@Column(updatable=false)
		@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
		private Date createdAt;
		@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
		private Date updatedAt;
		@PrePersist
		protected void onCreate() {
			this.createdAt = new Date();
		}

//Object specific attributes -----------------
		@NotBlank(message="User Name is Required")
		@Size(min=2, max=255, message="User Name ust be over 2 characters")
		private String username;
		
		@NotBlank(message="Email is Required")
		@Email(message="Please enter a valid email!")
		private String email;
		
		@NotEmpty(message="Password is required!")
	    @Size(min=8, max=128, message="Password must be between 8 and 128 characters")
	    private String password;
		
		@Transient
	    @NotEmpty(message="Confirm Password is required!")
	    @Size(min=8, max=128, message="Confirm Password must be between 8 and 128 characters")
			private String confirmpass;

//Table Relationship Attribute-------------------
		@OneToMany(mappedBy="user", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
		private List<Message> message;
		
//Empty Constructor
		public User() {}

//Getters and Setters---------------------------
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}

		public Date getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getConfirmpass() {
			return confirmpass;
		}

		public void setConfirmpass(String confirmpass) {
			this.confirmpass = confirmpass;
		}

		public List<Message> getMessage() {
			return message;
		}

		public void setMessage(List<Message> message) {
			this.message = message;
		}
		
		
		
}
