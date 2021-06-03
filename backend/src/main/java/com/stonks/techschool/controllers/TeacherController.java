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

import com.stonks.techschool.dto.TeacherDTO;
import com.stonks.techschool.services.TeacherService;

@RestController
@RequestMapping(value = "/teachers")
public class TeacherController {

	@Autowired
	private TeacherService service;
	
	@PostMapping
	public ResponseEntity<TeacherDTO> insert(@RequestBody TeacherDTO dto){
		TeacherDTO teacherDTO = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(teacherDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(teacherDTO);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<TeacherDTO> update(@RequestBody TeacherDTO dto, @PathVariable Long id){
		TeacherDTO teacherDTO = service.update(id, dto);
		return ResponseEntity.ok().body(teacherDTO);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TeacherDTO> findById(@PathVariable Long id){
		TeacherDTO teacherDTO = service.findById(id);
		return ResponseEntity.ok().body(teacherDTO);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<Page<TeacherDTO>> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy) {

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

		Page<TeacherDTO> result = service.findAllPaged(pageRequest);

		return ResponseEntity.ok(result);
	}
	
}
