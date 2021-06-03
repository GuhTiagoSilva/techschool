package com.stonks.techschool.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stonks.techschool.dto.StudyPlanDTO;
import com.stonks.techschool.entities.StudyPlan;
import com.stonks.techschool.repositories.StudyPlanRepository;
import com.stonks.techschool.services.exceptions.DatabaseException;
import com.stonks.techschool.services.exceptions.ResourceNotFoundException;

@Service
public class StudyPlanService {

	@Autowired
	private StudyPlanRepository repository;
	
	@Transactional
	public StudyPlanDTO insert(StudyPlanDTO dto) {
		StudyPlan entity = new StudyPlan();
		copyDtoToEntity(entity, dto);
		entity = repository.save(entity);
		return new StudyPlanDTO(entity);
	}
	
	@Transactional(readOnly = true)
	public StudyPlanDTO findById(Long id) {
		Optional<StudyPlan> result = repository.findById(id);
		StudyPlan entity = result.orElseThrow(() -> new ResourceNotFoundException("Id Not Found: " + id));
		return new StudyPlanDTO(entity);
	}
	
	@Transactional
	public StudyPlanDTO update(Long id, StudyPlanDTO dto) {
		try {
			StudyPlan entity = repository.getById(id);	
			copyDtoToEntity(entity, dto);
			entity = repository.save(entity);
			return new StudyPlanDTO(entity);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Entity Not Found");
		}	
	}
	
	@Transactional(readOnly = true)
	public Page<StudyPlanDTO> findAllPaged(PageRequest pageRequest) {
		Page<StudyPlan> list = repository.findAll(pageRequest);
		return list.map(studyPlan -> new StudyPlanDTO(studyPlan));
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Entity Not Found");
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Database Exception");
		}
	}
	
	private void copyDtoToEntity(StudyPlan entity, StudyPlanDTO dto) {
		entity.setDescription(dto.getDescription());
		entity.setEndDate(dto.getEndDate());
		entity.setStartDate(dto.getStartDate());
	}
	
	
}
