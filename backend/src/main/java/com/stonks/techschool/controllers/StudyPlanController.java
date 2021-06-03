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

import com.stonks.techschool.dto.StudyPlanDTO;
import com.stonks.techschool.services.StudyPlanService;

@RestController
@RequestMapping(value = "/studies")
public class StudyPlanController {

	@Autowired
	private StudyPlanService service;
	
	@PostMapping
	public ResponseEntity<StudyPlanDTO> insert(@RequestBody StudyPlanDTO dto){
		StudyPlanDTO studyPlanDTO = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(studyPlanDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(studyPlanDTO);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<StudyPlanDTO> update(@RequestBody StudyPlanDTO dto, @PathVariable Long id){
		StudyPlanDTO studyPlanDTO = service.update(id, dto);
		return ResponseEntity.ok().body(studyPlanDTO);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<StudyPlanDTO> findById(@PathVariable Long id){
		StudyPlanDTO studyPlanDTO = service.findById(id);
		return ResponseEntity.ok().body(studyPlanDTO);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<Page<StudyPlanDTO>> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy) {

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

		Page<StudyPlanDTO> result = service.findAllPaged(pageRequest);

		return ResponseEntity.ok(result);
	}
	
}
