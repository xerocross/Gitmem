package com.adamfgcross.gitmem.model;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class NoteReviewImpl implements NoteReview {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDateTime dateTime;
	
	public NoteReviewImpl (LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public LocalDateTime getDateTime() {
		return dateTime;
	}
}
