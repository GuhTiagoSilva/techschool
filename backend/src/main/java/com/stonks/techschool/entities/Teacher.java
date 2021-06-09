package com.stonks.techschool.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_teacher")
public class Teacher implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@Column(columnDefinition = "TEXT")
	private String description;
	private String address;
	private Integer addressNumber;
	private String addressComplement;
	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;
	
	private String imgProfile;
	
	public Teacher() {
		
	}

	public Teacher(Long id, String name, String address, String addressComplement, Course course, Integer addressNumber, String imgProfile, String description) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.addressComplement = addressComplement;
		this.course = course;
		this.addressNumber = addressNumber;
		this.imgProfile = imgProfile;
		this.description = description;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressComplement() {
		return addressComplement;
	}

	public void setAddressComplement(String addressComplement) {
		this.addressComplement = addressComplement;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	public Integer getAddressNumber() {
		return addressNumber;
	}
	
	public void setAddressNumber(Integer addressNumber) {
		this.addressNumber = addressNumber;
	}
	
	public String getImgProfile() {
		return imgProfile;
	}
	
	public void setImgProfile(String imgProfile) {
		this.imgProfile = imgProfile;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teacher other = (Teacher) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
