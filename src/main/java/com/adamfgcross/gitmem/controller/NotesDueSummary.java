package com.adamfgcross.gitmem.controller;

import com.adamfgcross.gitmem.model.Note;
import java.util.List;

public interface NotesDueSummary {
	public List<Note> getNotesDue();
}
