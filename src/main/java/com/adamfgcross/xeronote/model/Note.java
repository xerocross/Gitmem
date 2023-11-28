package com.adamfgcross.xeronote.model;

import java.util.List;

public interface Note {

	public List<? extends NoteEdit> getEdits();
	public List<? extends NoteReview> getReviews();
	public String getHash();
	public void setHash(String hashString);
	public String getFileName();
	public String getNotePath();
}
