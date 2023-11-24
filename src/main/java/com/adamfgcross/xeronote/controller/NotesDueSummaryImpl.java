package com.adamfgcross.xeronote.controller;

import java.util.List;

import com.adamfgcross.xeronote.model.Note;

public class NotesDueSummaryImpl implements NotesDueSummary {
	private List<Note> notesDue;
	
	public List<Note> getNotesDue() {
		return this.notesDue;
	}
}
