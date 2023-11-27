package com.adamfgcross.xeronote.core;

import java.util.List;

import com.adamfgcross.xeronote.model.Note;

public interface NoteService <T extends Note> {
	public List<T> getNotes();
	public void addNote(T note);
	public void addAllNotes(List<T> notes);
}
