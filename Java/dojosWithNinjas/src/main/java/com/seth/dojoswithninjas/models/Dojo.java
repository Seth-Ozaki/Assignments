package com.seth.dojoswithninjas.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "dojos")
public class Dojo {

	// Member variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min = 1, max = 55, message = "Dojo must have a name")
	private String dojoName;

	@OneToMany(mappedBy = "dojo", fetch = FetchType.LAZY)
	private List<Ninja> dojosNinjas;

	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

	// Constructors

	public Dojo() {
	}

	public Dojo(String dojoName) {
		this.dojoName = dojoName;
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

	// Getters & Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDojoName() {
		return dojoName;
	}

	public void setDojoName(String dojoName) {
		this.dojoName = dojoName;
	}

	public List<Ninja> getDojosNinjas() {
		return dojosNinjas;
	}

	public void setDojosNinjas(List<Ninja> dojosNinjas) {
		this.dojosNinjas = dojosNinjas;
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
