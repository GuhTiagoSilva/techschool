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

import com.stonks.techschool.dto.AreaDTO;
import com.stonks.techschool.services.AreaService;

@RestController
@RequestMapping(value = "/areas")
public class AreaController {

	@Autowired
	private AreaService service;
	
	@PostMapping
	public ResponseEntity<AreaDTO> insert(@RequestBody AreaDTO dto){
		AreaDTO areaDTO = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(areaDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(areaDTO);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<AreaDTO> update(@RequestBody AreaDTO dto, @PathVariable Long id){
		AreaDTO areaDTO = service.update(id, dto);
		return ResponseEntity.ok().body(areaDTO);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AreaDTO> findById(@PathVariable Long id){
		AreaDTO areaDTO = service.findById(id);
		return ResponseEntity.ok().body(areaDTO);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<Page<AreaDTO>> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy) {

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

		Page<AreaDTO> result = service.findAllPaged(pageRequest);

		return ResponseEntity.ok(result);
	}
	
}
