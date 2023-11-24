package com.adamfgcross.gitmem.model;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class NoteImpl implements Note {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String notePath;
	private List<NoteReview> reviews;
	private List<NoteEdit> edits;
	
	
	public String getNotePath() {
		return notePath;
	}

	public void setNotePath(String notePath) {
		this.notePath = notePath;
	}

	public List<NoteReview> getReviews() {
		return reviews;
	}

	public void setReviews(List<NoteReview> reviews) {
		this.reviews = reviews;
	}

	public List<NoteEdit> getEdits() {
		return edits;
	}

	public void setEdits(List<NoteEdit> edits) {
		this.edits = edits;
	}
}
