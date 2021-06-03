package com.stonks.techschool.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.stonks.techschool.entities.Company;
import com.stonks.techschool.entities.Course;
import com.stonks.techschool.entities.Enrollment;

public class CompanyDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String address;
	private Integer addressNumber;
	private String addressComplement;
	private String cnpj;
	private List<CourseDTO> courses = new ArrayList<>();
	private List<EnrollmentDTO> enrollments = new ArrayList<>();
	
	public CompanyDTO() {
		
	}
	
	public CompanyDTO(Company entity) {
		id = entity.getId();
		name = entity.getName();
		address = entity.getAddress();
		addressNumber = entity.getAddressNumber();
		addressComplement = entity.getAddressComplement();
		cnpj = entity.getCnpj();
	}
	
	public CompanyDTO(Company entity, List<Course> coursesEntity, List<Enrollment> enrollmentsEntity) {
		this(entity);
		coursesEntity.stream().map(course -> new CourseDTO(course)).collect(Collectors.toList());
		enrollmentsEntity.stream().map(enrollment -> new EnrollmentDTO(enrollment)).collect(Collectors.toList());
	}

	public CompanyDTO(Long id, String name, String address, Integer addressNumber, String addressComplement,
			String cnpj) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.addressNumber = addressNumber;
		this.addressComplement = addressComplement;
		this.cnpj = cnpj;
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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public List<CourseDTO> getCourses() {
		return courses;
	}

	public void setCourses(List<CourseDTO> courses) {
		this.courses = courses;
	}
	
	public List<EnrollmentDTO> getEnrollments() {
		return enrollments;
	}
	
	public void setEnrollments(List<EnrollmentDTO> enrollments) {
		this.enrollments = enrollments;
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
		CompanyDTO other = (CompanyDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}