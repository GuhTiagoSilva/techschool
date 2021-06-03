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

import com.stonks.techschool.dto.RoleDTO;
import com.stonks.techschool.dto.UserDTO;
import com.stonks.techschool.dto.UserInsertDTO;
import com.stonks.techschool.dto.UserUpdateDTO;
import com.stonks.techschool.entities.Company;
import com.stonks.techschool.entities.Role;
import com.stonks.techschool.entities.User;
import com.stonks.techschool.repositories.CompanyRepository;
import com.stonks.techschool.repositories.RoleRepository;
import com.stonks.techschool.repositories.UserRepository;
import com.stonks.techschool.services.exceptions.DatabaseException;
import com.stonks.techschool.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Transactional
	public UserDTO insert(UserInsertDTO dto) {
		User entity = new User();
		copyDtoToEntity(entity, dto);
		entity.setPassword(dto.getPassword());
		entity = repository.save(entity);
		List<Role> roles = entity.getRoles().stream().collect(Collectors.toList());
		return new UserDTO(entity, roles.stream().collect(Collectors.toSet()));
	}
	
	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {
		Optional<User> result = repository.findById(id);
		User entity = result.orElseThrow(() -> new ResourceNotFoundException("Id Not Found: " + id));
		return new UserDTO(entity, entity.getRoles());
	}
	
	@Transactional
	public UserDTO update(Long id, UserUpdateDTO dto) {
		try {
			User entity = repository.getById(id);	
			copyDtoToEntity(entity, dto);
			entity = repository.save(entity);
			return new UserDTO(entity, entity.getRoles());
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Entity Not Found");
		}	
	}
	
	@Transactional(readOnly = true)
	public Page<UserDTO> findAllPaged(PageRequest pageRequest) {
		Page<User> list = repository.findAll(pageRequest);
		return list.map(user -> new UserDTO(user, user.getRoles()));
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
	
	private void copyDtoToEntity(User entity, UserDTO dto) {
		entity.setEmail(dto.getEmail());
		entity.setName(dto.getName());	
		entity.getRoles().clear();
		
		for(RoleDTO role : dto.getRoles()) {
			Role roleEntity = roleRepository.getById(role.getId());
			entity.getRoles().add(roleEntity);
		}
		
		Company company = companyRepository.getById(dto.getCompanyId());
		entity.setCompany(company);
	}
	
}
