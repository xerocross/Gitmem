package com.adamfgcross.xeronote.model;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;

@Entity
public class NoteImpl implements Note {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String notePath;
	private String hash;
	
	@OneToMany(mappedBy = "note")
	private List<NoteReviewImpl> reviews;
	
	@OneToMany(mappedBy = "note")
	private List<NoteEditImpl> edits;
	
	
	public String getNotePath() {
		return notePath;
	}
	
	public String getHash() {
		return hash;
	}
	
	public void setHash(String hash) {
		this.hash = hash;
	}

	public void setNotePath(String notePath) {
		this.notePath = notePath;
	}

	public List<NoteReviewImpl> getReviews() {
		return reviews;
	}

	public void setReviews(List<NoteReviewImpl> reviews) {
		this.reviews = reviews;
	}

	public List<NoteEditImpl> getEdits() {
		return edits;
	}

	public void setEdits(List<NoteEditImpl> edits) {
		this.edits = edits;
	}
}
