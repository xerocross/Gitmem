package com.adamfgcross.gitmem.model;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class NoteEditImpl implements NoteEdit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime dateTime;
	private String newHash;
	
	public NoteEditImpl(LocalDateTime dateTime, String newHash) {
		this.dateTime = dateTime;
	}
	
	@Override
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	
	@Override
	public String getHash() {
		return this.newHash;
	}
}
