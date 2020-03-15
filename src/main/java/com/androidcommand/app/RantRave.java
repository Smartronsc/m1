package com.androidcommand.app;


import java.time.LocalDateTime;
import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class RantRave {
	@NotNull
	private String id;
	@NotNull
	@NotBlank
	private String description;
	private LocalDateTime created;
	private LocalDateTime modified;
	private boolean completed;
	
	public RantRave() {
	LocalDateTime date = LocalDateTime.now();
	this.id = UUID.randomUUID().toString();
	this.setCreated(date);
	this.setModified(date);
	}
	
	public RantRave(String description) {
		this();
		this.description = description;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public LocalDateTime getModified() {
		return modified;
	}

	public void setModified(LocalDateTime modified) {
		this.modified = modified;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public String getId() {
		return this.id;		
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}

