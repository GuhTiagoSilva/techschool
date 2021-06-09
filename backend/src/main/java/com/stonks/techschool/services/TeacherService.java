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

import com.stonks.techschool.dto.TeacherDTO;
import com.stonks.techschool.entities.Course;
import com.stonks.techschool.entities.Teacher;
import com.stonks.techschool.repositories.CourseRepository;
import com.stonks.techschool.repositories.TeacherRepository;
import com.stonks.techschool.services.exceptions.DatabaseException;
import com.stonks.techschool.services.exceptions.ResourceNotFoundException;

@Service
public class TeacherService {

	@Autowired
	private TeacherRepository repository;
	
	@Autowired
	private CourseRepository courseRepository;

	@Transactional
	public TeacherDTO insert(TeacherDTO dto) {
		Teacher entity = new Teacher();
		copyDtoToEntity(entity, dto);
		entity = repository.save(entity);
		return new TeacherDTO(entity);
	}

	@Transactional(readOnly = true)
	public TeacherDTO findById(Long id) {
		Optional<Teacher> result = repository.findById(id);
		Teacher entity = result.orElseThrow(() -> new ResourceNotFoundException("Id Not Found: " + id));
		return new TeacherDTO(entity);
	}

	@Transactional
	public TeacherDTO update(Long id, TeacherDTO dto) {
		try {
			Teacher entity = repository.getById(id);
			copyDtoToEntity(entity, dto);
			entity = repository.save(entity);
			return new TeacherDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Entity Not Found");
		}
	}

	@Transactional(readOnly = true)
	public Page<TeacherDTO> findAllPaged(PageRequest pageRequest) {
		Page<Teacher> list = repository.findAll(pageRequest);
		return list.map(teacher -> new TeacherDTO(teacher));
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Entity Not Found");
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Database Exception");
		}
	}

	private void copyDtoToEntity(Teacher entity, TeacherDTO dto) {
		entity.setAddress(dto.getAddress());
		entity.setAddressComplement(dto.getAddressComplement());
		entity.setAddressNumber(dto.getAddressNumber());
		entity.setName(dto.getName());
		entity.setImgProfile(dto.getImgProfile());
		entity.setDescription(dto.getDescription());
		Course course = courseRepository.getById(dto.getCourseId());
		entity.setCourse(course);
		
	}

}
