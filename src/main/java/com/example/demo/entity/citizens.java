package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class citizens {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String city;
	private int noOfDoses;
	private String vaccinationStatus;
	@ManyToOne
	private vaccinationCenter vaccinationCenter;
	
	public citizens() {}

	public citizens(Long id, String name, String city, int noOfDoses, String vaccinationStatus,
			com.example.demo.entity.vaccinationCenter vaccinationCenter) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.noOfDoses = noOfDoses;
		this.vaccinationStatus = vaccinationStatus;
		this.vaccinationCenter = vaccinationCenter;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getNoOfDoses() {
		return noOfDoses;
	}

	public void setNoOfDoses(int noOfDoses) {
		this.noOfDoses = noOfDoses;
	}

	public String getVaccinationStatus() {
		return vaccinationStatus;
	}

	public void setVaccinationStatus(String vaccinationStatus) {
		this.vaccinationStatus = vaccinationStatus;
	}

	public vaccinationCenter getVaccinationCenter() {
		return vaccinationCenter;
	}

	public void setVaccinationCenter(vaccinationCenter vaccinationCenter) {
		this.vaccinationCenter = vaccinationCenter;
	}

	@Override
	public String toString() {
		return "citizens [id=" + id + ", name=" + name + ", city=" + city + ", noOfDoses=" + noOfDoses
				+ ", vaccinationStatus=" + vaccinationStatus + ", vaccinationCenter=" + vaccinationCenter + "]";
	}
	

}
