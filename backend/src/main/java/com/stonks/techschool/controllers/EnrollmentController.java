package com.stonks.techschool.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.stonks.techschool.dto.EnrollmentDTO;
import com.stonks.techschool.services.EnrollmentService;

@RestController
@RequestMapping(value = "/enrollments")
public class EnrollmentController {

	@Autowired
	private EnrollmentService service;
	
	@PostMapping
	public ResponseEntity<EnrollmentDTO> insert(@RequestBody EnrollmentDTO dto){
		EnrollmentDTO enrollmentDTO = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(enrollmentDTO.getUserId()).toUri();
		return ResponseEntity.created(uri).body(enrollmentDTO);
	}
	
	@GetMapping(value = "/users/{userId}/courses/{courseId}")
	public ResponseEntity<EnrollmentDTO> findById(@PathVariable Long userId, @PathVariable Long courseId){
		EnrollmentDTO dto = service.findById(userId, courseId);
		return ResponseEntity.ok().body(dto);
	}
	
	@PutMapping(value = "/users/{userId}/courses/{courseId}")
	public ResponseEntity<EnrollmentDTO> update (@PathVariable Long userId, @PathVariable Long courseId, @RequestBody EnrollmentDTO dto){
		dto = service.update(userId, courseId, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value = "/users/{userId}/courses/{courseId}")
	public ResponseEntity<Void> delete(@PathVariable Long userId, @PathVariable Long courseId){
		service.delete(userId, courseId);
		return ResponseEntity.noContent().build();
	}
	
}
