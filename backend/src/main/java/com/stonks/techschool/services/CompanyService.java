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

import com.stonks.techschool.dto.CompanyDTO;
import com.stonks.techschool.dto.UserDTO;
import com.stonks.techschool.entities.Company;
import com.stonks.techschool.entities.User;
import com.stonks.techschool.repositories.CompanyRepository;
import com.stonks.techschool.repositories.UserRepository;
import com.stonks.techschool.services.exceptions.DatabaseException;
import com.stonks.techschool.services.exceptions.ResourceNotFoundException;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository repository;
	
	@Autowired
	private UserRepository userRepository;

	@Transactional
	public CompanyDTO insert(CompanyDTO dto) {
		Company entity = new Company();
		copyDtoToEntity(entity, dto);
		entity = repository.save(entity);
		return new CompanyDTO(entity, entity.getUsers());
	}
	
	@Transactional(readOnly = true)
	public CompanyDTO findById(Long id) {
		Optional<Company> result = repository.findById(id);
		Company entity = result.orElseThrow(() -> new ResourceNotFoundException("Id Not Found: " + id));
		return new CompanyDTO(entity);
	}
	
	@Transactional
	public CompanyDTO update(Long id, CompanyDTO dto) {
		try {
			Company entity = repository.getById(id);	
			copyDtoToEntity(entity, dto);
			entity = repository.save(entity);
			return new CompanyDTO(entity);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Entity Not Found");
		}	
	}
	
	@Transactional(readOnly = true)
	public Page<CompanyDTO> findAllPaged(PageRequest pageRequest) {
		Page<Company> list = repository.findAll(pageRequest);
		return list.map(company -> new CompanyDTO(company));
	}
	
	private void copyDtoToEntity(Company entity, CompanyDTO dto) {
		entity.setAddress(dto.getAddress());
		entity.setAddressComplement(dto.getAddressComplement());
		entity.setAddressNumber(dto.getAddressNumber());
		entity.setCnpj(dto.getCnpj());
		entity.setName(dto.getName());
		entity.getUsers().clear();
		for (UserDTO userDTO : dto.getUsers()) {
			User user = userRepository.getById(userDTO.getId());
			entity.getUsers().add(user);
		}
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
	
	
}
