package com.stonks.techschool.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stonks.techschool.dto.AreaDTO;
import com.stonks.techschool.dto.CourseDTO;
import com.stonks.techschool.entities.Area;
import com.stonks.techschool.entities.Course;
import com.stonks.techschool.repositories.AreaRepository;
import com.stonks.techschool.repositories.CourseRepository;
import com.stonks.techschool.services.exceptions.DatabaseException;
import com.stonks.techschool.services.exceptions.ResourceNotFoundException;

@Service
public class AreaService {

	@Autowired
	private AreaRepository repository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Transactional
	public AreaDTO insert(AreaDTO dto) {
		Area entity = new Area();
		copyDtoToEntity(entity, dto);
		entity = repository.save(entity);
		return new AreaDTO(entity, entity.getCourses());
	}
	
	@Transactional(readOnly = true)
	public AreaDTO findById(Long id) {
		Optional<Area> result = repository.findById(id);
		Area entity = result.orElseThrow(() -> new ResourceNotFoundException("Id Not Found: " + id));
		return new AreaDTO(entity,entity.getCourses());
	}
	
	@Transactional
	public AreaDTO update(Long id, AreaDTO dto) {
		try {
			Area entity = repository.getById(id);	
			copyDtoToEntity(entity, dto);
			entity = repository.save(entity);
			return new AreaDTO(entity, entity.getCourses());
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Entity Not Found");
		}	
	}
	
	@Transactional(readOnly = true)
	public Page<AreaDTO> findAllPaged(PageRequest pageRequest) {
		Page<Area> list = repository.findAll(pageRequest);
		return list.map(area -> new AreaDTO(area, area.getCourses()));
	}
	
	@Transactional(readOnly = true)
	public List<AreaDTO> findAllWithNoPagination(){
		List<Area> areas = repository.findAllWithNoPagination();
		return areas.stream().map(area -> new AreaDTO(area)).collect(Collectors.toList());
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
	
	private void copyDtoToEntity(Area entity, AreaDTO dto) {
		entity.setName(dto.getName());		
		entity.getCourses().clear();
		
		for (CourseDTO dtos : dto.getCourses()) {
			Course course = courseRepository.getById(dtos.getId());
			entity.getCourses().add(course);
		}		
	}
	
}
