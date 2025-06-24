package com.seth.burgertrack.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;



@Entity
@Table(name = "burgers")
public class Burger {

    //Member variables
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @NotNull
	@Size(min = 2, max = 200, message = "Burger must have a name (min: 2)")
	private String burgerName;
    
    @NotNull
	@Size(min = 1, max = 55, message = "Restaurant must have a name (min: 1)")
	private String restaurantName;
    
    @NotNull
	@Size(min = 1, max = 200, message = "There must be notes (min: 1)")
	private String notes;

    @NotNull
	@Min(0)
	private Integer rating;

    @Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;


	//Constructors

	//Must generate an EMPTY constructor
	public Burger() {
	}
	
	public Burger(String burgerName,String restaurantName,String notes,Integer rating) {
		this.burgerName = burgerName;
		this.restaurantName = restaurantName;
		this.notes = notes;
		this.rating = rating;
	}
    

    //Methods
    @PrePersist // run on create
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate // run on update
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	//Generate All Getters & Setters

	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}


	public String getBurgerName() {
		return burgerName;
	}


	public void setBurgerName(String burgerName) {
		this.burgerName = burgerName;
	}


	public String getRestaurantName() {
		return restaurantName;
	}


	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}


	public String getNotes() {
		return notes;
	}


	public void setNotes(String notes) {
		this.notes = notes;
	}


	public Integer getRating() {
		return rating;
	}


	public void setRating(Integer rating) {
		this.rating = rating;
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

