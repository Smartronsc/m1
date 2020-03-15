/*
 * =============================================================================
 *
 *   Copyright (c) 2020 RichardBradleySmith.com All Rights Reserved
 *
 * =============================================================================
 */
package com.androidcommand.app.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.androidcommand.app.CommonRepository;
import com.androidcommand.app.RantRave;
import com.androidcommand.app.RantRaveBuilder;
import com.androidcommand.app.validataion.RantRaveValidationError;
import com.androidcommand.app.validataion.RantRaveValidationErrorBuilder;

@RestController
@RequestMapping("/m1")                             
public class RantRaveController {
    
	private CommonRepository<RantRave> repository;
	
	@Autowired 
	public RantRaveController(CommonRepository<RantRave> repository) {
		this.repository = repository;
	}
	
	@GetMapping("/rantrave")
	public ResponseEntity<Iterable<RantRave>> getRantRaves() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/rantrave/{id}")
	public ResponseEntity<RantRave> getRantRaveByID(@PathVariable String id) {
		return ResponseEntity.ok(repository.findById(id));
	}
	
	@PatchMapping("/ranrtrave/{id}")
	public ResponseEntity<RantRave> setCompleted(@PathVariable String id) {
		RantRave result = repository.findById(id);
		result.setCompleted(true);
		repository.save(result);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(result.getId()).toUri();
		return ResponseEntity.ok().header("Location",location.toString()).build();
	}
	
	@RequestMapping(value="/rantrave", method = {RequestMethod.POST, RequestMethod.PUT})
	public ResponseEntity<?> createRantaRave(@Valid @RequestBody RantRave rantrave, Errors errors) {
		if (errors.hasErrors()) {
			return ResponseEntity.badRequest().body(RantRaveValidationErrorBuilder.fromBindingErrors(errors));
		}
	    RantRave result = repository.save(rantrave);
	    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getId()).toUri();
	    return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/rantrave/{id}")
	public ResponseEntity<RantRave> deletRantRave(@PathVariable String id) {
		repository.delete(RantRaveBuilder.create().withId(id).build());
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("rantrave")
	public ResponseEntity<RantRave> deleteRantRave(@RequestBody RantRave rantRave) {repository.delete(rantRave);
		repository.delete(rantRave);;
		return ResponseEntity.noContent().build();
	}
	
	@ExceptionHandler
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public RantRaveValidationError handleExecption(Exception execption) {
		return new RantRaveValidationError(execption.getMessage());
	}
   }
