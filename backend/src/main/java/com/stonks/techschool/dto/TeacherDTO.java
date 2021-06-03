package com.stonks.techschool.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.stonks.techschool.entities.Teacher;

public class TeacherDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String address;
	private Integer addressNumber;
	private String addressComplement;
	private List<CourseDTO> courses = new ArrayList<>();
	
	public TeacherDTO() {
		
	}
	
	public TeacherDTO(Teacher entity) {
		id = entity.getId();
		name = entity.getName();
		address = entity.getAddress();
		addressNumber = entity.getAddressNumber();
		addressComplement = entity.getAddressComplement();
	}

	public TeacherDTO(Long id, String name, String address, Integer addressNumber, String addressComplement) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.addressNumber = addressNumber;
		this.addressComplement = addressComplement;
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

	public Integer getAddressNumber() {
		return addressNumber;
	}

	public void setAddressNumber(Integer addressNumber) {
		this.addressNumber = addressNumber;
	}

	public String getAddressComplement() {
		return addressComplement;
	}

	public void setAddressComplement(String addressComplement) {
		this.addressComplement = addressComplement;
	}

	public List<CourseDTO> getCourses() {
		return courses;
	}

	public void setCourses(List<CourseDTO> courses) {
		this.courses = courses;
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
		TeacherDTO other = (TeacherDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
