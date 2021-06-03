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

import com.stonks.techschool.dto.EnrollmentDTO;
import com.stonks.techschool.entities.Course;
import com.stonks.techschool.entities.Enrollment;
import com.stonks.techschool.entities.User;
import com.stonks.techschool.entities.pk.EnrollmentPK;
import com.stonks.techschool.repositories.CourseRepository;
import com.stonks.techschool.repositories.EnrollmentRepository;
import com.stonks.techschool.repositories.UserRepository;
import com.stonks.techschool.services.exceptions.DatabaseException;
import com.stonks.techschool.services.exceptions.ResourceNotFoundException;

@Service
public class EnrollmentService {

	@Autowired
	private EnrollmentRepository repository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CourseRepository courseRepository;

	@Transactional
	public EnrollmentDTO insert(EnrollmentDTO dto) {
		Enrollment entity = new Enrollment();
		copyDtoToEntity(entity, dto);
		entity = repository.save(entity);
		return new EnrollmentDTO(entity);
	}

	@Transactional(readOnly = true)
	public EnrollmentDTO findById(Long userId, Long courseId) {

		User user = userRepository.getById(userId);
		Course course = courseRepository.getById(courseId);

		EnrollmentPK pk = new EnrollmentPK(user, course);

		Optional<Enrollment> result = repository.findById(pk);
		Enrollment entity = result.orElseThrow(
				() -> new ResourceNotFoundException("Id Not Found: " + pk.getUser().getId() + pk.getCourse().getId()));
		return new EnrollmentDTO(entity);
	}

	@Transactional
	public EnrollmentDTO update(Long id, EnrollmentDTO dto) {
		try {
			User user = userRepository.getById(dto.getUserId());
			Course course = courseRepository.getById(dto.getCourseId());

			EnrollmentPK pk = new EnrollmentPK(user, course);
			Enrollment entity = repository.getById(pk);
			copyDtoToEntity(entity, dto);
			entity = repository.save(entity);
			return new EnrollmentDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Entity Not Found");
		}
	}

	@Transactional(readOnly = true)
	public Page<EnrollmentDTO> findAllPaged(PageRequest pageRequest) {
		Page<Enrollment> list = repository.findAll(pageRequest);
		return list.map(enrollment -> new EnrollmentDTO(enrollment));
	}

	public void delete(Long userId, Long courseId) {
		try {
			User user = userRepository.getById(userId);
			Course course = courseRepository.getById(courseId);

			EnrollmentPK pk = new EnrollmentPK(user, course);
			repository.deleteById(pk);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Entity Not Found");
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Database Exception");
		}
	}

	private void copyDtoToEntity(Enrollment entity, EnrollmentDTO dto) {
		entity.setAvailable(dto.isAvailable());
		entity.setEnrollMoment(dto.getEnrollMoment());
		entity.setOnlyUpdate(dto.isOnlyUpdate());

		User user = userRepository.getById(dto.getUserId());
		Course course = courseRepository.getById(dto.getCourseId());

		entity.setUser(user);
		entity.setCourse(course);

	}

}
