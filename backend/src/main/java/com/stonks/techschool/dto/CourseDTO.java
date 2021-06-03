package com.stonks.techschool.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;

import com.stonks.techschool.entities.Course;
import com.stonks.techschool.entities.StudyPlan;

public class CourseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	@NotBlank(message = "Campo Obrigatório")
	private String name;
	private AreaDTO area;
	private List<StudyPlanDTO> studyPlans = new ArrayList<>();
	private String imgUrl;
	private String description;
	
	public CourseDTO() {
		
	}
	
	public CourseDTO(Course entity) {
		id = entity.getId();
		name = entity.getName();
		imgUrl = entity.getImgUrl();
		description = entity.getDescription();
	}
	
	public CourseDTO(Course entity, List<StudyPlan> studyPlansEntity) {
		this(entity);
		studyPlansEntity.stream().map(studyPlan -> studyPlans.add(new StudyPlanDTO(studyPlan))).collect(Collectors.toList());
	}

	public CourseDTO(Long id, String name, AreaDTO areaDTO, String imgUrl, String description) {
		super();
		this.id = id;
		this.name = name;
		this.area = areaDTO;
		this.imgUrl = imgUrl;
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

	public AreaDTO getArea() {
		return area;
	}

	public void setArea(AreaDTO area) {
		this.area = area;
	}
	
	public String getImgUrl() {
		return imgUrl;
	}
	
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
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
		CourseDTO other = (CourseDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
