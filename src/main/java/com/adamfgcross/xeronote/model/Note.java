package com.adamfgcross.xeronote.model;

import java.util.List;

public interface Note {

	public List<NoteEdit> getEdits();
	public List<NoteReview> getReviews();
	public String getHash();
	
}
