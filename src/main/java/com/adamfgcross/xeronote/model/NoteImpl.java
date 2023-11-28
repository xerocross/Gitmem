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
	// name is a unique identifier expected to be the initial part
	// of the filename without any extension
	private String name;
		
	@OneToMany(mappedBy = "note")
	private List<NoteReviewImpl> reviews = new ArrayList<NoteReviewImpl>();
	
	@OneToMany(mappedBy = "note")
	private List<NoteEditImpl> edits = new ArrayList<NoteEditImpl>();
	
	@OneToMany(mappedBy = "originNote", 
			cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<NoteLinkImpl> linkedNotes = new HashSet<NoteLinkImpl>();
	
	
	public void setLinkedNotes(Set<NoteLinkImpl> linkedNotes) {
		this.linkedNotes = linkedNotes;
	}
	
	public Set<NoteLinkImpl> getLinkedNotes() {
		return linkedNotes;
	}
	
	@Override
	public String getNotePath() {
		return notePath;
	}
	
	@Override
	public String getHash() {
		return hash;
	}
	
	public void setHash(String hash) {
		this.hash = hash;
	}

	public void setNotePath(String notePath) {
		this.notePath = notePath;
	}

	@Override
	public List<? extends NoteReview> getReviews() {
		return reviews;
	}

	public void setReviews(List<NoteReviewImpl> reviews) {
		this.reviews = reviews;
	}

	public List<? extends NoteEdit> getEdits() {
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

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
