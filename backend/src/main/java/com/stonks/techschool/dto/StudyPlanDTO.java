package com.stonks.techschool.dto;

import java.io.Serializable;
import java.time.Instant;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.stonks.techschool.entities.StudyPlan;

public class StudyPlanDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	@NotBlank(message = "Campo Obrigatório")
	@Size(min = 10, message = "A descrição precisa conter no mínimo 10 caracteres")
	private String description;
	private Instant startDate;
	private Instant endDate;
	
	public StudyPlanDTO() {
		
	}
	
	public StudyPlanDTO(StudyPlan entity) {
		id = entity.getId();
		description = entity.getDescription();
		startDate = entity.getStartDate();
		endDate = entity.getEndDate();
	}

	public StudyPlanDTO(Long id, String description, Instant startDate, Instant endDate) {
		super();
		this.id = id;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Instant getStartDate() {
		return startDate;
	}

	public void setStartDate(Instant startDate) {
		this.startDate = startDate;
	}

	public Instant getEndDate() {
		return endDate;
	}

	public void setEndDate(Instant endDate) {
		this.endDate = endDate;
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
		StudyPlanDTO other = (StudyPlanDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
