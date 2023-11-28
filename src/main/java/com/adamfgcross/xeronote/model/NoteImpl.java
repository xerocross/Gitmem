package com.adamfgcross.xeronote.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import jakarta.persistence.*;

@Entity
public class NoteImpl implements Note {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String notePath;
	private String hash;
	private String fileName;
		
	@OneToMany(mappedBy = "note")
	private List<NoteReviewImpl> reviews;
	
	@OneToMany(mappedBy = "note")
	private List<NoteEditImpl> edits;
	
	@Override
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

	@Override
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
