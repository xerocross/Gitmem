package com.adamfgcross.gitmem.controller;

import com.adamfgcross.gitmem.model.Note;
import java.util.List;

public class NotesDueSummaryImpl implements NotesDueSummary {
	private List<Note> notesDue;
	
	public List<Note> getNotesDue() {
		return this.notesDue;
	}
}
