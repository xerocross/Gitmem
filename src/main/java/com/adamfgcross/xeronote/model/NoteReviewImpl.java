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
public class NoteReviewImpl implements NoteReview {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "note_id")
	private NoteImpl note;
	
	private LocalDateTime dateTime;
	
	@Autowired
	public NoteReviewImpl (LocalDateTime dateTime, NoteImpl note) {
		this.dateTime = dateTime;
		this.note = note;
	}

	@Override
	public LocalDateTime getDateTime() {
		return dateTime;
	}
}
