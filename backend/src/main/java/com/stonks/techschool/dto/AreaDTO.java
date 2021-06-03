package com.stonks.techschool.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.stonks.techschool.entities.Area;
import com.stonks.techschool.entities.Course;

public class AreaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private List<CourseDTO> courses = new ArrayList<>();
	
	public AreaDTO() {
		
	}
	
	public AreaDTO(Area entity) {
		id = entity.getId();
		name = entity.getName();
	}
	
	public AreaDTO(Area entity, List<Course> coursesEntity) {
		this(entity);
		coursesEntity.stream().map(course -> courses.add(new CourseDTO(course))).collect(Collectors.toList());
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
		AreaDTO other = (AreaDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
