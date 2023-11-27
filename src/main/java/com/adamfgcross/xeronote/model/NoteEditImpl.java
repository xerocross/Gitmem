package com.adamfgcross.xeronote.model;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class NoteEditImpl implements NoteEdit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime dateTime;
	private String newHash;
	
	@ManyToOne
	@JoinColumn(name="note_id")
	private NoteImpl note;
	
	@Autowired
	public NoteEditImpl(LocalDateTime dateTime, NoteImpl note, String newHash) {
		this.dateTime = dateTime;
		this.note = note;
	}
	
	@Override
	public Note getNote() {
		return this.note;
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
