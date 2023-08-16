package com.jackie.FriendChat.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="messages")
public class Message {

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
		@NotBlank(message="Don't forget to write a message!")
		private String message;

//Table Relationship Attribute-------------------
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name="user_id")
		private User user;
		
//Empty Constructor-------------------------------
		public Message() {}
		
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

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}
		

}
