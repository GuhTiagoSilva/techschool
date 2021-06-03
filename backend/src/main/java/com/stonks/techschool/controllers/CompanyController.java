package com.stonks.techschool.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.stonks.techschool.dto.CompanyDTO;
import com.stonks.techschool.services.CompanyService;

@RestController
@RequestMapping(value = "/companies")
public class CompanyController {

	@Autowired
	private CompanyService service;
	
	@PostMapping
	public ResponseEntity<CompanyDTO> insert(@RequestBody CompanyDTO dto){
		CompanyDTO companyDTO = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(companyDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(companyDTO);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<CompanyDTO> update(@RequestBody CompanyDTO dto, @PathVariable Long id){
		CompanyDTO companyDTO = service.update(id, dto);
		return ResponseEntity.ok().body(companyDTO);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CompanyDTO> findById(@PathVariable Long id){
		CompanyDTO companyDTO = service.findById(id);
		return ResponseEntity.ok().body(companyDTO);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<Page<CompanyDTO>> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy) {

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

		Page<CompanyDTO> result = service.findAllPaged(pageRequest);

		return ResponseEntity.ok(result);
	}
}
