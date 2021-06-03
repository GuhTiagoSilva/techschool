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

import com.stonks.techschool.dto.CourseDTO;
import com.stonks.techschool.entities.Area;
import com.stonks.techschool.entities.Course;
import com.stonks.techschool.repositories.AreaRepository;
import com.stonks.techschool.repositories.CourseRepository;
import com.stonks.techschool.services.exceptions.DatabaseException;
import com.stonks.techschool.services.exceptions.ResourceNotFoundException;

@Service
public class CourseService {

	@Autowired
	private CourseRepository repository;
	
	@Autowired
	private AreaRepository areaRepository;
	
	@Transactional
	public CourseDTO insert(CourseDTO dto) {
		Course entity = new Course();
		copyDtoToEntity(entity, dto);
		entity = repository.save(entity);
		return new CourseDTO(entity);
	}
	
	@Transactional(readOnly = true)
	public CourseDTO findById(Long id) {
		Optional<Course> result = repository.findById(id);
		Course entity = result.orElseThrow(() -> new ResourceNotFoundException("Id Not Found: " + id));
		return new CourseDTO(entity);
	}
	
	@Transactional
	public CourseDTO update(Long id, CourseDTO dto) {
		try {
			Course entity = repository.getById(id);	
			copyDtoToEntity(entity, dto);
			entity = repository.save(entity);
			return new CourseDTO(entity);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Entity Not Found");
		}	
	}
	
	@Transactional(readOnly = true)
	public Page<CourseDTO> findAllPaged(PageRequest pageRequest) {
		Page<Course> list = repository.findAll(pageRequest);
		return list.map(course -> new CourseDTO(course));
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
	
	private void copyDtoToEntity(Course entity, CourseDTO dto) {
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setImgUrl(dto.getImgUrl());
		Area area = areaRepository.getById(dto.getArea().getId());
		entity.setArea(area);
		entity.setArea(area);
	}
	
}
