package com.seth.belt.models;

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
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="players")
public class Player {
	// Member variables
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		@NotNull
		@Size(min = 1, max = 200, message = "There must be an player name.")
		private String playerName;
		
		
		// M : 1
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "team_id")
		private Team team;
		
		
		@Column(updatable = false)
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private Date createdAt;
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private Date updatedAt;
		
		//Constructor
		public Player() {
			super();
		}
		
		// Methods
		@PrePersist // run on create
		protected void onCreate() {
			this.createdAt = new Date();
		}

		@PreUpdate // run on update
		protected void onUpdate() {
			this.updatedAt = new Date();
		}
		
		//Getters & Setters

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getPlayerName() {
			return playerName;
		}

		public void setPlayerName(String playerName) {
			this.playerName = playerName;
		}

		public Team getTeam() {
			return team;
		}

		public void setTeam(Team team) {
			this.team = team;
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
}
